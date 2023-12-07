package net.ent.etrs.gestionblinde.model.entities;

import net.ent.etrs.gestionblinde.model.entities.exceptions.CharAssaultMetierException;
import net.ent.etrs.gestionblinde.model.entities.exceptions.VehiculeBlindeMetierException;
import net.ent.etrs.gestionblinde.model.entities.exceptions.VehiculeTransportTroupesException;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;

import java.util.Objects;
import java.util.UUID;

public class VehiculeTransportTroupes extends VehiculeBlinde{

    protected VehiculeTransportTroupes(String emmat, Integer poids) throws VehiculeBlindeMetierException {
        super(emmat, poids);
    }

    private Integer nbPersonnelEmbarque;

    @Override
    protected void setPoids(Integer poids) throws CharAssaultMetierException, VehiculeTransportTroupesException {
        if (Objects.isNull(poids) || poids > ConstantesMetier.POIDS_MAX_VTT) {
            throw new VehiculeTransportTroupesException(ConstantesMetier.POIDS_VTT_INCORRECT);
        }

    }

    public Integer getNbPersonnelEmbarque() {
        return nbPersonnelEmbarque;
    }

    public void setNbPersonnelEmbarque(Integer nbPersonnelEmbarque) throws VehiculeTransportTroupesException {
        if (Objects.isNull(nbPersonnelEmbarque) || nbPersonnelEmbarque > ConstantesMetier.NB_PERS_EMB_MAX){
            throw new VehiculeTransportTroupesException(ConstantesMetier.NB_PERS_EMB_INCORRECT);
        }
        this.nbPersonnelEmbarque = nbPersonnelEmbarque;
    }

    @Override
    public String toString() {
        return "VehiculeTransportTroupes{" +
                "nbPersonnelEmbarque=" + nbPersonnelEmbarque +
                '}';
    }
}
