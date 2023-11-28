package net.ent.etrs.projet.presenter;

import net.ent.etrs.projet.model.facades.FacadeMetier;
import net.ent.etrs.projet.presenter.exceptions.PresenteurException;
import net.ent.etrs.projet.presenter.exceptions.PresenteurFactoryException;

public final class PresenteurFactory {
    private PresenteurFactory() {
    }

    public static Presenteur fabriquerPresenteur(FacadeMetier facadeMetier) throws PresenteurFactoryException {
        try {
            return new Presenteur(facadeMetier);
        } catch (PresenteurException e) {
            throw new PresenteurFactoryException(e);
        }
    }
}
