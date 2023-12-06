package net.ent.etrs.vehicule.view.facade.exceptions;


import net.ent.etrs.vehicule.model.exceptions.FactoryException;

public class FacadeViewException extends Exception {
    public FacadeViewException(String message) {
        super(message);
    }

    public FacadeViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeViewException(Throwable cause) {
        super(cause);
    }

    public FacadeViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FacadeViewException(Object p0, FactoryException e) {
    }
}
