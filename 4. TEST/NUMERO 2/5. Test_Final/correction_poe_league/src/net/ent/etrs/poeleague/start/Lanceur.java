package net.ent.etrs.poeleague.start;

import net.ent.etrs.poeleague.model.facade.FactoryFacadeMetier;
import net.ent.etrs.poeleague.presenteur.Presenteur;
import net.ent.etrs.poeleague.presenteur.exception.PresenteurException;
import net.ent.etrs.poeleague.view.facade.impl.FactoryFacadeView;

public class Lanceur {
    public static void main(String[] args) {
        Presenteur p = null;
        try {
            p = new Presenteur(FactoryFacadeMetier.fabriquerFacadeMetier(), FactoryFacadeView.fabriquerFacadeView());
            p.start();
        } catch (PresenteurException e) {
            System.out.println("Impossible de démarrer le logiciel");
        }

    }
}
