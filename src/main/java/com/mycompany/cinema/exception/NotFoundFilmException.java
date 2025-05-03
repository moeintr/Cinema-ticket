package com.mycompany.cinema.exception;

public class NotFoundFilmException extends RuntimeException {
    public NotFoundFilmException() {
    }

    public NotFoundFilmException(String message) {
        super(message);
    }

    public NotFoundFilmException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundFilmException(Throwable cause) {
        super(cause);
    }

    public NotFoundFilmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
