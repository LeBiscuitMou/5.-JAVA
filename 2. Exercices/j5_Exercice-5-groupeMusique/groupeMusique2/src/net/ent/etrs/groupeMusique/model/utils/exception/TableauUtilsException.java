package net.ent.etrs.groupeMusique.model.utils.exception;

public class TableauUtilsException extends Exception {
    public TableauUtilsException(String message) {
        super(message);
    }

    public TableauUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableauUtilsException(Throwable cause) {
        super(cause);
    }

    public TableauUtilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
