package net.ent.etrs.tresor.model.exceptions;

public class JoueurException extends Exception {
    public JoueurException(String message) {
        super(message);
    }

    public JoueurException(String message, Throwable cause) {
        super(message, cause);
    }

    public JoueurException(Throwable cause) {
        super(cause);
    }

    public JoueurException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
