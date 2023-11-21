package net.ent.etrs.groupeMusique.model.exception;

public class ConcertException extends Exception {
    public ConcertException(String message) {
        super(message);
    }

    public ConcertException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConcertException(Throwable cause) {
        super(cause);
    }

    public ConcertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
