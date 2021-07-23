package it.unibo.chachingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "controller")
public class ControllerConfig {

	private String email;
	private String password;
	private String loginurl;
	private String iofogurl;
	private String iofoglisturl;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginurl() {
		return loginurl;
	}

	public void setLoginurl(String loginurl) {
		this.loginurl = loginurl;
	}

	public String getIofogurl() {
		return iofogurl;
	}

	public void setIofogurl(String iofogurl) {
		this.iofogurl = iofogurl;
	}

	public String getIofoglisturl() {
		return iofoglisturl;
	}

	public void setIofoglisturl(String iofoglisturl) {
		this.iofoglisturl = iofoglisturl;
	}
}
