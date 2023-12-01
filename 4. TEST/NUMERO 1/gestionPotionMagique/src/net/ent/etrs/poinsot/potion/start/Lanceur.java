package net.ent.etrs.poinsot.potion.start;

import net.ent.etrs.poinsot.potion.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.potion.model.facade.impl.FactoryFacadeMetier;
import net.ent.etrs.poinsot.potion.presenteur.Presenteur;
import net.ent.etrs.poinsot.potion.presenteur.exceptions.PresenteurException;
import net.ent.etrs.poinsot.potion.view.commons.utils.AffichageConsole;
import net.ent.etrs.poinsot.potion.view.facade.FacadeView;
import net.ent.etrs.poinsot.potion.view.facade.impl.FactoryFacadeView;

import java.util.Random;

public class Lanceur {
    public static void main(String[] args) {
        Presenteur p = null;
        try {
            information();
            FacadeView fv = FactoryFacadeView.fabriquerFacadeView();
            FacadeMetier fm = FactoryFacadeMetier.fabriquerFacadeMetier();
            p = new Presenteur(fv, fm);
            p.start();
        } catch (PresenteurException e) {
            e.printStackTrace();
        }
    }

    private static void information() {
        AffichageConsole.afficherMessageAvecSautLigne("Quand fut tué le roi Arthur ?");
        AffichageConsole.afficherMessageAvecSautLigne("Il fut tué en 535 ou 542 selon les sources");
    }
}