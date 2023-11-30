package net.ent.etrs.gestionVehicule.model.facade;

import net.ent.etrs.gestionVehicule.model.entities.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface FacadeMetier {
     Vehicule sauvegarderVehicule(Vehicule v);
     List<Vehicule> recupererTousVehicule();
    List<Vehicule> recupererTousVhlSortieAvant(LocalDate dateSortie);
    List<Vehicule>  recupererTousVhlConsoSuperieur(float valeur);
    void supprimerVehicule(Vehicule v);
}
