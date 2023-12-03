package net.ent.etrs.emploi.model.facades.exceptions;

import net.ent.etrs.emploi.model.entities.exceptions.FactoryException;

public class FacadeMetierEmploiTempsException extends Exception {
    public FacadeMetierEmploiTempsException(String message) {
        super(message);
    }

    public FacadeMetierEmploiTempsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeMetierEmploiTempsException(Throwable cause) {
        super(cause);
    }

    public FacadeMetierEmploiTempsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
