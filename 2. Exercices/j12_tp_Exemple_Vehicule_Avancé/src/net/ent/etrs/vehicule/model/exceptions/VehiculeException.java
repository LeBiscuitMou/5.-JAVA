package net.ent.etrs.vehicule.model.exceptions;

public class VehiculeException extends Exception {
    public VehiculeException(String message) {
        super(message);
    }

    public VehiculeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehiculeException(Throwable cause) {
        super(cause);
    }

    public VehiculeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public VehiculeException(Object p0) {
    }
}
