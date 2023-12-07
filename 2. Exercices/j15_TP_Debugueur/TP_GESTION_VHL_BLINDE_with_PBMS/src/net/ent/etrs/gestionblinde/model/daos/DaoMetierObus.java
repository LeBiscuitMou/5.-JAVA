package net.ent.etrs.gestionblinde.model.daos;

import net.ent.etrs.gestionblinde.model.daos.exceptions.DaoMetierObusException;
import net.ent.etrs.gestionblinde.model.entities.Obus;

import java.util.List;
import java.util.Set;

public interface DaoMetierObus {

    public Obus create (Obus lObus) throws DaoMetierObusException;

    public Set<Obus> readAll();

    public Obus update (Obus lObus) throws DaoMetierObusException;

    public void delete (String nom);

}
