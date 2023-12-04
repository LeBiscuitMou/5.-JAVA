package net.ent.etrs.arene.model.exceptions;

public class ThraceException extends Exception {
    public ThraceException(String message) {
        super(message);
    }

    public ThraceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThraceException(Throwable cause) {
        super(cause);
    }

    public ThraceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}