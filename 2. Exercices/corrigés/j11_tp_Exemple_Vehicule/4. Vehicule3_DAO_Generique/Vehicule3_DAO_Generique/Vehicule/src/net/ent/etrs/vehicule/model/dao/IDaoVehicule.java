package net.ent.etrs.vehicule.model.dao;

import net.ent.etrs.vehicule.model.dao.exception.DaoException;
import net.ent.etrs.vehicule.model.dao.impl.exception.DaoVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;

import java.time.LocalDate;
import java.util.List;

public interface IDaoVehicule extends BaseDao<Vehicule> {

   List<Vehicule> recupererVehiculesDontConsoSupA(float conso) throws DaoException;

   List<Vehicule> recupererVehiculesSortiesAvantDate(LocalDate date) throws DaoVehiculeImplMemException, DaoException;
}
