package net.ent.etrs.potionmagique.view.facade.impl;

import net.ent.etrs.potionmagique.view.facade.FacadeView;

public final class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeView fabriquerFacadeView() {
        return new FacadeViewImpl();
    }
}
