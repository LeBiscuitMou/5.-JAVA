package net.ent.etrs.poinsot.exemplePersonne.model.facade;

import net.ent.etrs.poinsot.exemplePersonne.model.entities.Personne;
import net.ent.etrs.poinsot.exemplePersonne.model.facade.impl.exceptions.FacadeException;

public interface FacadeMetier {
    Personne sauvegarderPersonne(Personne laPersonne) throws FacadeException;
}