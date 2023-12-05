package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.excpetions.DaoException;
import net.ent.etrs.model.entities.Batiment;
import net.ent.etrs.model.entities.MaterielInformatique;
import net.ent.etrs.model.entities.Piece;
import net.ent.etrs.model.entities.references.Constantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MaterielInformatiqueDaoImpl implements MaterielInformatiqueDao{

    private List<MaterielInformatique> persistence = new ArrayList<>();

    private BatimentDao batimentDao;

    public MaterielInformatiqueDaoImpl() {
        this.batimentDao = DaoFactory.fabriquerBatimentDao();
    }

    @Override
    public MaterielInformatique create(final MaterielInformatique materielInformatique) throws DaoException {
        if (Objects.isNull(materielInformatique)) {
            throw new DaoException(Constantes.DAO_MATERIEL_INFORMATIQUE_CREATION_EXCEPTION);
        }
        if (exist(materielInformatique)) {
            throw new DaoException(Constantes.DAO_MATERIEL_INFORMATIQUE_EXIST_EXCEPTION);
        }
        this.persistence.add(materielInformatique);
        return this.read(materielInformatique.getNumSerie());
    }

    @Override
    public void delete(final String numSerie) throws DaoException {
        MaterielInformatique m = this.read(numSerie);
        if (!exist(m)) {
            throw new DaoException(Constantes.DAO_MATERIEL_INFORMATIQUE_EXIST_PAS_EXCEPTION);
        }
        this.persistence.remove(m);
    }

    @Override
    public boolean exist(final MaterielInformatique materielInformatique) throws DaoException {
        try {
            return this.persistence.contains(materielInformatique);
        } catch (Exception e) {
            throw new DaoException(Constantes.DAO_MATERIEL_INFORMATIQUE_EXIST_NULL_EXCEPTION, e);
        }
    }

    @Override
    public MaterielInformatique read(final String numSerie) throws DaoException {
        MaterielInformatique p = null;
        for (MaterielInformatique materielInformatique : this.persistence) {
            if(materielInformatique.getNumSerie().split("_")[1].equals(numSerie)) {
                p = materielInformatique;
            }
        }
        return p;
    }

    @Override
    public List<MaterielInformatique> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }


    @Override
    public MaterielInformatique update(final MaterielInformatique materielInformatique) throws DaoException {

        try {
            this.persistence.remove(materielInformatique);
            this.persistence.add(materielInformatique);
        }catch (Exception e) {
            throw new DaoException(Constantes.DAO_MATERIEL_INFORMATIQUE_MODIFICATION_EXCEPTION);
        }
        return this.read(materielInformatique.getNumSerie());
    }

    @Override
    public List<MaterielInformatique> readAllByBatiment(final Batiment batiment) {
        List<MaterielInformatique> lstMaterielInformatique= new ArrayList<>();
        for (Piece piece : batiment.getPieces()){
            lstMaterielInformatique.addAll(piece.getLstMaterielInformatique());
        }
        return lstMaterielInformatique;
    }

    @Override
    public List<MaterielInformatique> readAllMaterielInformatiqueAffecte() {
        List<MaterielInformatique> lstMaterielInformatiqueAffecte= new ArrayList<>();
        for (Batiment batiment : this.batimentDao.readAll()){
            lstMaterielInformatiqueAffecte.addAll(this.readAllByBatiment(batiment));
        }
        return lstMaterielInformatiqueAffecte;
    }
}
