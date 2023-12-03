package net.ent.etrs.exemplePersonne.model.entities;

import net.ent.etrs.exemplePersonne.model.entities.exceptions.EntitiesFactoryExceptions;
import net.ent.etrs.exemplePersonne.model.entities.exceptions.PersonneExceptions;
import net.ent.etrs.exemplePersonne.model.entities.references.ConstanteMetier;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Personne fabriquerPersonne(String leNom, String lePrenom, LocalDate laDateNaissance) throws EntitiesFactoryExceptions {
        try {
            return new Personne(leNom,lePrenom,laDateNaissance);
        } catch (PersonneExceptions e) {
            throw new EntitiesFactoryExceptions(ConstanteMetier.CONSTRUCTION_PERSONNE_ERROR,e);
        }
    }
}
