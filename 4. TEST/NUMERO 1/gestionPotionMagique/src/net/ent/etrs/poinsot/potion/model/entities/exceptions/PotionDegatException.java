package net.ent.etrs.poinsot.potion.model.entities.exceptions;

public class PotionDegatException extends Exception {
    public PotionDegatException(String message) {
        super(message);
    }

    public PotionDegatException(String message, Throwable cause) {
        super(message, cause);
    }

    public PotionDegatException(Throwable cause) {
        super(cause);
    }

    public PotionDegatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}