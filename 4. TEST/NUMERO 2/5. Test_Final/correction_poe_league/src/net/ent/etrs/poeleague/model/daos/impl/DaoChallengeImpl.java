package net.ent.etrs.poeleague.model.daos.impl;


import net.ent.etrs.poeleague.model.daos.DaoChallenge;
import net.ent.etrs.poeleague.model.daos.MemBaseDao;
import net.ent.etrs.poeleague.model.daos.exceptions.DaoException;
import net.ent.etrs.poeleague.model.entities.Challenge;

import java.util.Optional;

public class DaoChallengeImpl extends MemBaseDao<Challenge> implements DaoChallenge {
    @Override
    public Optional<Challenge> getBestChallenge() throws DaoException {
        Optional<Challenge> optionalChallenge = Optional.empty();

        for (Challenge c : this.findAll()) {
            if (optionalChallenge.isEmpty()) {
                optionalChallenge = Optional.of(c);
            }
            if (optionalChallenge.get().getRewardPoints() < c.getRewardPoints()) {
                optionalChallenge = Optional.of(c);
            }
        }
        return optionalChallenge;
    }
}
