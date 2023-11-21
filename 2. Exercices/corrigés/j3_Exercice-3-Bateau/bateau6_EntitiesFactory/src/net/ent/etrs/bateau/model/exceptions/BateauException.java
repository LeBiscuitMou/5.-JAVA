package net.ent.etrs.bateau.model.exceptions;

public class BateauException extends Exception {
    public BateauException(String message) {
        super(message);
    }

    public BateauException(String message, Throwable cause) {
        super(message, cause);
    }

    public BateauException(Throwable cause) {
        super(cause);
    }

    public BateauException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
