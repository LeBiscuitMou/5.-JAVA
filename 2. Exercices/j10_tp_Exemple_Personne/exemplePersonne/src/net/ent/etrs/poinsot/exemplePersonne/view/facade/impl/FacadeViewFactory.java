package net.ent.etrs.poinsot.exemplePersonne.view.facade.impl;

import net.ent.etrs.poinsot.exemplePersonne.view.facade.FacadeView;

public class FacadeViewFactory {
    public static FacadeView fabriquerFacadeView() {
        return new FacadeViewImpl();
    }
}
