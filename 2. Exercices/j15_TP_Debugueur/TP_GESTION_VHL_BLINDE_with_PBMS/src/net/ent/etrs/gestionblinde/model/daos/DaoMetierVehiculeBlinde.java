package net.ent.etrs.gestionblinde.model.daos;

import net.ent.etrs.gestionblinde.model.daos.exceptions.DaoMetierVehiculeBlindeException;
import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;

import java.util.List;
import java.util.UUID;

public interface DaoMetierVehiculeBlinde {

    public VehiculeBlinde create (VehiculeBlinde vhl) throws DaoMetierVehiculeBlindeException;

    public List<VehiculeBlinde> readAll();

    public VehiculeBlinde update (VehiculeBlinde vhl) throws DaoMetierVehiculeBlindeException;

    public void delete (String emmat8) throws DaoMetierVehiculeBlindeException;
}
