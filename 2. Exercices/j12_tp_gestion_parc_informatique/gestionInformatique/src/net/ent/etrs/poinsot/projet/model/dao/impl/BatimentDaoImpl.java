package net.ent.etrs.poinsot.projet.model.dao.impl;

import net.ent.etrs.poinsot.projet.model.dao.DaoBatiment;
import net.ent.etrs.poinsot.projet.model.dao.impl.exceptions.BatimentDaoImplException;
import net.ent.etrs.poinsot.projet.model.entities.Batiment;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BatimentDaoImpl implements DaoBatiment {
    private List<Batiment> persistence = new ArrayList<>();

    @Override
    public void create(Batiment batiment) throws BatimentDaoImplException {
        if (Objects.isNull(batiment)) {
            throw new BatimentDaoImplException(ConstanteMetier.DAO_BATIMENT_CREATION_EXCEPTION);
        }
        if (persistence.contains(batiment)) {
            throw new BatimentDaoImplException(ConstanteMetier.DAO_BATIMENT_EXIST_EXCEPTION);
        }
        //Règle métier

        this.persistence.add(batiment);
    }

    @Override
    public Batiment read(String nom) throws BatimentDaoImplException {
        if (Objects.isNull(nom)) {
            throw new BatimentDaoImplException(ConstanteMetier.DAO_BATIMENT_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new BatimentDaoImplException(ConstanteMetier.DAO_BATIMENT_NOM_IS_BLANK);
        }
        for (Batiment b :
                persistence) {
            if (b.getLibelle().equals(nom)) {
                return b;
            }
        }
        throw new BatimentDaoImplException(ConstanteMetier.DAO_BATIMENT_SELECTION_EXCEPTION);
    }

    @Override
    public void delete(Batiment batiment) throws BatimentDaoImplException {
        if (exist(batiment)) {
            persistence.remove(batiment);
        }
    }

    @Override
    public void update(Batiment batiment) throws BatimentDaoImplException {
        if (exist(batiment)) {
            persistence.set(persistence.indexOf(batiment), batiment);
        }
    }

    @Override
    public List<Batiment> readAll() {
        return Collections.unmodifiableList(persistence);
    }

    @Override
    public boolean exist(Batiment batiment) throws BatimentDaoImplException {
        if (Objects.isNull(batiment)) {
            throw new BatimentDaoImplException(ConstanteMetier.DAO_BATIMENT_EXIST_NULL_EXCEPTION);
        }
        if (!persistence.contains(batiment)) {
            throw new BatimentDaoImplException(ConstanteMetier.DAO_BATIMENT_EXIST_PAS_EXCEPTION);
        }
        return true;
    }

    @Override
    public void init() {

    }
}