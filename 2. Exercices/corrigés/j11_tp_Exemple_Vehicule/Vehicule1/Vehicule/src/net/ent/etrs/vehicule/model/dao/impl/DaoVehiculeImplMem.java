package net.ent.etrs.vehicule.model.dao.impl;

import net.ent.etrs.vehicule.model.dao.IDaoVehicule;
import net.ent.etrs.vehicule.model.dao.impl.exception.DaoVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.references.ConstantesMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DaoVehiculeImplMem implements IDaoVehicule {

    private List<Vehicule> persistanceListeDeVehicule = new ArrayList<>();
    @Override
    public List<Vehicule> recupererVehicules() {
        return Collections.unmodifiableList(persistanceListeDeVehicule);
    }

    @Override
    public Vehicule sauvegarderVehicule(Vehicule vhl) throws DaoVehiculeImplMemException {
        if (Objects.isNull(vhl)) {
            throw new DaoVehiculeImplMemException(ConstantesMetier.VEHICULE_NULL);
        }
        if (persistanceListeDeVehicule.contains(vhl)) {
            throw new DaoVehiculeImplMemException(ConstantesMetier.VEHICULE_EXISTE_DEJA);
        }
        //Règle métier

        this.persistanceListeDeVehicule.add(vhl);
        return vhl;
    }

    @Override
    public Vehicule mettreAJourVehicule(Vehicule vhl) throws DaoVehiculeImplMemException {
        if (Objects.isNull(vhl)) {
            throw new DaoVehiculeImplMemException(ConstantesMetier.VEHICULE_NULL);
        }
        if (!persistanceListeDeVehicule.contains(vhl)) {
            throw new DaoVehiculeImplMemException(ConstantesMetier.VEHICULE_EXISTE_PAS);
        }
        persistanceListeDeVehicule.set(persistanceListeDeVehicule.indexOf(vhl), vhl);
        return vhl;
    }

    @Override
    public void supprimerVehicule(Vehicule vhl) throws DaoVehiculeImplMemException {
        if (Objects.isNull(vhl)) {
            throw new DaoVehiculeImplMemException(ConstantesMetier.VEHICULE_NULL);
        }
        persistanceListeDeVehicule.remove(vhl);
    }

    @Override
    public Vehicule recupererVehicule(String immat) throws DaoVehiculeImplMemException {
        if (Objects.isNull(immat)){
            throw new DaoVehiculeImplMemException(ConstantesMetier.IMMAT_NULL);
        }
        if (immat.isBlank()){
        throw new DaoVehiculeImplMemException(ConstantesMetier.IMMAT_BLANK);
        }

        for (Vehicule vhl : persistanceListeDeVehicule) {
         if (vhl.getImmat().equals(immat)){
             return vhl;
            }
         }throw new DaoVehiculeImplMemException(ConstantesMetier.VEHICULE_EXISTE_PAS);

    }

    @Override
    public List<Vehicule> recupererVehiculesDontConsoSupA(float conso) {
        List<Vehicule> resultatVehicule = new ArrayList<>();
        for (Vehicule v : this.persistanceListeDeVehicule) {

            if (v.getConsomation() > conso) {
                resultatVehicule.add(v);
            }
        }
        return Collections.unmodifiableList(resultatVehicule);
    }

    @Override
    public List<Vehicule> recupererVehiculesSortiesAvantDate(LocalDate date) throws DaoVehiculeImplMemException {
        if (Objects.isNull(date)) {
            throw new DaoVehiculeImplMemException(ConstantesMetier.DATE_DE_SORTIE_NULL);
        }
        List<Vehicule> resultatVehicule = new ArrayList<>();
        for (Vehicule v : persistanceListeDeVehicule) {

            if (v.getDateDeSortie().isBefore(date)) {
                resultatVehicule.add(v);
            }
        }
        return Collections.unmodifiableList(resultatVehicule);
    }
}
