package net.ent.etrs.GestionnairePotion.presenter;

import net.ent.etrs.GestionnairePotion.model.facades.FacadeMetier;
import net.ent.etrs.GestionnairePotion.presenter.exceptions.PresenteurException;
import net.ent.etrs.GestionnairePotion.presenter.exceptions.PresenteurFactoryException;
import net.ent.etrs.GestionnairePotion.vues.facades.FacadeVue;

public final class PresenteurFactory {
    private PresenteurFactory() {
    }

    public static Presenteur fabriquerPresenteur(FacadeMetier fMet, FacadeVue fVue) throws PresenteurFactoryException {
        try {
            return new Presenteur(fMet, fVue);
        } catch (PresenteurException e) {
            throw new PresenteurFactoryException(e);
        }
    }
}
