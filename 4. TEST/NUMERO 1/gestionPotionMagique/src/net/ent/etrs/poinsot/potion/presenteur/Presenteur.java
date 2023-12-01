package net.ent.etrs.poinsot.potion.presenteur;

import net.ent.etrs.poinsot.potion.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.potion.presenteur.exceptions.PresenteurException;
import net.ent.etrs.poinsot.potion.view.facade.FacadeView;
import net.ent.etrs.poinsot.potion.view.references.ConstanteView;

import java.util.Objects;

public class Presenteur {
    private FacadeView facadeView;
    private FacadeMetier facadeMetier;

    public Presenteur(FacadeView facadeView, FacadeMetier facadeMetier) throws PresenteurException {
        this.setFacadeView(facadeView);
        this.setFacadeMetier(facadeMetier);
    }

    public void setFacadeView(FacadeView facadeView) throws PresenteurException {
        if (Objects.isNull(facadeView)) {
            throw new PresenteurException(ConstanteView.PRESENTEUR_FACADE_VIEW_IS_NULL);
        }
        this.facadeView = facadeView;
    }

    public void setFacadeMetier(FacadeMetier facadeMetier) throws PresenteurException {
        if (Objects.isNull(facadeMetier)) {
            throw new PresenteurException(ConstanteView.PRESENTEUR_FACADE_METIER_IS_NULL);
        }
        this.facadeMetier = facadeMetier;
    }

    public void start() {
    }
}