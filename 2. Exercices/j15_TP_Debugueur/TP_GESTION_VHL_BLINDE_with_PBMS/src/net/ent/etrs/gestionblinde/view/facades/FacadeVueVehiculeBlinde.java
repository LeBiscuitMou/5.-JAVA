package net.ent.etrs.gestionblinde.view.facades;

import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;
import net.ent.etrs.gestionblinde.model.facades.exceptions.FacadeException;

import java.util.List;

public interface FacadeVueVehiculeBlinde {

   void afficherMessage(String message);
   void afficherMessageErreur(String message);

   void afficherMenuPrincipal(List<String> menu);
   void afficherLesVHL(List<VehiculeBlinde> vhls) throws FacadeException;

   VehiculeBlinde creerVehiculeBlinde();

   VehiculeBlinde supprimerVehiculeBlinde(List<VehiculeBlinde> vhls) throws FacadeException;

}
