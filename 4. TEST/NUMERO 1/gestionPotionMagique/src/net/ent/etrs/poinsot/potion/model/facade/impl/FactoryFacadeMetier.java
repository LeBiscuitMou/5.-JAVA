package net.ent.etrs.poinsot.potion.model.facade.impl;

import net.ent.etrs.poinsot.potion.model.facade.FacadeMetier;

public final class FactoryFacadeMetier {
    private FactoryFacadeMetier() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}