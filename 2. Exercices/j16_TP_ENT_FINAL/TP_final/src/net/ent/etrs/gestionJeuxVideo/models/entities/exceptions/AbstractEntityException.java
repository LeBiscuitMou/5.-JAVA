package net.ent.etrs.gestionJeuxVideo.models.entities.exceptions;

public class AbstractEntityException extends Exception {
    public AbstractEntityException(String message) {
        super(message);
    }

    public AbstractEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractEntityException(Throwable cause) {
        super(cause);
    }

    public AbstractEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}