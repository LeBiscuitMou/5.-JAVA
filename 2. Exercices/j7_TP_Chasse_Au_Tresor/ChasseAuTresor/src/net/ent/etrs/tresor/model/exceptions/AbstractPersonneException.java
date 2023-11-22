package net.ent.etrs.tresor.model.exceptions;

public class AbstractPersonneException extends Exception {
    public AbstractPersonneException(String message) {
        super(message);
    }

    public AbstractPersonneException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractPersonneException(Throwable cause) {
        super(cause);
    }

    public AbstractPersonneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
