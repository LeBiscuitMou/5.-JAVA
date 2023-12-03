package net.ent.etrs.emploi.model.entities.exceptions;

public class CoursException extends Exception {
    public CoursException(String message) {
        super(message);
    }

    public CoursException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoursException(Throwable cause) {
        super(cause);
    }

    public CoursException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
