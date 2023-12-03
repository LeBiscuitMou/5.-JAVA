package net.ent.etrs.emploi.model.entities.exceptions;

public class MatiereException extends Exception {
    public MatiereException(String message) {
        super(message);
    }

    public MatiereException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatiereException(Throwable cause) {
        super(cause);
    }

    public MatiereException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
