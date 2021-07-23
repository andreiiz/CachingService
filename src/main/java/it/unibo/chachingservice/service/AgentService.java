package it.unibo.chachingservice.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import it.unibo.chachingservice.config.ControllerConfig;
import it.unibo.chachingservice.entity.iofog.LoginRequest;
import it.unibo.chachingservice.entity.iofog.LoginResponse;
import it.unibo.chachingservice.entity.iofog.NodeIoFogListResponse;
import it.unibo.chachingservice.exception.LoginFailedException;

@Service
public class AgentService {

	private static final Logger logger = LogManager.getLogger(AgentService.class);

	@Autowired
	private ControllerConfig controllerConfig;

	public LoginResponse getAccessToken() throws URISyntaxException, LoginFailedException {
		logger.info("[START] AgentService getAccessToken");
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(this.controllerConfig.getLoginurl());
		LoginRequest loginRequest = new LoginRequest(this.controllerConfig.getEmail(),
				this.controllerConfig.getPassword());

		ResponseEntity<LoginResponse> result = restTemplate.postForEntity(uri, loginRequest, LoginResponse.class);
		logger.info("[END] AgentService getAccessToken");
		if (result.getStatusCode() == HttpStatus.OK) {
			logger.info("getAccessToken http call OK");
			return result.getBody();
		} else {
			logger.info("getAccessToken http call KO");
			throw new LoginFailedException("login failed status code: " + result.getStatusCode().toString(), null);
		}
	}

	public NodeIoFogListResponse getNodeIoFogList(LoginResponse loginResponse)
			throws URISyntaxException, LoginFailedException {
		logger.info("[START] AgentService getNodeIoFogList");
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(this.controllerConfig.getIofoglisturl());
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization", loginResponse.getAccessToken());
		ResponseEntity<NodeIoFogListResponse> result = restTemplate.exchange(uri, HttpMethod.GET,
				new HttpEntity<NodeIoFogListResponse>(headers), NodeIoFogListResponse.class);

		logger.info("[END] AgentService getNodeIoFogList");
		if (result.getStatusCode() == HttpStatus.OK) {
			logger.info("getNodeIoFogList http call OK");
			return result.getBody();
		} else {
			logger.info("getNodeIoFogList http call KO");
			throw new LoginFailedException("login failed status code: " + result.getStatusCode().toString(), null);
		}
	}
}
