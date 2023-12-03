package net.ent.etrs.poinsot.projet.view.facade.impl;

import net.ent.etrs.poinsot.projet.view.facade.FacadeView;

public final class FactoryFacadeView {
    private FactoryFacadeView() {
    }

    public static FacadeView fabriquerFacadeView() {
        return new FacadeViewImpl();
    }
}