package net.ent.etrs.gestionLeague.models.daos.impl;

import net.ent.etrs.gestionLeague.models.daos.IDaoLeague;
import net.ent.etrs.gestionLeague.models.daos.MemBaseDao;
import net.ent.etrs.gestionLeague.models.entities.Challenge;
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
        Map<League, Long> leagueLongMap = new HashMap<>();
        for (League league : this.persist.values()) {
            Long total = 0L;
            for (Challenge c : league.getLesChallenges()) {
                total += c.getRewardPoints();
            }
            leagueLongMap.put(league, total);
        }
        return leagueLongMap;
    }

    @Override
    public Map<League, Set<LabySpecialite>> getBestBuildByLeague() {
        Map<League, Set<LabySpecialite>> leagueSetMap = new HashMap<>();

    }
}