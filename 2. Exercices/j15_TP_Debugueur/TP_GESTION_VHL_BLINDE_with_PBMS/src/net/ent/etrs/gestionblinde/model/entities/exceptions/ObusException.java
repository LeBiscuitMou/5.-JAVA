package net.ent.etrs.gestionblinde.model.entities.exceptions;

public class ObusException extends Exception {
    public ObusException(String message) {
        super(message);
    }

    public ObusException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObusException(Throwable cause) {
        super(cause);
    }

    public ObusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}