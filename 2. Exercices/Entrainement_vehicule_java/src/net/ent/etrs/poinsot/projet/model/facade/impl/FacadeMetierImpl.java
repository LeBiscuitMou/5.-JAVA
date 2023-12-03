package net.ent.etrs.poinsot.projet.model.facade.impl;

import net.ent.etrs.poinsot.projet.model.entities.Vehicule;
import net.ent.etrs.poinsot.projet.model.facade.FacadeMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {
    private List<Vehicule> lesVehicules = new ArrayList<>();

    protected FacadeMetierImpl() {
    }

    @Override
    public Vehicule sauvegarderVehicule(Vehicule vehicule) {
        return null;
    }

    @Override
    public List<Vehicule> recupererTousLesVehicules() {
        return Collections.unmodifiableList(lesVehicules);
    }

    @Override
    public List<Vehicule> recupererTousLesVehiculesSortisAvant(LocalDate dateSortie) {
        return null;
    }

    @Override
    public List<Vehicule> recupererTousLesVehiculesConsoSuperieur(float consommation) {
        return null;
    }

    @Override
    public void supprimerVehicule(Vehicule vehicule) {

    }
}