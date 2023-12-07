package net.ent.etrs.gestionblinde.model.facades;

public final class FacadeMetierFactory {

    private FacadeMetierFactory(){

    }

    public static FacadeMetierVehiculeBlinde fabriquerFacadeMetier(){
        return new FacadeMetierVehiculeBlindeImpl();
    }

}
