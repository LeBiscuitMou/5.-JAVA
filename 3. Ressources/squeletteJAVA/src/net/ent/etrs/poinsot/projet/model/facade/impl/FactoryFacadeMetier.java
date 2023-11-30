package net.ent.etrs.poinsot.projet.model.facade.impl;

import net.ent.etrs.poinsot.projet.model.facade.FacadeMetier;

public final class FactoryFacadeMetier {
    private FactoryFacadeMetier() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}