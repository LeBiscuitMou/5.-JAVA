package net.ent.etrs.poeleague.model.entities.exceptions;

public class ChallengeException extends Exception {
    public ChallengeException(String message) {
        super(message);
    }

    public ChallengeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChallengeException(Throwable cause) {
        super(cause);
    }

    public ChallengeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
