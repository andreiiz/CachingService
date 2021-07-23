package it.unibo.chachingservice.scheduler;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.client.gridfs.model.GridFSFile;

import it.unibo.chachingservice.config.AgentConfig;
import it.unibo.chachingservice.entity.Agent;
import it.unibo.chachingservice.entity.iofog.LoginResponse;
import it.unibo.chachingservice.entity.iofog.NodeIoFogListResponse;
import it.unibo.chachingservice.entity.iofog.NodeIoFogResponse;
import it.unibo.chachingservice.exception.LoginFailedException;
import it.unibo.chachingservice.repository.AgentRepository;
import it.unibo.chachingservice.service.AgentService;
import it.unibo.chachingservice.service.GridFsService;
import it.unibo.chachingservice.service.ImageSenderService;
import it.unibo.chachingservice.utils.GeoUtils;

public class ProximityJob implements Job {

    private static final Logger logger = LogManager.getLogger(ProximityJob.class);
	
	@Autowired
	private AgentService agentService;

	@Autowired
	private AgentConfig agentConfig;
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private ImageSenderService imageSenderService;
	
	@Autowired
	private GridFsService gridFsService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("[START] ProximityJob execute");
		try {
			LoginResponse loginResponse = this.agentService.getAccessToken();
			NodeIoFogListResponse nodeIoFogListResponse = this.agentService.getNodeIoFogList(loginResponse);
			
			NodeIoFogResponse thisNode = null;
			List<NodeIoFogResponse> otherNodes = new ArrayList<>();
			
			for(NodeIoFogResponse node : nodeIoFogListResponse.getFogs()) {
				if(node.getUuid().equalsIgnoreCase(this.agentConfig.getUuid())) {
					thisNode = node;
				} else {
					otherNodes.add(node);
				}
			}
			
			if(thisNode != null && !otherNodes.isEmpty()) {
				for(NodeIoFogResponse node : otherNodes) {
					if(GeoUtils.isNodeNear(thisNode.getLatitude(), thisNode.getLongitude(), 
							node.getLatitude(), node.getLongitude(), 
							this.agentConfig.getCircle(), this.agentConfig.getTargetcircle())) {
						
						Agent agent = this.agentRepository.findByName(node.getName());
						String url = agent.getUrl() + "/upload/uploadImage";
						logger.info("Generated url: {}", url);
						
						List<GridFSFile> gridFsFiles = this.gridFsService.getLastAccessedImageByPercentage(10);
						try {
							this.imageSenderService.sendImageToAgent(gridFsFiles, url);
						} catch (Exception exception) {
							logger.error(exception.getMessage(), exception);
						}
						
						logger.info("{} is near targetNode", node.getName());
					} else {
						logger.info("{} is not near targetNode", node.getName());
					}
				}
			}
			logger.info("[END] ProximityJob execute");
		} catch (LoginFailedException exception) {
			logger.error(exception.getMessage(), exception);
			logger.error("[END] ProximityJob execute");
		} catch (URISyntaxException exception) {
			logger.error(exception.getMessage(), exception);
			logger.error("[END] ProximityJob execute");
		}
	}

}
