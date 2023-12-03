package net.ent.etrs.exemplePersonne.view.facade.impl;

import net.ent.etrs.exemplePersonne.view.facade.FacadeView;

public final class FacadeViewFactory {
    private FacadeViewFactory() {
    }

    public static FacadeView fabriquerFacadeView() {
        return new FacadeViewImpl();
    }
}
