package net.ent.etrs.kingdomino.view.facade.impl;

import net.ent.etrs.kingdomino.view.facade.FacadeView;

public final class FactoryFacadeView {

    private FactoryFacadeView(){}

    public static FacadeView fabriquerFacadeView(){
        return new FacadeViewImpl();
    }
}
