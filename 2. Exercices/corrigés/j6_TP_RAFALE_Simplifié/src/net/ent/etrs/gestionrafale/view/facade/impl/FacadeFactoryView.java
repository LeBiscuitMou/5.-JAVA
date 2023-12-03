package net.ent.etrs.gestionrafale.view.facade.impl;

import net.ent.etrs.gestionrafale.view.facade.FacadeViewRafale;

public final class FacadeFactoryView {

    private FacadeFactoryView() {
    }

    public static FacadeViewRafale fabriquerFacadeViewRafale() {
        return new FacadeViewRafaleImpl();
    }

}
