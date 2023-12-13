package net.ent.etrs.gestionLeague.models.entities;

import net.ent.etrs.gestionLeague.models.entities.exceptions.ChallengeException;
import net.ent.etrs.gestionLeague.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionLeague.models.entities.exceptions.LeagueException;
import net.ent.etrs.gestionLeague.models.entities.exceptions.PersonnageException;
import net.ent.etrs.gestionLeague.models.entities.references.ConstantesMetier;
import net.ent.etrs.gestionLeague.models.entities.references.LabySpecialite;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Challenge fabriquerChallenge(String nom, Integer rewardPoints, String desc) throws EntitiesFactoryException {
        try {
            return new Challenge(nom, rewardPoints, desc);
        } catch (ChallengeException e) {
            throw new EntitiesFactoryException(ConstantesMetier.CONSTRUCTION_CHALLENGE_ERROR, e);
        }
    }

    public static League fabriquerLeague(LocalDate dateDebut, LocalDate dateFin, String nom) throws EntitiesFactoryException {
        try {
            return new League(dateDebut, dateFin, nom);
        } catch (LeagueException e) {
            throw new EntitiesFactoryException(ConstantesMetier.CONSTRUCTION_LEAGUE_ERROR, e);
        }
    }

    public static Personnage fabriquerPersonnage(Integer level, LabySpecialite build, String pseudo) throws EntitiesFactoryException {
        try {
            return new Personnage(level, build, pseudo);
        } catch (PersonnageException e) {
            throw new EntitiesFactoryException(ConstantesMetier.CONSTRUCTION_PERSONNAGE_ERROR, e);
        }
    }
}
