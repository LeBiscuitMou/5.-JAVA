package net.ent.etrs.poeleague.model.entities.exceptions;

public class LeagueException extends Exception {
    public LeagueException(String message) {
        super(message);
    }

    public LeagueException(String message, Throwable cause) {
        super(message, cause);
    }

    public LeagueException(Throwable cause) {
        super(cause);
    }

    public LeagueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
