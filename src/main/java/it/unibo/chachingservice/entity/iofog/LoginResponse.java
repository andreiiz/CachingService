package it.unibo.chachingservice.entity.iofog;

public class LoginResponse {

	private String accessToken;

	public LoginResponse() {
		super();
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "LoginResponse [accessToken=" + accessToken + "]";
	}
}
