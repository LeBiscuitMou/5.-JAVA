package net.ent.etrs.vehicule.model.dao;

import net.ent.etrs.vehicule.model.dao.impl.exceptions.DAOVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface IDAOVehicule {
    List<Vehicule> recupererTousLesVehicules();
    Vehicule sauvegarderVehicule(Vehicule vhl) throws DAOVehiculeImplMemException;
    void supprimerUnVehicule(Vehicule vhl) throws DAOVehiculeImplMemException;
    Vehicule mettreAJourVehicule(Vehicule vhl) throws DAOVehiculeImplMemException;
    Vehicule recupererVehicule(String immat) throws DAOVehiculeImplMemException;
    List<Vehicule> recupererVehiculeSortieAvantDate(LocalDate dateATester) throws DAOVehiculeImplMemException;
    List<Vehicule> recupererVehiculeConsoSupA(float consoATester);
}
