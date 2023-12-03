package net.ent.etrs.poinsot.projet.start;

import net.ent.etrs.poinsot.projet.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.projet.model.facade.impl.FactoryFacadeMetier;
import net.ent.etrs.poinsot.projet.presenteur.Presenteur;
import net.ent.etrs.poinsot.projet.presenteur.exceptions.PresenteurException;
import net.ent.etrs.poinsot.projet.view.facade.FacadeView;
import net.ent.etrs.poinsot.projet.view.facade.impl.FactoryFacadeView;

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