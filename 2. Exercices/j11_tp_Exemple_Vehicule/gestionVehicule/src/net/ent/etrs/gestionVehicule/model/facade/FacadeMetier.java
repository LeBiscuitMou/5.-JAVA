package net.ent.etrs.gestionVehicule.model.facade;

import net.ent.etrs.gestionVehicule.model.entities.Vehicule;
import net.ent.etrs.gestionVehicule.model.facade.exceptions.FacadeMetierException;

import java.time.LocalDate;
import java.util.List;

public interface FacadeMetier {
     Vehicule sauvegarderVehicule(Vehicule v) throws FacadeMetierException;
     List<Vehicule> recupererTousVehicule();
    List<Vehicule> recupererTousVhlSortieAvant(LocalDate dateSortie);
    List<Vehicule>  recupererTousVhlConsoSuperieur(float valeur) throws FacadeMetierException;
    void supprimerVehicule(Vehicule v) throws FacadeMetierException;
}
