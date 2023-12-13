package net.ent.etrs.poeleague.model.entities;

import net.ent.etrs.poeleague.model.entities.exceptions.ChallengeException;
import net.ent.etrs.poeleague.model.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.poeleague.model.entities.exceptions.LeagueException;
import net.ent.etrs.poeleague.model.entities.exceptions.PersonnageException;
import net.ent.etrs.poeleague.model.entities.references.ConstantMetier;
import net.ent.etrs.poeleague.model.entities.references.LabySpecialite;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static League fabriquerLeague(String nom, LocalDate dateDebut, LocalDate dateFin) throws EntitiesFactoryException {

        try {
            return new League(nom, dateDebut, dateFin);
        } catch (LeagueException e) {
            throw new EntitiesFactoryException(ConstantMetier.CONSTRUCTION_LEAGUE_ERROR, e);
        }
    }

    public static Challenge fabriquerChallenge(String nom, String desc, Integer rewards) throws EntitiesFactoryException {

        try {
            return new Challenge(nom, desc, rewards);
        } catch (ChallengeException e) {
            throw new EntitiesFactoryException(ConstantMetier.CONSTRUCTION_CHALLENGE_ERROR, e);
        }
    }

    public static Personnage fabriquerPersonnage(String pseudo, LabySpecialite build, Integer level) throws EntitiesFactoryException {

        try {
            return new Personnage(pseudo, level, build);
        } catch (PersonnageException e) {
            throw new EntitiesFactoryException(ConstantMetier.CONSTRUCTION_PERSONNAGE_ERROR, e);
        }
    }
}
