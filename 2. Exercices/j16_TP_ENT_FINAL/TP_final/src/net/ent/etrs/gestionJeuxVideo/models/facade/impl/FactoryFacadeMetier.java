package net.ent.etrs.gestionJeuxVideo.models.facade.impl;

import net.ent.etrs.gestionJeuxVideo.models.facade.FacadeMetier;

public final class FactoryFacadeMetier {
    private FactoryFacadeMetier() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}