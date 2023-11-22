package net.ent.etrs.rafale.model.entities.exceptions;

public class RafaleException extends Exception {
    public RafaleException(String message) {
        super(message);
    }

    public RafaleException(String message, Throwable cause) {
        super(message, cause);
    }

    public RafaleException(Throwable cause) {
        super(cause);
    }

    public RafaleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
