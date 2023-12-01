package net.ent.etrs.poinsot.potion.model.entities.exceptions;

public class ContenantException extends Exception {
    public ContenantException(String message) {
        super(message);
    }

    public ContenantException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContenantException(Throwable cause) {
        super(cause);
    }

    public ContenantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}