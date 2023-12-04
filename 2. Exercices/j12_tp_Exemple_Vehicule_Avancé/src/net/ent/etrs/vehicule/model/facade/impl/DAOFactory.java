package net.ent.etrs.vehicule.model.facade.impl;

import net.ent.etrs.vehicule.model.dao.IDAOVehicule;
import net.ent.etrs.vehicule.model.dao.impl.DAOVehiculeImplMem;

public final class DAOFactory {
    private DAOFactory() {
    }

    public static IDAOVehicule fabriquerDAOVehiculeImplMem() {
        return new DAOVehiculeImplMem();
    }
}