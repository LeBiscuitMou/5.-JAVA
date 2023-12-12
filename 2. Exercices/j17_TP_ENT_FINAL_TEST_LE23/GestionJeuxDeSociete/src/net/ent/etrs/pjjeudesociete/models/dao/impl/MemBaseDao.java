package net.ent.etrs.pjjeudesociete.models.dao.impl;

import net.ent.etrs.pjjeudesociete.models.dao.BaseDao;
import net.ent.etrs.pjjeudesociete.models.dao.exceptions.DaoException;
import net.ent.etrs.pjjeudesociete.models.entities.AbstractEntity;
import net.ent.etrs.pjjeudesociete.models.references.ConstanteMetier;

import java.util.*;

public abstract class MemBaseDao<T extends AbstractEntity> implements BaseDao<T> {

    protected final Map<Long, T> persist = new HashMap<>();

    Long sequence = 0L;

    /**
     * Retourne la valeur de la variable d'instance "sequence", puis l'incrémente, la valeur retournée n'est pas incrémenté.
     * (le 1er nombre retourné est donc "0L")
     * @return un Long
     */
    private Long incrementationAutoSequence() {
        return this.sequence++;
    }

    @Override
    public T save(T entity) throws DaoException {
        if(Objects.isNull(entity)){
            throw new DaoException(ConstanteMetier.ENTITY_NULL);
        }
        for(T objet : persist.values()){
            if(objet.equals(entity)){
                throw new DaoException(ConstanteMetier.ENTITY_EXIST);
            }
        }
        entity.setId(incrementationAutoSequence());
        this.persist.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> find(Long id) {
        return Optional.ofNullable(this.persist.get(id));
    }

    /**
     * Retourne un iterator contentant toutes les entités.
     * Crée une liste à partir d'un itérator :
     * List<T> list = new ArrayList<>();
     * findAll().iterator().forEachRemaining(list::add);
     * @return un iterator contentant toutes les entités
     */
    @Override
    public Iterable<T> findAll() {
        return Collections.unmodifiableCollection(this.persist.values());
    }



    @Override
    public void delete(Long id) {
        this.persist.remove(id);
    }

    @Override
    public void deleteAll() {
        this.persist.clear();
        sequence = 0L;
    }

    @Override
    public boolean exists(Long id) throws DaoException {
        return this.find(id).isPresent();
    }

    @Override
    public long count() {
        return this.persist.size();
    }
}
