package net.ent.etrs.tresor.model.exceptions;

public class ChasseAuTresorException extends Exception {
    public ChasseAuTresorException(String message) {
        super(message);
    }

    public ChasseAuTresorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChasseAuTresorException(Throwable cause) {
        super(cause);
    }

    public ChasseAuTresorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
