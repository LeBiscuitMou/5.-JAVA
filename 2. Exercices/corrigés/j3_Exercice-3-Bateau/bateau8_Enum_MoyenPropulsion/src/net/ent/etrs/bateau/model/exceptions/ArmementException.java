package net.ent.etrs.bateau.model.exceptions;

public class ArmementException extends Exception {
    public ArmementException(String message) {
        super(message);
    }

    public ArmementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArmementException(Throwable cause) {
        super(cause);
    }

    public ArmementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
