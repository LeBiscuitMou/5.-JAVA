package net.ent.etrs.poinsot.projet.presenteur;

import net.ent.etrs.poinsot.projet.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.projet.presenteur.exceptions.PresenteurException;
import net.ent.etrs.poinsot.projet.presenteur.exceptions.PresenteurFactoryException;
import net.ent.etrs.poinsot.projet.presenteur.references.ConstantePresenteur;
import net.ent.etrs.poinsot.projet.view.facade.FacadeView;

public final class PresenteurFactory {
    private PresenteurFactory() {
    }

    public static Presenteur fabriquerPresenteur(FacadeView fVue, FacadeMetier fMet) throws PresenteurFactoryException {
        try {
            return new Presenteur(fVue, fMet);
        } catch (PresenteurException e) {
            throw new PresenteurFactoryException(ConstantePresenteur.PRESENTEUR_FACTORY_EXCEPTION, e);
        }
    }
}
