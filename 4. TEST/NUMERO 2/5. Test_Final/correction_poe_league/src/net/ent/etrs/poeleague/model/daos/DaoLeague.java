package net.ent.etrs.poeleague.model.daos;


import net.ent.etrs.poeleague.model.daos.exceptions.DaoException;
import net.ent.etrs.poeleague.model.entities.League;
import net.ent.etrs.poeleague.model.entities.references.LabySpecialite;

import java.util.Map;
import java.util.Set;

public interface DaoLeague extends BaseDao<League> {
    Map<League, Long> getRewardPointsByLeague() throws DaoException;

    Set<LabySpecialite> topThreeBestBuild(League league);

    Map<League, Set<LabySpecialite>> bestBuildByLeague() throws DaoException;
}
