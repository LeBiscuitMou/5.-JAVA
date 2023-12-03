package net.ent.etrs.gestionrafale.model.facades.impl;

import net.ent.etrs.gestionrafale.model.facades.FacadeMetierRafale;

public class FacadeFactory {

    private FacadeFactory() {
    }

    public static FacadeMetierRafale fabriquerFacadeMetierRafale() {
        return new FacadeMetierRafaleImpl();
    }
}
