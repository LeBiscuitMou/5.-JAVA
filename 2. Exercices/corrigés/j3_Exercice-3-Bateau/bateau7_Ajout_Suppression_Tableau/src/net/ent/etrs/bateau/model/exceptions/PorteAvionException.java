package net.ent.etrs.bateau.model.exceptions;

public class PorteAvionException extends Exception {
    public PorteAvionException(String message) {
        super(message);
    }

    public PorteAvionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PorteAvionException(Throwable cause) {
        super(cause);
    }

    public PorteAvionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
