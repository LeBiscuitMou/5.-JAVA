package net.ent.etrs.gestionrafale.view.facade;

import net.ent.etrs.gestionrafale.model.entities.Rafale;
import net.ent.etrs.gestionrafale.model.entities.references.Bombe;
import net.ent.etrs.gestionrafale.model.entities.references.MissileAA;
import net.ent.etrs.gestionrafale.view.facade.exception.FacadeViewRafaleException;

import java.util.List;

public interface FacadeViewRafale {

    void afficherMessageErreur(String message);

    void afficherMessage(String message);

    void afficherMenuPrincipal(List<String> menu);

    void afficherTousLesRafales(List<Rafale> listRafales);

    Rafale creerRafale() throws FacadeViewRafaleException;

    MissileAA selectionnerMissile();

    Bombe selectionnerBombe();

    Rafale selectionnerRafale(List<Rafale> listRafales) throws FacadeViewRafaleException;

    public void affichageDetailRafale(Rafale r);
}
