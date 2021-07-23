package it.unibo.chachingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "quartz")
public class QuartzProperties {

	private Boolean schedulerFactory;
	private Integer triggerTimeInminutes;

	public Boolean getSchedulerFactory() {
		return schedulerFactory;
	}

	public void setSchedulerFactory(Boolean schedulerFactory) {
		this.schedulerFactory = schedulerFactory;
	}

	public Integer getTriggerTimeInminutes() {
		return triggerTimeInminutes;
	}

	public void setTriggerTimeInminutes(Integer triggerTimeInminutes) {
		this.triggerTimeInminutes = triggerTimeInminutes;
	}
}
