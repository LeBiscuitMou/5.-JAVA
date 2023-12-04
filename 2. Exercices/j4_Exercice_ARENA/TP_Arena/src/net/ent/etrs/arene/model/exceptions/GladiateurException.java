package net.ent.etrs.arene.model.exceptions;

public class GladiateurException extends Exception {
    public GladiateurException(String message) {
        super(message);
    }

    public GladiateurException(String message, Throwable cause) {
        super(message, cause);
    }

    public GladiateurException(Throwable cause) {
        super(cause);
    }

    public GladiateurException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}