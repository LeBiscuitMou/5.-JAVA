package net.ent.etrs.rafale.model.facade.exceptions;

public class FacadeMetierException extends Exception {
    public FacadeMetierException(String message) {
        super(message);
    }

    public FacadeMetierException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeMetierException(Throwable cause) {
        super(cause);
    }

    public FacadeMetierException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
