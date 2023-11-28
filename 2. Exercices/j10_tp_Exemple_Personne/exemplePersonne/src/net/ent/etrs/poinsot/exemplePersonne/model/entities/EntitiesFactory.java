package net.ent.etrs.poinsot.exemplePersonne.model.entities;

import net.ent.etrs.poinsot.exemplePersonne.model.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.exceptions.PersonneException;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.references.ConstanteMetier;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Personne fabriquerPersonne(String nom, String prenom, LocalDate dateNaissance) throws EntitiesFactoryException {
        try {
            return new Personne(nom, prenom, dateNaissance);
        } catch (PersonneException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_PERSONNE_ERROR, e);
        }
    }
}