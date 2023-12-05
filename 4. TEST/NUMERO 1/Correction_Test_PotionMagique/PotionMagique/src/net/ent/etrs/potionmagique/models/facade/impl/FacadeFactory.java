package net.ent.etrs.potionmagique.models.facade.impl;

import net.ent.etrs.potionmagique.models.facade.FacadeMetier;

public final class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
