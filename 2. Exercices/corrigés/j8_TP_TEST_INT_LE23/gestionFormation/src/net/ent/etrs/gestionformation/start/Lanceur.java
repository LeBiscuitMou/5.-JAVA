package net.ent.etrs.gestionformation.start;

import net.ent.etrs.gestionformation.models.facade.FactoryFacadeMetier;
import net.ent.etrs.gestionformation.presenter.Presenteur;
import net.ent.etrs.gestionformation.presenter.exceptions.PresenteurException;
import net.ent.etrs.gestionformation.view.facade.FactoryFacadeView;

public class Lanceur {

    public static void main(String[] args) {

        Presenteur p = null;
        try {
            p = new Presenteur(FactoryFacadeView.fabriquerFacadeView(),
                    FactoryFacadeMetier.fabriquerFacadeMetier());
            p.start();
        } catch (PresenteurException e) {
            System.out.println("Impossible de démarrer l'application, contacter votre Administrateur");
        }


    }

}
