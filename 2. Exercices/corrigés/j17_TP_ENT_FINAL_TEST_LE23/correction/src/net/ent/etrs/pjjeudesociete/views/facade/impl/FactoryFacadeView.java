package net.ent.etrs.pjjeudesociete.views.facade.impl;

import net.ent.etrs.pjjeudesociete.views.facade.FacadeView;

public final class FactoryFacadeView {

    private FactoryFacadeView() {
    }

    public static FacadeView fabriquerFacadeView() {

        return new FacadeViewImpl();
    }
}
