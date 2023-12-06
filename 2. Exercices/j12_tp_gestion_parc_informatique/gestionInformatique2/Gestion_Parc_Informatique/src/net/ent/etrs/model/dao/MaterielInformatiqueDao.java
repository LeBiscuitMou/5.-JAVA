package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.excpetions.DaoException;
import net.ent.etrs.model.entities.Batiment;
import net.ent.etrs.model.entities.MaterielInformatique;

import java.util.List;

public interface MaterielInformatiqueDao {

    MaterielInformatique create(MaterielInformatique materielInformatique) throws DaoException;

    MaterielInformatique read(String numSerie) throws DaoException;

    void delete(String numSerie) throws DaoException;

    MaterielInformatique update(MaterielInformatique materielInformatique) throws DaoException;

    List<MaterielInformatique> readAll();

    boolean exist(MaterielInformatique materielInformatique) throws DaoException;

    List<MaterielInformatique> readAllByBatiment(Batiment batiment);

    List<MaterielInformatique> readAllMaterielInformatiqueAffecte();
}
