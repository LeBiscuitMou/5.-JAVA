package net.ent.etrs.poinsot.projet.model.dao.impl;

import net.ent.etrs.poinsot.projet.model.dao.DaoBatiment;
import net.ent.etrs.poinsot.projet.model.dao.DaoMaterielInformatique;
import net.ent.etrs.poinsot.projet.model.dao.impl.exceptions.MaterielInformatiqueDaoImplException;
import net.ent.etrs.poinsot.projet.model.entities.MaterielInformatique;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MaterielInformatiqueDaoImpl implements DaoMaterielInformatique {
    private List<MaterielInformatique> persistence = new ArrayList<>();
    private DaoBatiment daoBatiment = DaoFactory.fabriquerDaoBatimentImpl();

    @Override
    public void create(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException {
        if (!exist(materielInformatique))
            this.persistence.add(materielInformatique);
    }

    @Override
    public MaterielInformatique read(String nom) throws MaterielInformatiqueDaoImplException {
        if (Objects.isNull(nom)) {
            throw new MaterielInformatiqueDaoImplException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_EXCEPTION);
        }
        if (nom.isBlank()) {
            throw new MaterielInformatiqueDaoImplException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_NULL_EXCEPTION);
        }
        for (MaterielInformatique m : persistence) {
            if (m.getNumSerie().equals(nom)) {
                return m;
            }
        }
        throw new MaterielInformatiqueDaoImplException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_PAS_EXCEPTION);
    }

    @Override
    public void delete(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException {
        if (!exist(materielInformatique))
            throw new MaterielInformatiqueDaoImplException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_PAS_EXCEPTION);
        persistence.remove(materielInformatique);
    }

    @Override
    public void update(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException {
        if (exist(materielInformatique))
            persistence.set(persistence.indexOf(materielInformatique), materielInformatique);
    }

    @Override
    public List<MaterielInformatique> readAll() {
        return Collections.unmodifiableList(persistence);
    }

    @Override
    public boolean exist(MaterielInformatique materielInformatique) throws MaterielInformatiqueDaoImplException {
        if (Objects.isNull(materielInformatique)) {
            throw new MaterielInformatiqueDaoImplException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_CREATION_EXCEPTION);
        }
        return persistence.contains(materielInformatique);
    }
}