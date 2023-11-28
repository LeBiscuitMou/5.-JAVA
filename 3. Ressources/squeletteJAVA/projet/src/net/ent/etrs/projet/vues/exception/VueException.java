package net.ent.etrs.projet.vues.exception;

public class VueException extends Exception{
    public VueException(String message) {
        super(message);
    }

    public VueException(String message, Throwable cause) {
        super(message, cause);
    }

    public VueException(Throwable cause) {
        super(cause);
    }

    public VueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
