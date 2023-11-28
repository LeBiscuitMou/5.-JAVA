package net.ent.etrs.projet.presenter;

import net.ent.etrs.projet.model.facades.FacadeMetier;
import net.ent.etrs.projet.presenter.exceptions.PresenteurException;
import net.ent.etrs.projet.presenter.references.ConstPresenteur;

import java.util.Objects;

public class Presenteur {
    /* ******************************** VARIABLES ******************************** */
    private FacadeMetier facadeMetier;
    /* ******************************* CONSTRUCTOR ******************************* */
    protected Presenteur(FacadeMetier facadeMetier) throws PresenteurException {
        this.setFacadeMetier(facadeMetier);
    }
    /* ********************************* GETTERS ********************************* */

    /* ********************************* SETTERS ********************************* */
    private void setFacadeMetier(FacadeMetier facadeMetier) throws PresenteurException {
        if(Objects.isNull(facadeMetier)){
            throw new PresenteurException(ConstPresenteur.ERROR_FACADE_METIER_NULL);
        }
        this.facadeMetier = facadeMetier;
    }
    /* ******************************** FONCTIONS ******************************** */
    public void exec(){

    }
    /* **************************** PRIVATE FUNCTIONS **************************** */
}
