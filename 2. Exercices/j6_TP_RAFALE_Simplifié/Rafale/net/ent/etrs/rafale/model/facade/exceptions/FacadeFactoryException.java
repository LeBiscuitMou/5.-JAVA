package net.ent.etrs.rafale.model.facade.exceptions;

import net.ent.etrs.rafale.model.exceptions.RafaleException;

public class FacadeFactoryException extends Exception {
    public FacadeFactoryException(String message) {
        super(message);
    }

    public FacadeFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeFactoryException(Throwable cause) {
        super(cause);
    }

    public FacadeFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}