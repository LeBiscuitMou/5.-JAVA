package net.ent.etrs.poinsot.coffreFort.model.exceptions;

public class CoffreFortException extends Exception {
    public CoffreFortException(String message) {
        super(message);
    }

    public CoffreFortException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffreFortException(Throwable cause) {
        super(cause);
    }

    public CoffreFortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}