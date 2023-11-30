package net.ent.etrs.gestionVehicule.start;

import net.ent.etrs.gestionVehicule.model.facade.FacadeMetier;
import net.ent.etrs.gestionVehicule.model.facade.facadeImpl.FacadeFactory;
import net.ent.etrs.gestionVehicule.presenteur.Presenteur;
import net.ent.etrs.gestionVehicule.presenteur.exceptions.PresenteurException;
import net.ent.etrs.gestionVehicule.view.facade.FacadeView;
import net.ent.etrs.gestionVehicule.view.facade.impl.FactoryFacadeView;

public class Lanceur {
    public static void main(String[] args) {
        Presenteur p = null;
        try {
            FacadeView fv = FactoryFacadeView.fabriquerFacadeView();
            FacadeMetier fm = FacadeFactory.fabriquerFacadeMetier();
            p = new Presenteur(fv, fm);
            p.start();
        } catch (PresenteurException e) {
            e.printStackTrace();
        }
    }
}2