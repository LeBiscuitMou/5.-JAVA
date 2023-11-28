package net.ent.etrs.exemplePersonne.view.facade;

import net.ent.etrs.exemplePersonne.model.entities.Personne;
import net.ent.etrs.exemplePersonne.model.entities.exceptions.EntitiesFactoryExceptions;

public interface FacadeView {

    Personne creerPersonne() throws EntitiesFactoryExceptions;
}
