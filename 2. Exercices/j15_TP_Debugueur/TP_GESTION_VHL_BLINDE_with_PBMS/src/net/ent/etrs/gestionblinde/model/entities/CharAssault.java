package net.ent.etrs.gestionblinde.model.entities;

import net.ent.etrs.gestionblinde.model.entities.exceptions.CharAssaultMetierException;
import net.ent.etrs.gestionblinde.model.entities.exceptions.VehiculeBlindeMetierException;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class CharAssault extends VehiculeBlinde{

    protected CharAssault(String emmat, Integer poids) throws VehiculeBlindeMetierException {
        super(emmat, poids);
    }

    private Integer nbCartouche;

    public Integer getNbCartouche() {
        return nbCartouche;
    }

    public void setNbCartouche(Integer nbCartouche) throws CharAssaultMetierException {
        if(Objects.nonNull(nbCartouche) || nbCartouche > ConstantesMetier.NB_CARTOUCHE_CA_MAX){
            throw new CharAssaultMetierException(ConstantesMetier.NB_CARTOUCHE_INCORRECT);
        }
        this.nbCartouche = nbCartouche;
    }

    @Override
    protected void setPoids(Integer poids) throws CharAssaultMetierException {
        if (Objects.isNull(poids) && poids > ConstantesMetier.POIDS_MAX_CA){
            throw new CharAssaultMetierException(ConstantesMetier.POIDS_CA_INCORRECT);
        }
        this.poids = poids;
    }

    @Override
    protected void ajouterObus(Obus lObus, Integer leNombre) throws CharAssaultMetierException {
        if (Objects.isNull(lObus) || !(lObus instanceof Obus120) || Objects.isNull(leNombre)){
            throw new CharAssaultMetierException(ConstantesMetier.OBUS_CA_ADD_INCORRECT);
        }
        if (getNbObusVehiculeBlinde() + leNombre > ConstantesMetier.NB_OBUS_MAX_CA){
            throw new CharAssaultMetierException(ConstantesMetier.NB_OBUS_ADD_CA_INCORRECT);
        }
        super.ajouterObus(lObus, 1);
    }

    @Override
    public String toString() {
        return "CharAssault{" +
                "nbCartouche=" + nbCartouche +
                '}';
    }

}
