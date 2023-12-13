package net.ent.etrs.poeleague.model.daos;

import net.ent.etrs.poeleague.model.daos.impl.DaoChallengeImpl;
import net.ent.etrs.poeleague.model.daos.impl.DaoLeagueImpl;
import net.ent.etrs.poeleague.model.daos.impl.DaoPersonnageImpl;

public final class DaoFactory {

    private static final DaoLeague daoLeague;
    private static final DaoChallenge daoChallenge;
    private static final DaoPersonnage daoPersonnage;

    static {
        daoLeague = new DaoLeagueImpl();
        daoChallenge = new DaoChallengeImpl();
        daoPersonnage = new DaoPersonnageImpl();
    }

    private DaoFactory() {
    }


    public static DaoChallenge getDaoChallenge() {
        return daoChallenge;
    }

    public static DaoLeague getDaoLeague() {
        return daoLeague;
    }

    public static DaoPersonnage getDaoPersonnage() {
        return daoPersonnage;
    }
}
