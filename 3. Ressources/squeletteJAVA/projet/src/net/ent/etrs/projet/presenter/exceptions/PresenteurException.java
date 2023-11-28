package net.ent.etrs.projet.presenter.exceptions;

public class PresenteurException extends Exception{
    public PresenteurException(String message) {
        super(message);
    }

    public PresenteurException(String message, Throwable cause) {
        super(message, cause);
    }

    public PresenteurException(Throwable cause) {
        super(cause);
    }

    public PresenteurException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
