package net.ent.etrs.gestionLeague.start;

import net.ent.etrs.gestionLeague.models.facade.FacadeMetier;
import net.ent.etrs.gestionLeague.models.facade.impl.FactoryFacadeMetier;
import net.ent.etrs.gestionLeague.presenter.Presenteur;
import net.ent.etrs.gestionLeague.presenter.PresenteurFactory;
import net.ent.etrs.gestionLeague.presenter.exception.PresenteurFactoryException;
import net.ent.etrs.gestionLeague.views.facade.FacadeView;
import net.ent.etrs.gestionLeague.views.facade.impl.FactoryFacadeView;

public class Lanceur {
    public static void main(String[] args) {
        Presenteur p = null;
        FacadeMetier fm = FactoryFacadeMetier.fabriquerFacadeMetier();
        FacadeView fv = FactoryFacadeView.fabriquerFacadeView();
        try {
            p = PresenteurFactory.fabriquerPresenteur(fm, fv);
            p.start();
        } catch (PresenteurFactoryException e) {
            e.printStackTrace();
        }
    }
}
