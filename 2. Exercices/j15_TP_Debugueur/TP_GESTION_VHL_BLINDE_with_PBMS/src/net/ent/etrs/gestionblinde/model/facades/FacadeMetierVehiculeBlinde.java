package net.ent.etrs.gestionblinde.model.facades;

import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;
import net.ent.etrs.gestionblinde.model.facades.exceptions.FacadeException;

import java.util.List;
import java.util.UUID;

public interface FacadeMetierVehiculeBlinde {

    public VehiculeBlinde ajouterVehiculeBlinde(VehiculeBlinde vhl) throws FacadeException;

    public VehiculeBlinde majVehiculeBlinde(VehiculeBlinde vhl) throws FacadeException;

    public List<VehiculeBlinde> selectionnerTousVehiculeBlinde();

    public void supprimerVehiculeBlinde(String emmat8) throws FacadeException;
}
