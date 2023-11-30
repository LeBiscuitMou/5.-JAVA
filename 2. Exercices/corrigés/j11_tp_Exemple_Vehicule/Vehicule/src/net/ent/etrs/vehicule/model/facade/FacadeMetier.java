package net.ent.etrs.vehicule.model.facade;

import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.facade.exceptions.FacadeException;

import java.time.LocalDate;
import java.util.List;

public interface FacadeMetier {

    //Base Vehicule

    Vehicule sauvegarderVehicule(Vehicule vehicule) throws FacadeException;

    List<Vehicule> selectionnerToutLesVehicule();

    void supprimerUnVehicule(Vehicule vhl) throws FacadeException;

    //Autre
    List<Vehicule> vehiculeSortieAvantDate(LocalDate dateATester) throws FacadeException;

    List<Vehicule> vehiculeConsoSupA(float consoATester);
}
