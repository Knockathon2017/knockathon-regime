package com.exzeo.exception;

/**
 * Created by dhruvr on 10/9/15.
 */
public class RegimeException extends RuntimeException {
    public RegimeException() {
        super();
    }

    public RegimeException(String message) {
        super(message);
    }

    public RegimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegimeException(Throwable cause) {
        super(cause);
    }

    protected RegimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
