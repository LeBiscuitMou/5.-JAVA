package net.ent.etrs.arene.model.exceptions;

public class MirmillonException extends Exception {
    public MirmillonException(String message) {
        super(message);
    }

    public MirmillonException(String message, Throwable cause) {
        super(message, cause);
    }

    public MirmillonException(Throwable cause) {
        super(cause);
    }

    public MirmillonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
