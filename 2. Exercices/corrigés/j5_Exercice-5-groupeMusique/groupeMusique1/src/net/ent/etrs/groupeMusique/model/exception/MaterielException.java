package net.ent.etrs.groupeMusique.model.exception;

public class MaterielException extends Exception {
    public MaterielException(String message) {
        super(message);
    }

    public MaterielException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaterielException(Throwable cause) {
        super(cause);
    }

    public MaterielException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
