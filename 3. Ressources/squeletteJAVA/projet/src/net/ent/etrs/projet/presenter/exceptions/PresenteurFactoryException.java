package net.ent.etrs.projet.presenter.exceptions;

public class PresenteurFactoryException extends Exception{
    public PresenteurFactoryException(String message) {
        super(message);
    }

    public PresenteurFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public PresenteurFactoryException(Throwable cause) {
        super(cause);
    }

    public PresenteurFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
