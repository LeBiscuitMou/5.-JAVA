package net.ent.etrs.exemplePersonne.model.entities.exceptions;

public class EntitiesFactoryExceptions extends Exception{
    public EntitiesFactoryExceptions(String message) {
        super(message);
    }

    public EntitiesFactoryExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public EntitiesFactoryExceptions(Throwable cause) {
        super(cause);
    }

    public EntitiesFactoryExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
