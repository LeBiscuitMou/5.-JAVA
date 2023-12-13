package net.ent.etrs.gestionLeague.views.facade.impl;

import net.ent.etrs.gestionLeague.views.facade.FacadeView;

public final class FactoryFacadeView {

    private FactoryFacadeView() {
    }

    public static FacadeView fabriquerFacadeView() {

        return new FacadeViewImpl();
    }
}
