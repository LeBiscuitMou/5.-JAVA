package net.ent.etrs.pjjeudesociete.models.facade.impl;

import net.ent.etrs.pjjeudesociete.models.facade.FacadeMetier;

public final class FactoryFacadeMetier {

    private FactoryFacadeMetier() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
