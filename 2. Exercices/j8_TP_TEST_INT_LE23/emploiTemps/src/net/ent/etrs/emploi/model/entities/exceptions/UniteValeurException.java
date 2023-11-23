package net.ent.etrs.emploi.model.entities.exceptions;

public class UniteValeurException extends Exception {
    public UniteValeurException(String message) {
        super(message);
    }

    public UniteValeurException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniteValeurException(Throwable cause) {
        super(cause);
    }

    public UniteValeurException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
