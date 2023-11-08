package net.ent.etrs.bateau.model.exceptions;

public class FregateException extends Exception {
    public FregateException(String message) {
        super(message);
    }

    public FregateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FregateException(Throwable cause) {
        super(cause);
    }

    public FregateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}