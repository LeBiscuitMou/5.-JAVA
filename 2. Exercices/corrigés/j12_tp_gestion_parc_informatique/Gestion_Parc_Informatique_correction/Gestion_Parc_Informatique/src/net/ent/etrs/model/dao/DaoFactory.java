package net.ent.etrs.model.dao;

import net.ent.etrs.model.entities.Batiment;
import net.ent.etrs.model.entities.MaterielInformatique;


public final class DaoFactory {

    private DaoFactory() {
    }

    private static MaterielInformatiqueDaoImpl materielInformatiqueDaoInstance;

    /**
     * Fabrique une DAO pour la gestion des entités {@link Batiment}.
     * @return l'instance de {@link BatimentDaoImpl}
     */
    public static BatimentDao fabriquerBatimentDao() {
        return new BatimentDaoImpl();
    }

    /**
     * Fabrique une DAO pour la gestion des entités @see {@link MaterielInformatique}.
     * @return une instance unique (singleton) de {@link MaterielInformatiqueDaoImpl}
     */
    public static MaterielInformatiqueDao fabriquerMaterielInformatiqueDao() {
        if (materielInformatiqueDaoInstance == null){
            materielInformatiqueDaoInstance = new MaterielInformatiqueDaoImpl();
        }
        return materielInformatiqueDaoInstance;
    }
}
