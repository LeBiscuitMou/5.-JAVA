package net.ent.etrs.poinsot.potion.model.entities.exceptions;

public class PotionVieException extends Exception {
    public PotionVieException(String message) {
        super(message);
    }

    public PotionVieException(String message, Throwable cause) {
        super(message, cause);
    }

    public PotionVieException(Throwable cause) {
        super(cause);
    }

    public PotionVieException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}