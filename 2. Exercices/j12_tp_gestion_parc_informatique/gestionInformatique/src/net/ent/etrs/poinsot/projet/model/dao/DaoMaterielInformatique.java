package net.ent.etrs.poinsot.projet.model.dao;

import net.ent.etrs.poinsot.projet.model.dao.impl.exceptions.MaterielInformatiqueDaoImplException;
import net.ent.etrs.poinsot.projet.model.entities.MaterielInformatique;

import java.util.List;

public interface DaoMaterielInformatique {
    void create(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException;
    MaterielInformatique read(String nom) throws MaterielInformatiqueDaoImplException;
    void delete(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException;
    void update(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException;
    List<MaterielInformatique> readAll();
    boolean exist(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException;
}
