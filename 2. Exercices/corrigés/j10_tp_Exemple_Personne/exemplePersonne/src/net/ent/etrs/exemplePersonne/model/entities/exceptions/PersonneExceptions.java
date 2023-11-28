package net.ent.etrs.exemplePersonne.model.entities.exceptions;

public class PersonneExceptions extends Exception{
    public PersonneExceptions(String message) {
        super(message);
    }

    public PersonneExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonneExceptions(Throwable cause) {
        super(cause);
    }

    public PersonneExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
