package it.unibo.chachingservice.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.unibo.chachingservice.exception.ImageNotFoundOnApacheException;
import it.unibo.chachingservice.service.GridFsService;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("upload")
public class CachingController {
	
    private static final Logger logger = LogManager.getLogger(CachingController.class);
	
	@Autowired
	private GridFsService gridFsService;
	
	@PostMapping(value = "/uploadImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> uploadGridFs(@RequestParam("file") MultipartFile file) throws IOException {
		logger.info("[START] controller uploadImage");
		try {
			String cachedFileId = this.gridFsService.uploadCachedFile(file);			
			logger.info("[END] controller uploadImage");
			return new ResponseEntity<>(
			          "File correctly uploaded with id " + cachedFileId, 
			          HttpStatus.OK);
		} catch(Exception exception) {
			logger.error(exception.getMessage(), exception);
			return new ResponseEntity<>(
			          exception.getMessage(), 
			          HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/downloadImage/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
		logger.info("[START] controller downloadImage");
		try {		
			byte[] result = this.gridFsService.getCachedFileByFileName(fileName);
			logger.info("[END] controller downloadImage");
			return new ResponseEntity<>(
					  result, 
			          HttpStatus.OK);
		} catch(ImageNotFoundOnApacheException exception) {
			logger.error(exception.getMessage(), exception);
			return new ResponseEntity<>(
			          HttpStatus.NOT_FOUND);
		}
		catch(Exception exception) {
			logger.error(exception.getMessage(), exception);
			return new ResponseEntity<>(
			          HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
