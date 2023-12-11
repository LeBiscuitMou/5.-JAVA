package net.ent.etrs.gestionJeuxVideo.models.dao.impl;

import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoBase;
import net.ent.etrs.gestionJeuxVideo.models.dao.exceptions.DaoException;
import net.ent.etrs.gestionJeuxVideo.models.entities.AbstractEntity;
import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.AbstractEntityException;
import net.ent.etrs.gestionJeuxVideo.models.references.ConstanteMetier;

import java.util.*;

public class DaoBaseMem<T extends AbstractEntity> implements IDaoBase<T> {
    protected final Map<Long, T> persist = new HashMap<>();

    Long sequence = 0L;

    private Long incrementationAutoSequence() {
        return this.sequence++;
    }
    @Override
    public T save(T entity) throws DaoException {
        if (Objects.isNull(entity)) {
            throw new DaoException(ConstanteMetier.DAO_ENTITY_IS_NULL);
        }
        for (T objet : persist.values()) {
            if (objet.equals(entity)) {
                throw new DaoException(ConstanteMetier.DAO_ENTITY_EXIST);
            }
        }
        try {
            entity.setId(incrementationAutoSequence());
        } catch (AbstractEntityException e) {
            throw new DaoException(ConstanteMetier.DAO_ENTITY_IS_NULL, e);
        }
        this.persist.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> find(Long id) throws DaoException {
        return Optional.ofNullable(this.persist.get(id));
    }

    @Override
    public Iterable<T> findAll() throws DaoException {
        return Collections.unmodifiableCollection(this.persist.values());
    }

    @Override
    public void delete(Long id) throws DaoException {
        this.persist.remove(id);
    }

    @Override
    public void deleteAll() throws DaoException {
        this.persist.clear();
        sequence = 0L;
    }

    @Override
    public boolean exists(Long id) throws DaoException {
        return this.find(id).isPresent();
    }

    @Override
    public long count() throws DaoException {
        return this.persist.size();
    }
}