package it.unibo.chachingservice.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;

import it.unibo.chachingservice.config.CachingConfig;
import it.unibo.chachingservice.entity.FsFiles;
import it.unibo.chachingservice.exception.ImageNotFoundOnApacheException;
import it.unibo.chachingservice.exception.ImageSizeOverflowException;
import it.unibo.chachingservice.repository.FsFilesRepository;
import it.unibo.chachingservice.utils.CachingServiceConstants;
import it.unibo.chachingservice.utils.Utils;

@Service
public class  GridFsService {

	private static final Logger logger = LogManager.getLogger(GridFsService.class);
	
	@Autowired
	private CachingConfig cachingConfig;
	
	@Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;
    
    @Autowired
    private FsFilesRepository fsFilesRepository;
    
    @Autowired
    private ApacheImageService apacheImageService;

    public String uploadCachedFile(MultipartFile file) throws IOException { 
        ObjectId id = saveNewFileInGridFs(file); 
        return id.toString(); 
    }

    public byte[] getCachedFileByFileName(String fileName) throws IllegalStateException, IOException, ImageNotFoundOnApacheException, ImageSizeOverflowException { 
    	logger.info("[START] GridFsService getCachedFileByFileName");
    	byte[] responseImage = null;
    	GridFSFile file = this.gridFsTemplate.findOne(new Query(Criteria.where(CachingServiceConstants.DatabaseProperites.FILE_NAME).is(fileName)));

    	if(file != null) {
    		increaseAccessesNumber(file);
    		responseImage = IOUtils.toByteArray(operations.getResource(file).getInputStream());    		
    	} else {
			ResponseEntity<byte[]> response = this.apacheImageService.getImage(fileName);
			if(response.getStatusCode() == HttpStatus.OK) {
				InputStream inputStream = new ByteArrayInputStream(response.getBody());
				MultipartFile downloadedFile = new MockMultipartFile(fileName, fileName, response.getHeaders().getContentType().toString(), inputStream);
				
				while(!this.isThereMemory(downloadedFile.getSize())) {
					this.deleteLastAccessedImage();
				}
				
				responseImage = this.uploadCachedFileAndReturnByte(downloadedFile);
			} else {
				throw new ImageNotFoundOnApacheException(fileName + " not found on Apache", null);
			}
    	}
    	logger.info("[END] GridFsService getCachedFileByFileName");
    	return responseImage;
    }

	public List<GridFSFile> getLastAccessedImageByPercentage(Integer percentage) {
		logger.info("[START] GridFsService getLastAccessedImageByPercentage {}", percentage);
		GridFSFindIterable gridFsFileIterable = this.gridFsTemplate.find(this.getLastMostAccessedFileQuery());
		List<GridFSFile> gridFsFileList = new ArrayList<>();
		List<GridFSFile> resultGridFsFileList = new ArrayList<>();
		gridFsFileIterable.forEach(gridFsFileList::add);
		
		if(!gridFsFileList.isEmpty()) {
			double resultNumber = ((double)gridFsFileList.size() / (double)100) * (double)percentage;

			for(Integer i = 0; i < resultNumber; i++) {
				resultGridFsFileList.add(gridFsFileList.get(i));
			}			
		}

		logger.info("[END] GridFsService getCachedFileByFileName");
		return resultGridFsFileList;
	}

	private Query getLastUpdateDateFileQuery() {
		Query query = new Query();
        query.limit(1);
        query.with(
        Sort.by(Sort.Direction.ASC, "metadata.accessDate"));
		return query;
	}

	private Query getLastMostAccessedFileQuery() {
		Query query = new Query();
		query.limit(1000);
		query.with(
				Sort.by(Sort.Direction.DESC, "metadata.accessesNumber"));
		return query;
	}

	private void deleteLastAccessedImage() {
    	this.gridFsTemplate.delete(this.getLastUpdateDateFileQuery());
	}

	private void increaseAccessesNumber(GridFSFile file) {
		Optional<FsFiles> optionalFsFile = this.fsFilesRepository.findById(file.getObjectId());
		if(optionalFsFile.isPresent()) {
			FsFiles fsFile = optionalFsFile.get();
    		Document metaData = fsFile.getMetadata();
    		Integer accessesNumeber = (Integer)metaData.get(CachingServiceConstants.DatabaseProperites.ACCESSES_NUMBER);
    		accessesNumeber++;
    		metaData.put(CachingServiceConstants.DatabaseProperites.ACCESSES_NUMBER, accessesNumeber);
    		metaData.put(CachingServiceConstants.DatabaseProperites.ACCESS_DATE, new Date());
    		fsFile.setMetadata(metaData);	
    		this.fsFilesRepository.save(fsFile);
		} else {
			logger.error("Error in accessesTime");
		}
	}
	
	private ObjectId saveNewFileInGridFs(MultipartFile file) throws IOException {
		DBObject metaData = new BasicDBObject(); 
        metaData.put(CachingServiceConstants.DatabaseProperites.ACCESSES_NUMBER, 
        		this.cachingConfig.getInitialaccessnumber());
        metaData.put(CachingServiceConstants.DatabaseProperites.ACCESS_DATE, 
        		new Date());
        return gridFsTemplate.store(
          file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metaData);
	}

    private byte[] uploadCachedFileAndReturnByte(MultipartFile file) throws IOException { 
    	this.saveNewFileInGridFs(file); 
    	return IOUtils.toByteArray(file.getInputStream());
    }
    
    private Boolean isThereMemory(long newFileLength) throws ImageSizeOverflowException {
    	long totalDbLegth = 0;
    	List<FsFiles> fsFilesList =  this.fsFilesRepository.findAll();
    	for(FsFiles fsFile : fsFilesList) {	
    		totalDbLegth += fsFile.getLength();
    	};
    	long newLengthDb = (totalDbLegth + newFileLength);
    	long propertiesLength = Utils.mbToBytes(this.cachingConfig.getTotaldblength());

    	logger.info("File length: {}", newFileLength);
    	logger.info("Db Length: {}", totalDbLegth);
    	logger.info("newLengthDb: {}", newLengthDb);
    	logger.info("propertiesLength: {}", propertiesLength);
    	logger.info("{} <= {}", newLengthDb, propertiesLength);

    	if(newFileLength > propertiesLength) {
    		throw new ImageSizeOverflowException("Target image dimension is > maximum db size");    		
    	}
    	
    	return (newLengthDb <= propertiesLength);
    }
}
