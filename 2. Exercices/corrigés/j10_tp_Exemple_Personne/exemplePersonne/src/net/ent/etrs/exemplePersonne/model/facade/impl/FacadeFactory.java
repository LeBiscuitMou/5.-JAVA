package net.ent.etrs.exemplePersonne.model.facade.impl;

import net.ent.etrs.exemplePersonne.model.facade.FacadeMetier;

public final class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
