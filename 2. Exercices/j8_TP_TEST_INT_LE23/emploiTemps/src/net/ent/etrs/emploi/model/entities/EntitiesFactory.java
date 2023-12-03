package net.ent.etrs.emploi.model.entities;

import net.ent.etrs.emploi.model.entities.exceptions.CoursException;
import net.ent.etrs.emploi.model.entities.exceptions.FactoryException;
import net.ent.etrs.emploi.model.entities.exceptions.MatiereException;
import net.ent.etrs.emploi.model.entities.exceptions.UniteValeurException;
import net.ent.etrs.emploi.model.entities.references.TypeMatiere;
import net.ent.etrs.emploi.model.references.ConstantesMetier;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static UniteValeur fabriquerUniteValeur(String nom, LocalDate dateDebut) throws FactoryException {
        try {
            return new UniteValeur(nom, dateDebut);
        } catch (UniteValeurException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_UNITE_VALEUR_ERROR, e);
        }
    }

    public static Matiere fabriquerMatiere(String nom, String codeMatiere, TypeMatiere typeMatiere, int leNombreHeureMatiere) throws FactoryException {
        try {
            return new Matiere(nom, codeMatiere, typeMatiere, leNombreHeureMatiere);
        } catch (MatiereException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_MATIERE_ERROR, e);
        }
    }

    public static Cours fabriquerCours(int numCours, int duree, LocalDateTime heureDebutCours) throws FactoryException {
        try {
            return new Cours(numCours, duree, heureDebutCours);
        } catch (CoursException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_COURS_ERROR, e);
        }
    }
}