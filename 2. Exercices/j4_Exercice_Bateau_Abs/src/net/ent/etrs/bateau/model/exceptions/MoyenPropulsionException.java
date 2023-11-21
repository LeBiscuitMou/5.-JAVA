package net.ent.etrs.bateau.model.exceptions;

public class MoyenPropulsionException extends Exception {
    public MoyenPropulsionException(String message) {
        super(message);
    }

    public MoyenPropulsionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoyenPropulsionException(Throwable cause) {
        super(cause);
    }

    public MoyenPropulsionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
