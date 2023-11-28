package net.ent.etrs.projet.start;

import net.ent.etrs.projet.model.facades.FacadeMetier;
import net.ent.etrs.projet.model.facades.impl.FacadeFactory;
import net.ent.etrs.projet.presenter.Presenteur;
import net.ent.etrs.projet.presenter.PresenteurFactory;

public class Lanceur {
    public static void main(String[] args) {
        try {
            // pas de vue pour le moment

            // facade
            FacadeMetier facadeMetier = FacadeFactory.fabriquerFacadeMetier();
            // presenteur (vue, facade)
            Presenteur presenteur = PresenteurFactory.fabriquerPresenteur(facadeMetier);
            // exec presenteur
            presenteur.exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* ******************************** VARIABLES ******************************** */

    /* ******************************* CONSTRUCTOR ******************************* */

    /* ********************************* GETTERS ********************************* */

    /* ********************************* SETTERS ********************************* */

    /* ******************************** FONCTIONS ******************************** */

    /* **************************** PRIVATE FUNCTIONS **************************** */
}
