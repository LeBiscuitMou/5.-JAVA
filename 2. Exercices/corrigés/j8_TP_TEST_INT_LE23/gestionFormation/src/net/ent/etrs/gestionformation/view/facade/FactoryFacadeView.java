package net.ent.etrs.gestionformation.view.facade;

import net.ent.etrs.gestionformation.view.facade.impl.FacadeViewImpl;

public final class FactoryFacadeView {
    private FactoryFacadeView(){}

    public static FacadeView fabriquerFacadeView(){
        return new FacadeViewImpl();
    }
}
