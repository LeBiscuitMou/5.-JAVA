package net.ent.etrs.vehicule.model.dao.impl;

import net.ent.etrs.vehicule.model.dao.IDAOVehicule;
import net.ent.etrs.vehicule.model.dao.impl.exceptions.DAOVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.facade.exceptions.FacadeException;
import net.ent.etrs.vehicule.model.references.ConstantesMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DAOVehiculeImplMem implements IDAOVehicule {
    private List<Vehicule> persistanceListeDeVehicule = new ArrayList<>();

    @Override
    public List<Vehicule> recupererTousLesVehicules() {
        return Collections.unmodifiableList(persistanceListeDeVehicule);
    }

    @Override
    public Vehicule sauvegarderVehicule(Vehicule vhl) throws DAOVehiculeImplMemException {
        if (persistanceListeDeVehicule.contains(vhl)) {
            throw new DAOVehiculeImplMemException(ConstantesMetier.VEHICULE_EXISTE_DEJA);
        }
        //Règle métier

        this.persistanceListeDeVehicule.add(vhl);
        return vhl;
    }

    @Override
    public void supprimerUnVehicule(Vehicule vhl) throws DAOVehiculeImplMemException {
        if (Objects.isNull(vhl)) {
            throw new DAOVehiculeImplMemException(ConstantesMetier.VEHICULE_NULL);
        }
        persistanceListeDeVehicule.remove(vhl);
    }

    @Override
    public Vehicule mettreAJourVehicule(Vehicule vhl) throws DAOVehiculeImplMemException {
        if (Objects.isNull(vhl)) {
            throw new DAOVehiculeImplMemException(ConstantesMetier.VEHICULE_NULL);
        }
        if (!persistanceListeDeVehicule.contains(vhl)) {
            throw new DAOVehiculeImplMemException(ConstantesMetier.DAO_VEHICULE_NON_TROUVE);
        }
        persistanceListeDeVehicule.set(persistanceListeDeVehicule.indexOf(vhl), vhl);
        return vhl;
    }

    @Override
    public Vehicule recupererVehicule(String immat) throws DAOVehiculeImplMemException {
        if (Objects.isNull(immat)) {
            throw new DAOVehiculeImplMemException(ConstantesMetier.DAO_VEHICULE_IMPL_MEM_IMMAT_IS_NULL);
        }
        if (immat.isBlank()) {
            throw new DAOVehiculeImplMemException(ConstantesMetier.DAO_VEHICULE_IMPL_MEM_IMMAT_IS_BLANK);
        }
        for (Vehicule v : persistanceListeDeVehicule) {
            if (v.getImmat().equals(immat)) {
                return v;
            }
        }
        throw new DAOVehiculeImplMemException(ConstantesMetier.DAO_VEHICULE_NON_TROUVE);
    }

    @Override
    public List<Vehicule> recupererVehiculeSortieAvantDate(LocalDate dateATester) throws DAOVehiculeImplMemException {
        if (Objects.isNull(dateATester)) {
            throw new DAOVehiculeImplMemException(ConstantesMetier.DATE_DE_SORTIE_NULL);
        }
        List<Vehicule> resultatVehicule = new ArrayList<>();
        for (Vehicule v : persistanceListeDeVehicule) {
            if (v.getDateDeSortie().isBefore(dateATester)) {
                resultatVehicule.add(v);
            }
        }
        return resultatVehicule;
    }

    @Override
    public List<Vehicule> recupererVehiculeConsoSupA(float consoATester) {
        List<Vehicule> resultatVehicule = new ArrayList<>();
        for (Vehicule v : persistanceListeDeVehicule) {
            if (v.getConsomation() > consoATester) {
                resultatVehicule.add(v);
            }
        }
        return resultatVehicule;
    }
}