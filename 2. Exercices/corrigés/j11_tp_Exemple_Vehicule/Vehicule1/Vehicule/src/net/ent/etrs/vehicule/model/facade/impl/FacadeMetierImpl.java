package net.ent.etrs.vehicule.model.facade.impl;

import net.ent.etrs.vehicule.model.dao.IDaoVehicule;
import net.ent.etrs.vehicule.model.dao.impl.DaoFactory;
import net.ent.etrs.vehicule.model.dao.impl.exception.DaoVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.facade.exceptions.FacadeException;
import net.ent.etrs.vehicule.model.references.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements net.ent.etrs.vehicule.model.facade.FacadeMetier {

    //Base Vehicule
    IDaoVehicule dao = DaoFactory.fabriquerDaoVehiculeImplMem();

    @Override
    public Vehicule sauvegarderVehicule(Vehicule vehicule) throws FacadeException {
        if (Objects.isNull(vehicule)) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL);
        }
        try {
            return dao.sauvegarderVehicule(vehicule);
        } catch (DaoVehiculeImplMemException e) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL,e);
        }
    }

    @Override
    public List<Vehicule> selectionnerToutLesVehicule() {
      return Collections.unmodifiableList(dao.recupererVehicules());
    }

    @Override
    public void supprimerUnVehicule(Vehicule vhl) throws FacadeException {
        if (Objects.isNull(vhl)) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL);
        }
        try {
            dao.supprimerVehicule(vhl);
        } catch (DaoVehiculeImplMemException e) {
            throw new FacadeException(ConstantesMetier.VEHICULE_NULL,e);
        }
    }

    //Autre
    @Override
    public List<Vehicule> vehiculeSortieAvantDate(LocalDate dateATester) throws FacadeException {
        if(Objects.isNull(dateATester)){
            throw new FacadeException(ConstantesMetier.DATE_DE_SORTIE_NULL);
        }
        try {
            return dao.recupererVehiculesSortiesAvantDate(dateATester);
        } catch (DaoVehiculeImplMemException e) {
            throw new FacadeException(ConstantesMetier.DATE_DE_SORTIE_NULL,e);
        }
    }

    @Override
    public List<Vehicule> vehiculeConsoSupA(float consoATester){
      return dao.recupererVehiculesDontConsoSupA(consoATester);
    }


}
