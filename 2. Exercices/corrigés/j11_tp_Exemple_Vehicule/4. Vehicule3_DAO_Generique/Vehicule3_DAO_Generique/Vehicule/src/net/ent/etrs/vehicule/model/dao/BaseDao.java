package net.ent.etrs.vehicule.model.dao;


import net.ent.etrs.vehicule.model.dao.exception.DaoException;
import net.ent.etrs.vehicule.model.entities.AbstractEntity;

import java.util.Optional;

public interface BaseDao<T extends AbstractEntity> {

    T save(T entity) throws DaoException;

    Optional<T> find(Long id) throws DaoException;

    Iterable<T> findAll() throws DaoException;

    void delete(Long id) throws DaoException;

    boolean exists(Long id) throws DaoException;

    long count() throws DaoException;

}
