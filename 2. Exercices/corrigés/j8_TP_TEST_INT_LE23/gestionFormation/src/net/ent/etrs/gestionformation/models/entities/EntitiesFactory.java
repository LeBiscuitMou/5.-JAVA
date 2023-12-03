package net.ent.etrs.gestionformation.models.entities;

import net.ent.etrs.gestionformation.models.entities.exceptions.*;
import net.ent.etrs.gestionformation.models.entities.references.ConstanteMetier;
import net.ent.etrs.gestionformation.models.entities.references.TypeMatiere;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class EntitiesFactory {
    private EntitiesFactory() {}

    public static Cours fabriquerCours(String idCours, int duree) throws EntitiesFactoryException {
        try {
            return new Cours(idCours,duree);
        } catch (CoursException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_COURS_ERROR, e);
        }
    }

    public static Matiere fabriquerMatiere(String nom, String codeMatiere, TypeMatiere typeMatiere) throws EntitiesFactoryException {
        try {
            return new Matiere(nom,codeMatiere,typeMatiere);
        } catch (MatiereException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_MATIERE_ERROR, e);
        }
    }

    public static UniteValeur fabriquerUniteValeur(String nom, LocalDate dateDebut) throws EntitiesFactoryException {
        try {
            return new UniteValeur(nom,dateDebut);
        } catch (UniteValeurException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_UNITE_VALEUR_ERROR, e);
        }
    }

    public static Journee fabriquerJournee(LocalDate date) throws EntitiesFactoryException {
        try {
            return new Journee(date);
        } catch (JourneeException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_JOURNEE_ERROR, e);
        }
    }
}
