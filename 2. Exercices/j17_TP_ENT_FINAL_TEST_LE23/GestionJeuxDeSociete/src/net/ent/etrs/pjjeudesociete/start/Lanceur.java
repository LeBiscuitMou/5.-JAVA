package net.ent.etrs.pjjeudesociete.start;

import net.ent.etrs.pjjeudesociete.models.facade.FacadeMetier;
import net.ent.etrs.pjjeudesociete.models.facade.impl.FactoryFacadeMetier;
import net.ent.etrs.pjjeudesociete.presenteur.Presenteur;
import net.ent.etrs.pjjeudesociete.presenteur.PresenteurFactory;
import net.ent.etrs.pjjeudesociete.presenteur.exceptions.PresenteurException;
import net.ent.etrs.pjjeudesociete.presenteur.exceptions.PresenteurFactoryException;
import net.ent.etrs.pjjeudesociete.views.facade.FacadeView;
import net.ent.etrs.pjjeudesociete.views.facade.impl.FactoryFacadeView;

public class Lanceur {
    public static void main(String[] args) {
        try {
            FacadeView fv = FactoryFacadeView.fabriquerFacadeView();
            FacadeMetier fm = FactoryFacadeMetier.fabriquerFacadeMetier();
            Presenteur p = PresenteurFactory.fabriquerPresenteur(fv, fm);
            p.start();
        } catch (PresenteurFactoryException e) {
            e.printStackTrace();
        }
    }
}