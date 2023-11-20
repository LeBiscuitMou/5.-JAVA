package net.ent.etrs.groupeMusique.model.exception;

public class LieuException extends Exception {
    public LieuException(String message) {
        super(message);
    }

    public LieuException(String message, Throwable cause) {
        super(message, cause);
    }

    public LieuException(Throwable cause) {
        super(cause);
    }

    public LieuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
