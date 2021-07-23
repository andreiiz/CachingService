package it.unibo.chachingservice.exception;

public class ImageNotFoundOnApacheException extends RuntimeException {
	
	private static final long serialVersionUID = -3576588143601689555L;

	public ImageNotFoundOnApacheException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}