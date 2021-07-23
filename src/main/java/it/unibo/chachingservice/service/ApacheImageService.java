package it.unibo.chachingservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.unibo.chachingservice.config.ApacheConfig;

@Service
public class ApacheImageService {
	
	private static final Logger logger = LogManager.getLogger(ApacheImageService.class);
	
	@Autowired
	private ApacheConfig apacheConfig;

	public ResponseEntity<byte[]> getImage(String fileName) {	
		logger.info("[START] ApacheImageService getImage");
		RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        String url = this.apacheConfig.getUrl() + fileName;
        logger.info("[END] ApacheImageService getImage");
        return restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);
     }
}
