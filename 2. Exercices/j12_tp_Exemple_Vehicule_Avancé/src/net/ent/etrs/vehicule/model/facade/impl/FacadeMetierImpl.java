package net.ent.etrs.vehicule.model.facade.impl;

import net.ent.etrs.vehicule.model.dao.IDAOVehicule;
import net.ent.etrs.vehicule.model.dao.impl.exceptions.DAOVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.entities.EntitiesFactory;
import net.ent.etrs.vehicule.model.exceptions.FactoryException;
import net.ent.etrs.vehicule.model.exceptions.VehiculeException;
import net.ent.etrs.vehicule.model.facade.exceptions.FacadeException;
import net.ent.etrs.vehicule.model.references.*;
import net.ent.etrs.vehicule.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.vehicule.view.references.ConstantesView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements net.ent.etrs.vehicule.model.facade.FacadeMetier {


    //Base Vehicule
    IDAOVehicule dao = DAOFactory.fabriquerDAOVehiculeImplMem();

    @Override
    public Vehicule sauvegarderVehicule(Vehicule vehicule) throws FacadeException {
        if (Objects.isNull(vehicule)) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL);
        }
        try {
            return dao.sauvegarderVehicule(vehicule);
        } catch (DAOVehiculeImplMemException e) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL, e);
        }
    }

    @Override
    public List<Vehicule> selectionnerToutLesVehicule() {
        return Collections.unmodifiableList(dao.recupererTousLesVehicules());
    }

    @Override
    public void supprimerUnVehicule(Vehicule vhl) throws FacadeException {
        if (Objects.isNull(vhl)) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL);
        }
        try {
            dao.supprimerUnVehicule(vhl);
        } catch (DAOVehiculeImplMemException e) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL, e);
        }
    }

    //Autre
    @Override
    public List<Vehicule> vehiculeSortieAvantDate(LocalDate dateATester) throws FacadeException {
        if (Objects.isNull(dateATester)) {
            throw new FacadeException(ConstantesMetier.DATE_DE_SORTIE_NULL);
        }
        try {
            dao.recupererVehiculeSortieAvantDate(dateATester);
        } catch (DAOVehiculeImplMemException e) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL, e);
        }
    }

    @Override
    public List<Vehicule> vehiculeConsoSupA(float consoATester){

    }
}
