package net.ent.etrs.GestionnairePotion.model.dao.impl;

import net.ent.etrs.GestionnairePotion.model.dao.BaseDao;
import net.ent.etrs.GestionnairePotion.model.dao.exceptions.DaoException;
import net.ent.etrs.GestionnairePotion.model.entities.AbstractEntity;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;

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
            throw new DaoException(ConstErrMsg.ENTITY_NULL);
        }
        for(T objet : persist.values()){
            if(objet.equals(entity)){
                throw new DaoException(ConstErrMsg.ENTITY_EXIST);
            }
        }
        entity.setId(incrementationAutoSequence());
        this.persist.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> find(Long id) throws DaoException {
        return Optional.ofNullable(this.persist.get(id));
    }

    /**
     * Retourne un iterator contentant toutes les entités.
     * Crée une liste à partir d'un itérator :
     * List<T> list = new ArrayList<>();
     * findAll().iterator().forEachRemaining(list::add);
     * @return un iterator contentant toutes les entités
     * @throws DaoException exception
     */
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
