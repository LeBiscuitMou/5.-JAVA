package net.ent.etrs.gestionLeague.models.daos.impl;

import net.ent.etrs.gestionLeague.models.daos.IDaoLeague;
import net.ent.etrs.gestionLeague.models.daos.MemBaseDao;
import net.ent.etrs.gestionLeague.models.entities.League;
import net.ent.etrs.gestionLeague.models.entities.references.LabySpecialite;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DaoLeagueImpl extends MemBaseDao<League> implements IDaoLeague {
    protected DaoLeagueImpl() {
    }

    @Override
    public Map<League, Long> getRewardPointsByLeague() {
        return null;
    }

    @Override
    public Map<League, Set<LabySpecialite>> getBestBuildByLeague() {
        return null;
    }
}