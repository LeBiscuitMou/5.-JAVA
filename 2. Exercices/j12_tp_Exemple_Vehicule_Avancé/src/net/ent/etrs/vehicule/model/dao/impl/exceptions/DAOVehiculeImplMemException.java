package net.ent.etrs.vehicule.model.dao.impl.exceptions;

public class DAOVehiculeImplMemException extends Exception {
    public DAOVehiculeImplMemException(String message) {
        super(message);
    }

    public DAOVehiculeImplMemException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOVehiculeImplMemException(Throwable cause) {
        super(cause);
    }

    public DAOVehiculeImplMemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}