package net.ent.etrs.poinsot.projet.model.facade.impl;

import net.ent.etrs.poinsot.projet.model.dao.DaoBatiment;
import net.ent.etrs.poinsot.projet.model.dao.DaoMaterielInformatique;
import net.ent.etrs.poinsot.projet.model.dao.impl.DaoFactory;
import net.ent.etrs.poinsot.projet.model.dao.impl.exceptions.MaterielInformatiqueDaoImplException;
import net.ent.etrs.poinsot.projet.model.entities.Batiment;
import net.ent.etrs.poinsot.projet.model.entities.MaterielInformatique;
import net.ent.etrs.poinsot.projet.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.projet.model.facade.exceptions.FacadeMetierException;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements FacadeMetier {
    DaoBatiment daoBatiment = DaoFactory.fabriquerDaoBatimentImpl();
    DaoMaterielInformatique daoMaterielInformatique = DaoFactory.fabriquerDaoMaterielInformatiqueImpl();

    @Override
    public void initialiserApplication() {

    }

    @Override
    public void creerMaterielInformatique(MaterielInformatique materielInformatique) throws FacadeMetierException {
        if (Objects.isNull(materielInformatique)) {
            throw new FacadeMetierException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_NULL_EXCEPTION);
        }
        try {
            daoMaterielInformatique.create(materielInformatique);
        } catch (MaterielInformatiqueDaoImplException e) {
            throw new FacadeMetierException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_CREATION_EXCEPTION, e);
        }
    }

    @Override
    public void supprimerMaterielInformatique(MaterielInformatique materielInformatique) throws FacadeMetierException {
        if (Objects.isNull(materielInformatique)) {
            throw new FacadeMetierException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_SUPPRESSION_EXCEPTION);
        }
        try {
            daoMaterielInformatique.delete(materielInformatique);
        } catch (MaterielInformatiqueDaoImplException e) {
            throw new FacadeMetierException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_SUPPRESSION_EXCEPTION, e);
        }
    }

    @Override
    public List<MaterielInformatique> listerMaterielInformatique() {
        return Collections.unmodifiableList(daoMaterielInformatique.readAll());
    }

    @Override
    public List<MaterielInformatique> listerMaterielInformatiqueBatiment(Batiment batiment) {
        return null;
    }

    @Override
    public List<MaterielInformatique> listerMaterielInformatiqueNonAffecte() {
        return null;
    }

    @Override
    public List<Batiment> listerBatiment() {
        return Collections.unmodifiableList(daoBatiment.readAll());
    }

    @Override
    public void affecterMaterielInformatiquePiece(Batiment batiment) {

    }
}