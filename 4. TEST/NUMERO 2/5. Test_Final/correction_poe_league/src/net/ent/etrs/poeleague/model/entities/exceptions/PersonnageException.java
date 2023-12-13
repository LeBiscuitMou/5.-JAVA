package net.ent.etrs.poeleague.model.entities.exceptions;

public class PersonnageException extends Exception {
    public PersonnageException(String message) {
        super(message);
    }

    public PersonnageException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonnageException(Throwable cause) {
        super(cause);
    }

    public PersonnageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
