package net.ent.etrs.vehicule.model.dao;

import net.ent.etrs.vehicule.model.dao.impl.exception.DaoVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface IDaoVehicule {

   List<Vehicule> recupererVehicules();

   Vehicule sauvegarderVehicule(Vehicule vhl) throws DaoVehiculeImplMemException;

   Vehicule mettreAJourVehicule(Vehicule vhl) throws DaoVehiculeImplMemException;

   void supprimerVehicule(Vehicule vhl) throws DaoVehiculeImplMemException;

   Vehicule recupererVehicule(String immat) throws DaoVehiculeImplMemException;

   List<Vehicule> recupererVehiculesDontConsoSupA(float conso);

   List<Vehicule> recupererVehiculesSortiesAvantDate(LocalDate date) throws DaoVehiculeImplMemException;
}
