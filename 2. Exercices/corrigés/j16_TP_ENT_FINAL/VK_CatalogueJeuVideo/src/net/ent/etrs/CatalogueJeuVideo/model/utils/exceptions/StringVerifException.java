package net.ent.etrs.CatalogueJeuVideo.model.utils.exceptions;

public class StringVerifException extends Exception{
    public StringVerifException(String message) {
        super(message);
    }

    public StringVerifException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringVerifException(Throwable cause) {
        super(cause);
    }

    public StringVerifException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
