package net.ent.etrs.potionmagique.start;

import net.ent.etrs.potionmagique.presenteur.Presenteur;
import net.ent.etrs.potionmagique.presenteur.exception.PresenteurException;
import net.ent.etrs.potionmagique.view.commons.utils.AffichageConsole;
import net.ent.etrs.potionmagique.view.facade.impl.FacadeFactory;


public class Lanceur {

    public static void main(String[] args) {
        try {
            information();
            Presenteur p = new Presenteur(FacadeFactory.fabriquerFacadeView(), net.ent.etrs.potionmagique.models.facade.impl.FacadeFactory.fabriquerFacadeMetier());
            p.start();
        } catch (PresenteurException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void information() {
        AffichageConsole.afficherMessageAvecSautLigne("Quand fut tué le roi Arthur :" + " à la Bataille de Camlann par Mordred vers 535 (ou 542)");
    }
}
