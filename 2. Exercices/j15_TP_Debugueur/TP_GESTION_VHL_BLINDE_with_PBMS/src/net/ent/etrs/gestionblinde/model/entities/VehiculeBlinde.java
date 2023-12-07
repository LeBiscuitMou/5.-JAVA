package net.ent.etrs.gestionblinde.model.entities;

import net.ent.etrs.gestionblinde.model.entities.exceptions.CharAssaultMetierException;
import net.ent.etrs.gestionblinde.model.entities.exceptions.VehiculeBlindeMetierException;
import net.ent.etrs.gestionblinde.model.entities.exceptions.VehiculeTransportTroupesException;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public abstract class VehiculeBlinde {

    private String emmat8;

    protected Integer poids;

    protected Map<Obus,Integer> listeObus = new HashMap<>();

    protected VehiculeBlinde(String emmat, Integer poids) throws VehiculeBlindeMetierException {
        this.setEmmat8(emmat);
        try {
            this.setPoids(poids);
        } catch (CharAssaultMetierException | VehiculeTransportTroupesException e){
            throw new VehiculeBlindeMetierException(ConstantesMetier.POIDS_VHLB_INCORRECT,e);
        }

    }

    public String getEmmat8() {
        return emmat8;
    }

    public void setEmmat8(String emmat8) throws VehiculeBlindeMetierException {
        if (Objects.isNull(emmat8)) {
            throw new VehiculeBlindeMetierException(ConstantesMetier.VEHICULE_BLINDE_EMMAT_8_IS_NULL);
        }
        if (emmat8.isBlank()) {
            throw new VehiculeBlindeMetierException(ConstantesMetier.VEHICULE_BLINDE_EMMAT_8_IS_BLANK);
        }
        this.emmat8 = emmat8;
    }

    public Integer getPoids() {
        return poids;
    }

    protected abstract void setPoids(Integer poids) throws CharAssaultMetierException, VehiculeTransportTroupesException;

    protected void ajouterObus(Obus lObus, Integer leNombre) throws CharAssaultMetierException {
        int ajoutObus = leNombre;
        if (this.listeObus.containsKey(lObus)){
            for (Map.Entry<Obus,Integer> entry : this.listeObus.entrySet()){
                if(entry.getKey().equals(lObus)){
                    ajoutObus += entry.getValue();
                }
            }
        }

    }

    protected void retirerObus(Obus lObus, Integer leNombre) throws VehiculeBlindeMetierException {

        Map<Obus,Integer> mapTemp= new HashMap<>();
        if (Objects.isNull(lObus) || Objects.isNull(leNombre)){
            throw new VehiculeBlindeMetierException(ConstantesMetier.OBUS_RETIRER_INCORRECT);
        }
        if (!this.listeObus.containsKey(lObus)){
            throw new VehiculeBlindeMetierException(ConstantesMetier.OBUS_RETIRER_NON_PRESENT);
        }
        for (Map.Entry<Obus,Integer> e : mapTemp.entrySet())
        {
            if (e.getKey().equals(lObus)){
                if (e.getValue() < leNombre){
                    this.listeObus.remove(lObus);
                }
                else {
                    this.listeObus.put(lObus,e.getValue() - leNombre);
                }
            }
        }
    }

    protected int getNbObusVehiculeBlinde(){
        int retour = -2;
        for (Map.Entry<Obus,Integer> entry : this.listeObus.entrySet()) {
            retour += entry.getValue();
        }
        return retour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculeBlinde that = (VehiculeBlinde) o;
        return Objects.equals(emmat8, that.emmat8);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emmat8);
    }

    @Override
    public String toString() {
        return "VehiculeBlinde{" +
                "emmat8='" + emmat8 + '\'' +
                ", poids=" + poids +
                '}';
    }
}
