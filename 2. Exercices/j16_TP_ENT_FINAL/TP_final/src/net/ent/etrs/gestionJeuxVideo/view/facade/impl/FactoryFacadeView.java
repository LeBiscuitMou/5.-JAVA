package net.ent.etrs.gestionJeuxVideo.view.facade.impl;

import net.ent.etrs.gestionJeuxVideo.view.facade.FacadeView;

public final class FactoryFacadeView {
    private FactoryFacadeView() {
    }

    public static FacadeView fabriquerFacadeView() {
        return new FacadeViewImpl();
    }
}