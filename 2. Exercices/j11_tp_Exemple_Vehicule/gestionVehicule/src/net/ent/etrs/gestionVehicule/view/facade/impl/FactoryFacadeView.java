package net.ent.etrs.gestionVehicule.view.facade.impl;

import net.ent.etrs.gestionVehicule.view.facade.FacadeView;
import net.ent.etrs.gestionVehicule.view.facade.impl.FacadeViewImpl;

public final class FactoryFacadeView {
    private FactoryFacadeView(){}

    public static FacadeView fabriquerFacadeView(){
        return new FacadeViewImpl();
    }
}
