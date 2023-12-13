package net.ent.etrs.gestionLeague.models.facade.impl;

import net.ent.etrs.gestionLeague.models.facade.FacadeMetier;

public final class FactoryFacadeMetier {

    private FactoryFacadeMetier() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
