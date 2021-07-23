package it.unibo.chachingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "caching")
public class CachingConfig {

	private Integer initialaccessnumber;
	private Integer totaldblength;

	public Integer getInitialaccessnumber() {
		return initialaccessnumber;
	}

	public void setInitialaccessnumber(Integer initialaccessnumber) {
		this.initialaccessnumber = initialaccessnumber;
	}

	public Integer getTotaldblength() {
		return totaldblength;
	}

	public void setTotaldblength(Integer totaldblength) {
		this.totaldblength = totaldblength;
	}
}
