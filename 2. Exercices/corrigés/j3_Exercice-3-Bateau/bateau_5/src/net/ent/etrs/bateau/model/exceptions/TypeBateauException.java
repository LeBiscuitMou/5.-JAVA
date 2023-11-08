package net.ent.etrs.bateau.model.exceptions;

public class TypeBateauException extends Exception {
    public TypeBateauException(String message) {
        super(message);
    }

    public TypeBateauException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeBateauException(Throwable cause) {
        super(cause);
    }

    public TypeBateauException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
