package net.ent.etrs.vehicule.view.facade;



import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.view.facade.exceptions.FacadeViewException;

import java.time.LocalDate;
import java.util.List;

public interface FacadeView {

    //Usage générale
    void afficherMessageErreur(String message);

    void afficherMessage(String message);

    void afficherMenuPrincipal(List<String> menu);


    // base vehicule
    Vehicule creerVehicule() throws FacadeViewException;

    Vehicule selectionnerVehicule(List<Vehicule> listeDeVehicule) throws FacadeViewException;

    void afficherLesVehicule(List<Vehicule> listVehicule);

    //Autre
    LocalDate saisieDate();

    float saisieConso();
}


