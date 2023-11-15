package net.ent.etrs.musique.model.exceptions;

public class FanException extends Exception {
    public FanException(String message) {
        super(message);
    }

    public FanException(String message, Throwable cause) {
        super(message, cause);
    }

    public FanException(Throwable cause) {
        super(cause);
    }

    public FanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}