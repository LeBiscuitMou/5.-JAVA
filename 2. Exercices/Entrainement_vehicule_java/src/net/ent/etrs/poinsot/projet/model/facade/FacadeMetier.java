package net.ent.etrs.poinsot.projet.model.facade;

import net.ent.etrs.poinsot.projet.model.entities.Vehicule;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface FacadeMetier {
    Vehicule sauvegarderVehicule(Vehicule vehicule);
    List<Vehicule> recupererTousLesVehicules();
    List<Vehicule> recupererTousLesVehiculesSortisAvant(LocalDate dateSortie);
    List<Vehicule> recupererTousLesVehiculesConsoSuperieur(float consommation);
    void supprimerVehicule(Vehicule vehicule);
}
