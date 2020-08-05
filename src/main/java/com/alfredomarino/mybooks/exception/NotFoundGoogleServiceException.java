package com.alfredomarino.mybooks.exception;

public class NotFoundGoogleServiceException extends RuntimeException {

    public NotFoundGoogleServiceException() {
        super();
    }

    public NotFoundGoogleServiceException(String message) {
        super(message);
    }

    public NotFoundGoogleServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundGoogleServiceException(Throwable cause) {
        super(cause);
    }

    protected NotFoundGoogleServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
