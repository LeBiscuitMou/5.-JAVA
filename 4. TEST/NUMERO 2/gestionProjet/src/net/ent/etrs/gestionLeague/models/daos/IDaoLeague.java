package net.ent.etrs.gestionLeague.models.daos;

import net.ent.etrs.gestionLeague.models.entities.League;
import net.ent.etrs.gestionLeague.models.entities.references.LabySpecialite;

import java.util.Map;
import java.util.Set;

public interface IDaoLeague extends BaseDao<League> {
    Map<League, Long> getRewardPointsByLeague();

    Map<League, Set<LabySpecialite>> getBestBuildByLeague();
}
