package net.ent.etrs.gestionVehicule.view.facade;

import net.ent.etrs.gestionVehicule.model.entities.Vehicule;
import net.ent.etrs.gestionVehicule.view.facade.exceptions.FacadeViewException;

import java.time.LocalDate;
import java.util.List;

public interface FacadeView {
    void afficherMessage(String message);
    void afficherMessageErreur(String message);
    void afficherMenuPrincipal(List<String> menu);
    void afficherVehicules(List<Vehicule> lesVehicules);
    float saisirConsommation();
    LocalDate saisirDateSortie();
    Vehicule selectionnerVehicule(List<Vehicule> lesVehicules) throws FacadeViewException;
    Vehicule creerVehicule() throws FacadeViewException;
}
