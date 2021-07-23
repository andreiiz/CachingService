package it.unibo.chachingservice.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.model.GridFSFile;

import it.unibo.chachingservice.utils.CachingServiceConstants;
import it.unibo.chachingservice.utils.MultipartInputStreamFileResource;

@Service
public class ImageSenderService {

	private static final Logger logger = LogManager.getLogger(ImageSenderService.class);
	
	@Autowired
	private GridFsOperations operations;

	public void sendImageToAgent(List<GridFSFile> gridFsFiles, String url) throws Exception {
		logger.info("[START] ImageSenderService sendImageToAgent");
		for (GridFSFile gridFSFile : gridFsFiles) {
			byte[] responseImage = IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream());
			InputStream inputStream = new ByteArrayInputStream(responseImage);
			MultipartFile file = new MockMultipartFile(gridFSFile.getFilename(), gridFSFile.getFilename(),
					(String) gridFSFile.getMetadata().get(CachingServiceConstants.DatabaseProperites.CONTENT_TYPE),
					inputStream);
			this.sendImage(file, url);
		}
		logger.info("[END] ImageSenderService sendImageToAgent");
	}

	public String sendImage(MultipartFile file, String url) throws Exception {
		logger.info("[START] ImageSenderService sendImage");
		RestTemplate restTemplate = new RestTemplate();

		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		String response;

		try {
			if (!file.isEmpty()) {
				map.add("file",
						new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));
			}

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
			response = restTemplate.postForObject(url, requestEntity, String.class);

		} catch (HttpStatusCodeException exception) {
			logger.error(exception.getMessage(), exception);
			response = exception.getResponseBodyAsString();
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			response = exception.getMessage();
		}

		logger.info("[END] ImageSenderService sendImage");
		return response;
	}
}
