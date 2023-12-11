package net.ent.etrs.CatalogueJeuVideo.model.dao.impl;


import net.ent.etrs.CatalogueJeuVideo.model.dao.BaseDao;
import net.ent.etrs.CatalogueJeuVideo.model.dao.exceptions.DaoException;
import net.ent.etrs.CatalogueJeuVideo.model.entities.AbstractEntity;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstErrMsg;

import java.util.*;

public abstract class MemBaseDao<T extends AbstractEntity> implements BaseDao<T> {

    protected final Map<Long, T> persist = new HashMap<>();

    Long sequence = 0L;

    /**
     * Retourne la valeur de la variable d'instance "sequence", puis l'incrémente, la valeur retournée n'est pas incrémenté.
     *
     * @return un Long
     */
    private Long incrementationAutoSequence() {
        return this.sequence++;
    }

    /**
     * Sauvegarde une entité dans la persistance mémoire.
     *
     * @param entity l'entité à sauvegarder
     * @return l'entité sauvegardée
     * @throws DaoException l'exception lancée
     */
    @Override
    public T save(T entity) throws DaoException {
        if(Objects.isNull(entity)){
            throw new DaoException(ConstErrMsg.ENTITY_NULL);
        }
        entity.setId(incrementationAutoSequence());
        this.persist.put(entity.getId(), entity);
        return entity;
    }

    /**
     * Cherche et retourne l'entité liée à la Key "id" donné.
     *
     * @param id la Key de l'entité recherchée
     * @return l'entité si elle existe, ou null
     * @throws DaoException l'exception lancée
     */
    @Override
    public Optional<T> find(Long id) throws DaoException {
        return Optional.ofNullable(this.persist.get(id));
    }

    /**
     * Retourne un iterator contentant toutes les entités.
     *
     * Crée une liste à partir d'un itérator :
     * List<T> list = new ArrayList<>();
     * findAll().iterator().forEachRemaining(list::add);
     * ou faire un for each
     *
     * @return un iterator contentant toutes les entités
     * @throws DaoException exception
     */
    @Override
    public Iterable<T> findAll() throws DaoException {
        return Collections.unmodifiableCollection(this.persist.values());
    }

    /**
     * Supprime une entité dans la persistance mémoire.
     *
     * @param id la Key de l'entité à supprimer
     * @throws DaoException l'exception lancée
     */
    @Override
    public void delete(Long id) throws DaoException {
        this.persist.remove(id);
    }

    /**
     * Vérifie si une entité est présente dans la persistance mémoire.
     *
     * @param id la Key de l'identité dont on veut savoir l'existence
     * @throws DaoException l'exception lancée
     */
    @Override
    public boolean exists(Long id) throws DaoException {
        return this.find(id).isPresent();
    }


    /**
     * Retourne le nombre d'entités stocké dans la persistance mémoire.
     *
     * @throws DaoException l'exception lancée
     */
    @Override
    public long count() throws DaoException {
        return this.persist.size();
    }
}
