package net.ent.etrs.gestionblinde.view.facades.impl;

import net.ent.etrs.gestionblinde.view.facades.FacadeVueVehiculeBlinde;

public final class FacadeViewFactory {
    private FacadeViewFactory() {
    }

    public static FacadeVueVehiculeBlinde fabriquerFacadeVueVehiculeBlinde() {
        return new FacadeVueVehiculeBlindeImpl();
    }
}