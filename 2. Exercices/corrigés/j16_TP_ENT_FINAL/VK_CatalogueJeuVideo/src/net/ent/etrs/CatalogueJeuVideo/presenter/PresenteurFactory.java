package net.ent.etrs.CatalogueJeuVideo.presenter;

import net.ent.etrs.CatalogueJeuVideo.model.facades.FacadeMetier;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstErrMsg;
import net.ent.etrs.CatalogueJeuVideo.presenter.exceptions.PresenteurException;
import net.ent.etrs.CatalogueJeuVideo.presenter.exceptions.PresenteurFactoryException;
import net.ent.etrs.CatalogueJeuVideo.views.facades.FacadeView;

public final class PresenteurFactory {
    private PresenteurFactory() {
    }

    public static Presenteur fabriquerPresenteur(FacadeMetier fMet, FacadeView fVue) throws PresenteurFactoryException {
        try {
            return new Presenteur(fMet, fVue);
        } catch (PresenteurException e) {
            throw new PresenteurFactoryException(ConstErrMsg.PRESENTER_CREATION, e);
        }
    }
}
