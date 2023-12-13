package net.ent.etrs.poeleague.model.daos;


import net.ent.etrs.poeleague.model.daos.exceptions.DaoException;
import net.ent.etrs.poeleague.model.entities.AbstractEntity;

import java.util.function.Supplier;

public interface BaseDao<T extends AbstractEntity> {

    T save(T entity) throws DaoException;

    Supplier<T> find(Long id) throws DaoException;

    Iterable<T> findAll() throws DaoException;

    void delete(Long id) throws DaoException;

    boolean exists(Long id) throws DaoException;

    long count() throws DaoException;

}
