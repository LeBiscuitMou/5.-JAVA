package net.ent.etrs.poeleague.model.daos;


import net.ent.etrs.poeleague.model.daos.exceptions.DaoException;
import net.ent.etrs.poeleague.model.entities.AbstractEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class MemBaseDao<T extends AbstractEntity> implements BaseDao<T> {

    protected final Map<Long, T> persist = new HashMap<>();

    Long sequence = 0L;

    private Long incrementationAutoSequence() {
        return this.sequence++;
    }

    @Override
    public T save(T entity) throws DaoException {
        if (Objects.isNull(entity.getId()) && !this.persist.containsValue(entity)) {
            entity.setId(incrementationAutoSequence());
        }
        this.persist.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Supplier<T> find(Long id) throws DaoException {
        return () -> this.persist.get(id);
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
    public boolean exists(Long id) throws DaoException {
        return Objects.isNull(this.find(id).get());
    }

    @Override
    public long count() throws DaoException {
        return this.persist.size();
    }
}
