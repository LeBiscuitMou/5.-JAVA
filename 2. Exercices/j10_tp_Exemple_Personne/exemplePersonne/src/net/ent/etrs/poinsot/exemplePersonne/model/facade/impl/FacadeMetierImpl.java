package net.ent.etrs.poinsot.exemplePersonne.model.facade.impl;

import net.ent.etrs.poinsot.exemplePersonne.model.entities.Personne;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.Voiture;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.references.ConstanteMetier;
import net.ent.etrs.poinsot.exemplePersonne.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.exemplePersonne.model.facade.impl.exceptions.FacadeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements FacadeMetier {
    List<Personne> persistancePersonne = new ArrayList<>();
    List<Voiture> persistanceVoiture = new ArrayList<>();

    @Override
    public Personne sauvegarderPersonne(Personne laPersonne) throws FacadeException {
        if (Objects.isNull(laPersonne)) {
            throw new FacadeException(ConstanteMetier.FACADE_SVG_PERSONNE);
        }
        if (this.persistancePersonne.contains(laPersonne)) {
            throw new FacadeException(ConstanteMetier.FACADE_PERSONNE_EXISTE_DEJA);
        }
        // Règles métier
        this.persistancePersonne.add(laPersonne);
        return laPersonne;
    }
}