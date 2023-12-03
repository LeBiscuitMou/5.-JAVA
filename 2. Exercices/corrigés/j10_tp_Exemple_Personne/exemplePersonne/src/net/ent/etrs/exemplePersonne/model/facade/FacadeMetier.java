package net.ent.etrs.exemplePersonne.model.facade;

import net.ent.etrs.exemplePersonne.model.entities.Personne;
import net.ent.etrs.exemplePersonne.model.facade.impl.exception.FacadeException;

public interface FacadeMetier {

    Personne sauvegarderPersonne(Personne laPersonne) throws FacadeException;

}
