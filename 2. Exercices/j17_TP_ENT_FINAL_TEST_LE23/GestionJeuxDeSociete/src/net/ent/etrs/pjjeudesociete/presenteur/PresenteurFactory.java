package net.ent.etrs.pjjeudesociete.presenteur;

import net.ent.etrs.pjjeudesociete.models.facade.FacadeMetier;
import net.ent.etrs.pjjeudesociete.presenteur.exceptions.PresenteurException;
import net.ent.etrs.pjjeudesociete.presenteur.exceptions.PresenteurFactoryException;
import net.ent.etrs.pjjeudesociete.presenteur.references.ConstantePresenteur;
import net.ent.etrs.pjjeudesociete.views.facade.FacadeView;

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
