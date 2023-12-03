package net.ent.etrs.poinsot.potion.model.entities.exceptions;

public class PotionException extends Exception {
    public PotionException(String message) {
        super(message);
    }

    public PotionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PotionException(Throwable cause) {
        super(cause);
    }

    public PotionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}