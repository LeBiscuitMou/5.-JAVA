package net.ent.etrs.poinsot.potion.model.entities.exceptions;

public class PotionAmeliorationException extends Exception {
    public PotionAmeliorationException(String message) {
        super(message);
    }

    public PotionAmeliorationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PotionAmeliorationException(Throwable cause) {
        super(cause);
    }

    public PotionAmeliorationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}