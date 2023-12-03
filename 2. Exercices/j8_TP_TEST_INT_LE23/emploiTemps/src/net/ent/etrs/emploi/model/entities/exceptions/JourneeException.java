package net.ent.etrs.emploi.model.entities.exceptions;

public class JourneeException extends Exception {
    public JourneeException(String message) {
        super(message);
    }

    public JourneeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JourneeException(Throwable cause) {
        super(cause);
    }

    public JourneeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
