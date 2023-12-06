package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.excpetions.DaoException;
import net.ent.etrs.model.entities.Batiment;
import net.ent.etrs.model.entities.references.Constantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class BatimentDaoImpl implements BatimentDao {

    protected BatimentDaoImpl() {
    }

    private List<Batiment> persistence = new ArrayList<>();

    @Override
    public Batiment create(final Batiment batiment) throws DaoException {
        if (Objects.isNull(batiment)) {
            throw new DaoException(Constantes.DAO_BATIMENT_CREATION_EXCEPTION);
        }
        if (exist(batiment)) {
            throw new DaoException(Constantes.DAO_BATIMENT_EXIST_EXCEPTION);
        }
        this.persistence.add(batiment);
        return this.read(batiment.getLibelle());
    }

    @Override
    public void delete(final String libelle) throws DaoException {
        Batiment b = this.read(libelle);
        if (!exist(b)) {
            throw new DaoException(Constantes.DAO_BATIMENT_EXIST_PAS_EXCEPTION);
        }
        this.persistence.remove(b);
    }

    @Override
    public boolean exist(final Batiment batiment) throws DaoException {
        try {
            return this.persistence.contains(batiment);
        } catch (Exception e) {
            throw new DaoException(Constantes.DAO_BATIMENT_EXIST_NULL_EXCEPTION, e);
        }
    }

    @Override
    public Batiment read(final String libelle) throws DaoException {
        Batiment p = null;
        for (Batiment batiment : this.persistence) {
            if(batiment.getLibelle().equals(libelle)) {
                p = batiment;
            }
        }
        return p;
    }

    @Override
    public List<Batiment> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }



    @Override
    public Batiment update(final Batiment batiment) throws DaoException {

        try {
            this.persistence.remove(batiment);
            this.persistence.add(batiment);
        }catch (Exception e) {
            throw new DaoException(Constantes.DAO_BATIMENT_MODIFICATION_EXCEPTION);
        }
        return this.read(batiment.getLibelle());
    }
}
