package net.ent.etrs.poinsot.exemplePersonne.model.facade.impl;

import net.ent.etrs.poinsot.exemplePersonne.model.facade.FacadeMetier;

public final class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}