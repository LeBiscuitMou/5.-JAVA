package net.ent.etrs.poeleague.model.daos.impl;


import net.ent.etrs.poeleague.model.daos.DaoLeague;
import net.ent.etrs.poeleague.model.daos.MemBaseDao;
import net.ent.etrs.poeleague.model.daos.exceptions.DaoException;
import net.ent.etrs.poeleague.model.entities.Challenge;
import net.ent.etrs.poeleague.model.entities.League;
import net.ent.etrs.poeleague.model.entities.Personnage;
import net.ent.etrs.poeleague.model.entities.references.LabySpecialite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DaoLeagueImpl extends MemBaseDao<League> implements DaoLeague {
    @Override
    public Map<League, Long> getRewardPointsByLeague() throws DaoException {
        Map<League, Long> ret = new HashMap<>();

        for (League l : findAll()) {
            Long cptReward = 0L;
            for (Challenge c : l.getLesChallenges()) {
                cptReward += c.getRewardPoints();
            }
            ret.put(l, cptReward);
        }
        return ret;
    }

    @Override
    public Set<LabySpecialite> topThreeBestBuild(League league) {
        Set<LabySpecialite> ret = new HashSet<>();

        for (Map.Entry<Personnage, Integer> entry : league.getClassement().entrySet()) {
            if (ret.size() < 3) {
                ret.add(entry.getKey().getBuild());
            } else {
                return ret;
            }
        }
        return ret;
    }

    @Override
    public Map<League, Set<LabySpecialite>> bestBuildByLeague() throws DaoException {
        Map<League, Set<LabySpecialite>> result = new HashMap<>();
        for (League l : this.findAll()) {
            result.put(l, this.topThreeBestBuild(l));
        }
        return result;
    }
}
