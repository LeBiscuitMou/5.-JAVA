package net.ent.etrs.gestionVehicule.model.facade.facadeImpl;

import net.ent.etrs.gestionVehicule.model.facade.FacadeMetier;

public final class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
