package net.ent.etrs.poinsot.coffreFort.model.exceptions;

public class LockerNotOpenException extends Exception {
    public LockerNotOpenException(String message) {
        super(message);
    }

    public LockerNotOpenException(String message, Throwable cause) {
        super(message, cause);
    }

    public LockerNotOpenException(Throwable cause) {
        super(cause);
    }

    public LockerNotOpenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}