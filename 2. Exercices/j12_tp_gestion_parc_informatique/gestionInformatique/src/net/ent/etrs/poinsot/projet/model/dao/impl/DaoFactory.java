package net.ent.etrs.poinsot.projet.model.dao.impl;

import net.ent.etrs.poinsot.projet.model.dao.DaoBatiment;
import net.ent.etrs.poinsot.projet.model.dao.DaoMaterielInformatique;

public final class DaoFactory {
    private DaoFactory() {
    }

    public static DaoBatiment fabriquerDaoBatimentImpl() {
        return new BatimentDaoImpl();
    }

    public static DaoMaterielInformatique fabriquerDaoMaterielInformatiqueImpl() {
        return new MaterielInformatiqueDaoImpl();
    }
}