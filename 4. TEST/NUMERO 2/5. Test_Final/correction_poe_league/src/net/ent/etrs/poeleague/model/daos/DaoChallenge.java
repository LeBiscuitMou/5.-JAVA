package net.ent.etrs.poeleague.model.daos;


import net.ent.etrs.poeleague.model.daos.exceptions.DaoException;
import net.ent.etrs.poeleague.model.entities.Challenge;

import java.util.Optional;

public interface DaoChallenge extends BaseDao<Challenge> {
    Optional<Challenge> getBestChallenge() throws DaoException;
}
