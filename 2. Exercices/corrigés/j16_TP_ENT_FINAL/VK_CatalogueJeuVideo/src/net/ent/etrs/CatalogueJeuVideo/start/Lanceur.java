package net.ent.etrs.CatalogueJeuVideo.start;

import net.ent.etrs.CatalogueJeuVideo.model.facades.FacadeMetier;
import net.ent.etrs.CatalogueJeuVideo.model.facades.impl.FacadeMetierFactory;
import net.ent.etrs.CatalogueJeuVideo.presenter.Presenteur;
import net.ent.etrs.CatalogueJeuVideo.presenter.PresenteurFactory;
import net.ent.etrs.CatalogueJeuVideo.views.facades.FacadeView;
import net.ent.etrs.CatalogueJeuVideo.views.facades.impl.FacadeVueFactory;

public class Lanceur {
    public static void main(String[] args) {

        try {
            // facade vue
            FacadeView fVue = FacadeVueFactory.fabriquerFacadeVue();
            // facade métier
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
