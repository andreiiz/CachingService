package it.unibo.chachingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "agent")
public class AgentConfig {

	private String uuid;
	private double circle;
	private double targetcircle;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public double getCircle() {
		return circle;
	}

	public void setCircle(double circle) {
		this.circle = circle;
	}

	public double getTargetcircle() {
		return targetcircle;
	}

	public void setTargetcircle(double targetcircle) {
		this.targetcircle = targetcircle;
	}
}
