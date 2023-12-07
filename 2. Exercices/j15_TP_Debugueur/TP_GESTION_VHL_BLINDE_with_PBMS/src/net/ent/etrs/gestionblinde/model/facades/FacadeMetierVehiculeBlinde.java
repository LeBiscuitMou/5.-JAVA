package net.ent.etrs.gestionblinde.model.facades;

import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;

import java.util.List;
import java.util.UUID;

public interface FacadeMetierVehiculeBlinde {

    public VehiculeBlinde ajouterVehiculeBlinde(VehiculeBlinde vhl);

    public VehiculeBlinde majVehiculeBlinde(VehiculeBlinde vhl);

    public List<VehiculeBlinde> selectionnerTousVehiculeBlinde();

    public void supprimerVehiculeBlinde(UUID emmat8);
}
