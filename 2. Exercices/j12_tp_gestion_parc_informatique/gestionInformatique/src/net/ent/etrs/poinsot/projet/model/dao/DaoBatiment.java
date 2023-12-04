package net.ent.etrs.poinsot.projet.model.dao;

import net.ent.etrs.poinsot.projet.model.dao.impl.exceptions.BatimentDaoImplException;
import net.ent.etrs.poinsot.projet.model.entities.Batiment;

import java.util.List;

public interface DaoBatiment {
    void create(Batiment batiment) throws BatimentDaoImplException;
    Batiment read(String nom) throws BatimentDaoImplException;
    void delete(Batiment batiment) throws BatimentDaoImplException;
    void update(Batiment batiment) throws BatimentDaoImplException;
    List<Batiment> readAll();
    boolean exist(Batiment batiment) throws BatimentDaoImplException;
    void init();
}
