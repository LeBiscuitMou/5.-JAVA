package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.excpetions.DaoException;
import net.ent.etrs.model.entities.Batiment;

import java.util.List;

public interface BatimentDao{

    Batiment create(Batiment batiment) throws DaoException;

    Batiment read(String libelle) throws DaoException;

    void delete(String libelle) throws DaoException;

    Batiment update(Batiment batiment) throws DaoException;

    List<Batiment> readAll();

    boolean exist(Batiment batiment) throws DaoException;

    default void init() {
        throw new UnsupportedOperationException();
    }



}
