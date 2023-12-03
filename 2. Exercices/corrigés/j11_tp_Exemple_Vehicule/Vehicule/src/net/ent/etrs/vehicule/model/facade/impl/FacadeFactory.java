package net.ent.etrs.vehicule.model.facade.impl;

import net.ent.etrs.vehicule.model.facade.FacadeMetier;

public final class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeMetier fabriquerFacadeMetier(){return new FacadeMetierImpl();}
}
