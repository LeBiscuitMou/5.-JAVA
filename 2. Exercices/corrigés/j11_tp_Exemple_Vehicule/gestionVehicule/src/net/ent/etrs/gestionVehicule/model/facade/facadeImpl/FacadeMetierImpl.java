package net.ent.etrs.gestionVehicule.model.facade.facadeImpl;

import net.ent.etrs.gestionVehicule.model.entities.Vehicule;
import net.ent.etrs.gestionVehicule.model.facade.FacadeMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {

    private List<Vehicule> persistanceVehicule = new ArrayList<>();

    @Override
    public Vehicule sauvegarderVehicule(Vehicule v) {
        return null;
    }

    @Override
    public List<Vehicule> recupererTousVehicule() {
        return Collections.unmodifiableList(this.persistanceVehicule);
    }

    @Override
    public List<Vehicule> recupererTousVhlSortieAvant(LocalDate dateSortie) {
        List<Vehicule> retour = new ArrayList<>();
        for (Vehicule v: this.persistanceVehicule) {
            if(v.getDateDeSortie().isBefore(dateSortie)){
                retour.add(v);
            }
        }
        return retour;
    }

    @Override
    public List<Vehicule> recupererTousVhlConsoSuperieur(float valeur) {
        return null;
    }

    @Override
    public void supprimerVehicule(Vehicule v) {

    }
}
