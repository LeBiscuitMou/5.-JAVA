package net.ent.etrs.gestionrafale.view.facade.exception;

public class FacadeViewRafaleException extends Exception {
    public FacadeViewRafaleException(String message) {
        super(message);
    }

    public FacadeViewRafaleException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeViewRafaleException(Throwable cause) {
        super(cause);
    }

    public FacadeViewRafaleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
