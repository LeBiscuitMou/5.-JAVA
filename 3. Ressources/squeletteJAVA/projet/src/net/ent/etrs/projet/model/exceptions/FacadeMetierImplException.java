package net.ent.etrs.projet.model.exceptions;

public class FacadeMetierImplException extends Exception{
    public FacadeMetierImplException(String message) {
        super(message);
    }

    public FacadeMetierImplException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeMetierImplException(Throwable cause) {
        super(cause);
    }

    public FacadeMetierImplException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
