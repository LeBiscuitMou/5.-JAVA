package net.ent.etrs.gestionLeague.models.daos.impl;

import net.ent.etrs.gestionLeague.models.daos.IDaoChallenge;
import net.ent.etrs.gestionLeague.models.daos.IDaoLeague;
import net.ent.etrs.gestionLeague.models.daos.IDaoPersonnage;

import java.util.Objects;

public final class DaoFactory {
    private static IDaoLeague daoLeague;
    private static IDaoChallenge daoChallenge;
    private static IDaoPersonnage daoPersonnage;

    private DaoFactory() {
    }

    public static IDaoLeague fabriquerDaoLeague() {
        if (Objects.isNull(daoLeague)) {
            daoLeague = new DaoLeagueImpl();
        }
        return daoLeague;
    }

    public static IDaoChallenge fabriquerDaoChallenge() {
        if (Objects.isNull(daoChallenge)) {
            daoChallenge = new DaoChallengeImpl();
        }
        return daoChallenge;
    }

    public static IDaoPersonnage fabriquerDaoPersonnage() {
        if (Objects.isNull(daoPersonnage)) {
            daoPersonnage = new DaoPersonnageImpl();
        }
        return daoPersonnage;
    }
}
