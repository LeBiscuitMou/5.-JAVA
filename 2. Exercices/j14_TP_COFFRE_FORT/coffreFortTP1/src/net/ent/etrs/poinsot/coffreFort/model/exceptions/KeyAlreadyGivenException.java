package net.ent.etrs.poinsot.coffreFort.model.exceptions;

public class KeyAlreadyGivenException extends Exception {
    public KeyAlreadyGivenException(String message) {
        super(message);
    }

    public KeyAlreadyGivenException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeyAlreadyGivenException(Throwable cause) {
        super(cause);
    }

    public KeyAlreadyGivenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}