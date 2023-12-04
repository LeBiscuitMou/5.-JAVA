package net.ent.etrs.arene.model.exceptions;

public class CrepulaireException extends Exception {
    public CrepulaireException(String message) {
        super(message);
    }

    public CrepulaireException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrepulaireException(Throwable cause) {
        super(cause);
    }

    public CrepulaireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}