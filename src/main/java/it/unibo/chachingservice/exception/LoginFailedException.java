package it.unibo.chachingservice.exception;

public class LoginFailedException extends RuntimeException {
	
	private static final long serialVersionUID = -7671146213517051330L;

	public LoginFailedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}