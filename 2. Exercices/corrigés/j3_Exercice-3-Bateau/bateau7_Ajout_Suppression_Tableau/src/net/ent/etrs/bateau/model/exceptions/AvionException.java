package net.ent.etrs.bateau.model.exceptions;

public class AvionException extends Exception {
    public AvionException(String message) {
        super(message);
    }

    public AvionException(String message, Throwable cause) {
        super(message, cause);
    }

    public AvionException(Throwable cause) {
        super(cause);
    }

    public AvionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
