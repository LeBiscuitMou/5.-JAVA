package net.ent.etrs.vehicule.model.dao.impl;

import net.ent.etrs.vehicule.model.dao.IDaoVehicule;
import net.ent.etrs.vehicule.model.dao.MemBaseDao;
import net.ent.etrs.vehicule.model.dao.exception.DaoException;
import net.ent.etrs.vehicule.model.dao.impl.exception.DaoVehiculeImplMemException;
import net.ent.etrs.vehicule.model.entities.Vehicule;
import net.ent.etrs.vehicule.model.references.ConstantesMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DaoVehiculeImplMem extends MemBaseDao<Vehicule> implements IDaoVehicule {

    @Override
    public List<Vehicule> recupererVehiculesDontConsoSupA(float conso) throws DaoException {
        List<Vehicule> resultatVehicule = new ArrayList<>();
        for (Vehicule v : this.findAll()) {

            if (v.getConsomation() > conso) {
                resultatVehicule.add(v);
            }
        }
        return Collections.unmodifiableList(resultatVehicule);
    }

    @Override
    public List<Vehicule> recupererVehiculesSortiesAvantDate(LocalDate date) throws  DaoException {
        if (Objects.isNull(date)) {
            throw new DaoException(ConstantesMetier.DATE_DE_SORTIE_NULL);
        }
        List<Vehicule> resultatVehicule = new ArrayList<>();
        for (Vehicule v : this.findAll()) {

            if (v.getDateDeSortie().isBefore(date)) {
                resultatVehicule.add(v);
            }
        }
        return Collections.unmodifiableList(resultatVehicule);
    }
}
