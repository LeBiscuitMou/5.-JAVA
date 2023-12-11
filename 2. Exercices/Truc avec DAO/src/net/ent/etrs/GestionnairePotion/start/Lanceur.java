package net.ent.etrs.GestionnairePotion.start;

import net.ent.etrs.GestionnairePotion.model.facades.FacadeMetier;
import net.ent.etrs.GestionnairePotion.model.facades.impl.FacadeMetierFactory;
import net.ent.etrs.GestionnairePotion.presenter.Presenteur;
import net.ent.etrs.GestionnairePotion.presenter.PresenteurFactory;
import net.ent.etrs.GestionnairePotion.vues.facades.FacadeVue;
import net.ent.etrs.GestionnairePotion.vues.facades.impl.FacadeVueFactory;

public class Lanceur {
    public static void main(String[] args) {
        try {
            // pas de vue pour le moment
            FacadeVue fVue = FacadeVueFactory.fabriquerFacadeVue();
            // facade
            FacadeMetier fMet = FacadeMetierFactory.fabriquerFacadeMetier();
            // presenteur (vue, facade)
            Presenteur presenteur = PresenteurFactory.fabriquerPresenteur(fMet, fVue);
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
