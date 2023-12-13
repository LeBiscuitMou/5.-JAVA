package net.ent.etrs.poeleague.view.facade.impl;


import net.ent.etrs.poeleague.view.facade.FacadeView;

public final class FactoryFacadeView {

    private FactoryFacadeView() {
    }

    public static FacadeView fabriquerFacadeView() {

        return new FacadeViewImpl();
    }
}
