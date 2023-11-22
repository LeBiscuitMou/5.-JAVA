package net.ent.etrs.rafale.model.entities.exceptions;

public class RafaleAirException extends Exception {
    public RafaleAirException(String message) {
        super(message);
    }

    public RafaleAirException(String message, Throwable cause) {
        super(message, cause);
    }

    public RafaleAirException(Throwable cause) {
        super(cause);
    }

    public RafaleAirException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
