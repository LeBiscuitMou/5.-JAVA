package net.ent.etrs.gestionLeague.presenter;

import net.ent.etrs.gestionLeague.models.facade.FacadeMetier;
import net.ent.etrs.gestionLeague.presenter.exception.PresenteurException;
import net.ent.etrs.gestionLeague.presenter.exception.PresenteurFactoryException;
import net.ent.etrs.gestionLeague.presenter.references.ConstantesPresenteur;
import net.ent.etrs.gestionLeague.views.facade.FacadeView;

public final class PresenteurFactory {
    private PresenteurFactory() {
    }

    public static Presenteur fabriquerPresenteur(FacadeMetier facadeMetier, FacadeView facadeView) throws PresenteurFactoryException {
        try {
            return new Presenteur(facadeMetier, facadeView);
        } catch (PresenteurException e) {
            throw new PresenteurFactoryException(ConstantesPresenteur.PRESENTEUR_FACTORY_EXCEPTION, e);
        }
    }
}