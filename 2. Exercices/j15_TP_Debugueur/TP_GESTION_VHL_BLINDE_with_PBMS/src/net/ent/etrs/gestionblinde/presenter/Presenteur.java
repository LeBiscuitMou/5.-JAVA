package net.ent.etrs.gestionblinde.presenter;

import net.ent.etrs.gestionblinde.model.facades.FacadeMetierFactory;
import net.ent.etrs.gestionblinde.model.facades.FacadeMetierVehiculeBlinde;

public class Presenteur {

    FacadeMetierVehiculeBlinde fm = FacadeMetierFactory.fabriquerFacadeMetier();

    public void start() {

    }
}
