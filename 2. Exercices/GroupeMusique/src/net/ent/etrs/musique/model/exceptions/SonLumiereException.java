package net.ent.etrs.musique.model.exceptions;

public class SonLumiereException extends Exception {
    public SonLumiereException(String message) {
        super(message);
    }

    public SonLumiereException(String message, Throwable cause) {
        super(message, cause);
    }

    public SonLumiereException(Throwable cause) {
        super(cause);
    }

    public SonLumiereException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}