package net.ent.etrs.gestionJeuxVideo.start;

import net.ent.etrs.gestionJeuxVideo.models.facade.FacadeMetier;
import net.ent.etrs.gestionJeuxVideo.models.facade.impl.FactoryFacadeMetier;
import net.ent.etrs.gestionJeuxVideo.presenteur.Presenteur;
import net.ent.etrs.gestionJeuxVideo.presenteur.exceptions.PresenteurException;
import net.ent.etrs.gestionJeuxVideo.view.facade.FacadeView;
import net.ent.etrs.gestionJeuxVideo.view.facade.impl.FactoryFacadeView;

public class Lanceur {
    public static void main(String[] args) {
        Presenteur p = null;
        try {
            FacadeView fv = FactoryFacadeView.fabriquerFacadeView();
            FacadeMetier fm = FactoryFacadeMetier.fabriquerFacadeMetier();
            p = new Presenteur(fv, fm);
            p.start();
        } catch (PresenteurException e) {
            e.printStackTrace();
        }
    }
}