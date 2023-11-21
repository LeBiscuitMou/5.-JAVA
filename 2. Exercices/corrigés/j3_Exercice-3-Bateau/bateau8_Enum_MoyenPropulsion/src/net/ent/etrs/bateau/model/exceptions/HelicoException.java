package net.ent.etrs.bateau.model.exceptions;

public class HelicoException extends Exception {

    public HelicoException(String message) {
        super(message);
    }

    public HelicoException(String message, Throwable cause) {
        super(message, cause);
    }

    public HelicoException(Throwable cause) {
        super(cause);
    }

    public HelicoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
