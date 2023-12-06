package net.ent.etrs.poinsot.coffreFort.model.exceptions;

public class LockerAlreadyOpenException extends Exception {
    public LockerAlreadyOpenException(String message) {
        super(message);
    }

    public LockerAlreadyOpenException(String message, Throwable cause) {
        super(message, cause);
    }

    public LockerAlreadyOpenException(Throwable cause) {
        super(cause);
    }

    public LockerAlreadyOpenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}