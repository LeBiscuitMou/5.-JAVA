package net.ent.etrs.vehicule.view.facade.impl;


import net.ent.etrs.vehicule.view.facade.FacadeView;

public final class FacadeFactoryView {

    private FacadeFactoryView(){}

    public static FacadeView fabriquerFacadeView(){
        return new FacadeViewImpl();
    }
}
