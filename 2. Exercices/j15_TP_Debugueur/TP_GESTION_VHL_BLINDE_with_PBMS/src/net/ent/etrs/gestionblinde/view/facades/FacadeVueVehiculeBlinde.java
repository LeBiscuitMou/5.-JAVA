package net.ent.etrs.gestionblinde.view.facades;

import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;

import java.util.List;

public interface FacadeVueVehiculeBlinde {

   void afficherMessage(String message);
   void afficherMessageErreur(String message);

   void afficherLesVHL(List<VehiculeBlinde> vhls);

   VehiculeBlinde creerVehiculeBlinde();

   VehiculeBlinde supprimerVehiculeBlinde(List<VehiculeBlinde> vhls);

}
