package net.ent.etrs.gestionblinde.model.facades;

import net.ent.etrs.gestionblinde.model.daos.DaoFactory;
import net.ent.etrs.gestionblinde.model.daos.DaoMetierVehiculeBlinde;
import net.ent.etrs.gestionblinde.model.daos.exceptions.DaoMetierVehiculeBlindeException;
import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;
import net.ent.etrs.gestionblinde.model.facades.exceptions.FacadeException;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FacadeMetierVehiculeBlindeImpl implements FacadeMetierVehiculeBlinde {
    DaoMetierVehiculeBlinde dao = DaoFactory.fabriquerDaoMetierVehiculeBlindeImpl();
    @Override
    public VehiculeBlinde ajouterVehiculeBlinde(VehiculeBlinde vhl) throws FacadeException {
        if (Objects.isNull(vhl)) {
            throw new FacadeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_CREATE);
        }
        try {
            return dao.create(vhl);
        } catch (DaoMetierVehiculeBlindeException e) {
            throw new FacadeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_CREATE, e);
        }
    }

    @Override
    public VehiculeBlinde majVehiculeBlinde(VehiculeBlinde vhl) throws FacadeException {
        if (Objects.isNull(vhl)) {
            throw new FacadeException(ConstantesMetier.DAO_OBUS_IMPOSSIBLE_UPDATE);
        }
        try {
            return dao.update(vhl);
        } catch (DaoMetierVehiculeBlindeException e) {
            throw new FacadeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_UPDATE, e);
        }
    }

    @Override
    public List<VehiculeBlinde> selectionnerTousVehiculeBlinde() {
        return Collections.unmodifiableList(dao.readAll());
    }

    @Override
    public void supprimerVehiculeBlinde(String emmat8) throws FacadeException {
        if (Objects.isNull(emmat8)) {
            throw new FacadeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_DELETE);
        }
        try {
            dao.delete(emmat8);
        } catch (DaoMetierVehiculeBlindeException e) {
            throw new FacadeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_DELETE, e);
        }
    }
}
