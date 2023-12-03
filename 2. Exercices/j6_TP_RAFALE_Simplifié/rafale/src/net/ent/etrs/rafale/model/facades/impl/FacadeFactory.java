package net.ent.etrs.rafale.model.facades.impl;

import net.ent.etrs.rafale.model.facades.FacadeMetierRafale;

public class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeMetierRafale fabriquerFacadeMetierRafale() {
        return new FacadeMetierRafaleImpl();
    }
}
