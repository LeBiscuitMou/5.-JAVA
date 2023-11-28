package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.kingdomino.models.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.models.entities.exceptions.TuileException;
import net.ent.etrs.kingdomino.models.entities.references.ConstanteMetier;
import net.ent.etrs.kingdomino.models.entities.references.Couleur;

public final class EntitiesFactory {

    private EntitiesFactory() {}

    public static Joueur fabriquerJoueur(String nom, Couleur couleur) throws EntitiesFactoryException {
        try {
            return new Joueur(nom, couleur);
        } catch (JoueurException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_JOUEUR_ERROR,e);
        }
    }

    public static Tuile fabriquerTuileChateau() throws EntitiesFactoryException {
        try {
            return new Chateau(0);
        } catch (TuileException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_ERROR,e);
        }
    }

    public static Tuile fabriquerTuileBle(int nbCouronne) throws EntitiesFactoryException {
        try {
            return new Ble(nbCouronne);
        } catch (TuileException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_ERROR,e);
        }
    }

    public static Tuile fabriquerTuileEau(int nbCouronne) throws EntitiesFactoryException {
        try {
            return new Eau(nbCouronne);
        } catch (TuileException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_ERROR,e);
        }
    }

    public static Tuile fabriquerTuileForet(int nbCouronne) throws EntitiesFactoryException {
        try {
            return new Foret(nbCouronne);
        } catch (TuileException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_ERROR,e);
        }
    }

    public static Tuile fabriquerTuileMarais(int nbCouronne) throws EntitiesFactoryException {
        try {
            return new Marais(nbCouronne);
        } catch (TuileException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_ERROR,e);
        }
    }

    public static Tuile fabriquerTuileMine(int nbCouronne) throws EntitiesFactoryException {
        try {
            return new Mine(nbCouronne);
        } catch (TuileException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_ERROR,e);
        }
    }

    public static Tuile fabriquerTuilePrairie(int nbCouronne) throws EntitiesFactoryException {
        try {
            return new Prairie(nbCouronne);
        } catch (TuileException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_ERROR,e);
        }
    }
}
