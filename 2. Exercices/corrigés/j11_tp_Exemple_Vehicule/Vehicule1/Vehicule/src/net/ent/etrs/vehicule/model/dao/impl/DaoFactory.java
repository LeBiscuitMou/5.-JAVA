package net.ent.etrs.vehicule.model.dao.impl;

import net.ent.etrs.vehicule.model.dao.IDaoVehicule;

public final class DaoFactory {
    private DaoFactory() {
    }

    public static IDaoVehicule fabriquerDaoVehiculeImplMem() {
        return new DaoVehiculeImplMem();
    }
}
