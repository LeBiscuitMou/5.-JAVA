package net.ent.etrs.vehicule.model.dao.impl;

import net.ent.etrs.vehicule.model.dao.IDaoVehicule;

public final class DaoFactory {

    private static IDaoVehicule daoVehicule;

    private DaoFactory() {
    }

    public static IDaoVehicule fabriquerDaoVehiculeImplMem() {
        if(null == daoVehicule){
            daoVehicule = new DaoVehiculeImplMem();
        }
        return daoVehicule;
    }
}
