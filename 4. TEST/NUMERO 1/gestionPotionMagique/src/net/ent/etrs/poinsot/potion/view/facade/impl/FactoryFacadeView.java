package net.ent.etrs.poinsot.potion.view.facade.impl;

import net.ent.etrs.poinsot.potion.view.facade.FacadeView;

public final class FactoryFacadeView {
    private FactoryFacadeView() {
    }

    public static FacadeView fabriquerFacadeView() {
        return new FacadeViewImpl();
    }
}