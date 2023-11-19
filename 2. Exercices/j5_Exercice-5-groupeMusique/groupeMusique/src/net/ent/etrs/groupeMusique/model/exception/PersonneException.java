package net.ent.etrs.groupeMusique.model.exception;

public class PersonneException extends Exception{
    public PersonneException(String message) {
        super(message);
    }

    public PersonneException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonneException(Throwable cause) {
        super(cause);
    }

    public PersonneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
