package net.ent.etrs.gestionformation.models.facade;

import net.ent.etrs.gestionformation.models.facade.impl.FacadeMetierImpl;

public final class FactoryFacadeMetier {

    private FactoryFacadeMetier(){}

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
