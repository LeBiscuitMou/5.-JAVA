package net.ent.etrs.tresor.model.exceptions;

public class CoordonneeException extends Exception {
    public CoordonneeException(String message) {
        super(message);
    }

    public CoordonneeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoordonneeException(Throwable cause) {
        super(cause);
    }

    public CoordonneeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
