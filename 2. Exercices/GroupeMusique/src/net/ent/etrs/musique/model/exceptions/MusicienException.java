package net.ent.etrs.musique.model.exceptions;

public class MusicienException extends Exception {
    public MusicienException(String message) {
        super(message);
    }

    public MusicienException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusicienException(Throwable cause) {
        super(cause);
    }

    public MusicienException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
