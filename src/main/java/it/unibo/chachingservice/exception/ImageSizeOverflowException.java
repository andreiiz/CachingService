package it.unibo.chachingservice.exception;

public class ImageSizeOverflowException extends RuntimeException {
	
	private static final long serialVersionUID = 8106952034593305378L;

	public ImageSizeOverflowException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

	public ImageSizeOverflowException() {
		super();
	}

	public ImageSizeOverflowException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ImageSizeOverflowException(String message) {
		super(message);
	}

	public ImageSizeOverflowException(Throwable cause) {
		super(cause);
	}
	
	
}