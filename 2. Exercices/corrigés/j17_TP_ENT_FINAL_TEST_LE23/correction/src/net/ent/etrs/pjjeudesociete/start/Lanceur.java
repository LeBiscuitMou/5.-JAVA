package net.ent.etrs.pjjeudesociete.start;

import net.ent.etrs.pjjeudesociete.models.facade.impl.FactoryFacadeMetier;
import net.ent.etrs.pjjeudesociete.presenter.Presenteur;
import net.ent.etrs.pjjeudesociete.presenter.exception.PresenteurException;
import net.ent.etrs.pjjeudesociete.views.facade.impl.FactoryFacadeView;

public class Lanceur {
    public static void main(String[] args) {
        try {
            Presenteur p = new Presenteur(FactoryFacadeMetier.fabriquerFacadeMetier(), FactoryFacadeView.fabriquerFacadeView());
            p.start();
        } catch (PresenteurException e) {
            e.printStackTrace();
        }
    }
}
