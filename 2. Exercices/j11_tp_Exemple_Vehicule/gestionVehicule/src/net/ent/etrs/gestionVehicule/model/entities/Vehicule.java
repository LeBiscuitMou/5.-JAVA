package net.ent.etrs.gestionVehicule.model.entities;

import net.ent.etrs.gestionVehicule.model.entities.exception.VehiculeException;
import net.ent.etrs.gestionVehicule.model.references.ConstanteMetier;
import net.ent.etrs.gestionVehicule.model.references.Vignette;

import java.time.LocalDate;
import java.util.Objects;

public class Vehicule {
    private String immat;
    private LocalDate dateDeSortie;
    private int nbLitre;
     private float consommation;
     private Vignette classementPollution;

     public int autonomie(){
         return (int) ((nbLitre/consommation)*100);
     }

     //gett & setter


    public Vignette getClassementPollution() {
        return classementPollution;
    }

    public void setClassementPollution(Vignette classementPollution) throws VehiculeException {
         if (Objects.isNull(classementPollution)){
             throw new VehiculeException(ConstanteMetier.CLASSEMENT_POLLUTION_NULL);
         }

        this.classementPollution = classementPollution;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) throws VehiculeException {
         if (Objects.isNull(dateDeSortie)){
             throw new VehiculeException(ConstanteMetier.VEHICULE_DATE_SORTIE_IS_NULL);
         }
         if(dateDeSortie.isAfter(LocalDate.now())){
             throw new VehiculeException(ConstanteMetier.VEHICULE_DATE_SORTIE_FUTUR);
         }

         this.dateDeSortie = dateDeSortie;
     }

    public void setConsommation(float consommation) throws VehiculeException {
        if(consommation < 0){
            throw new VehiculeException(ConstanteMetier.CONSOMMATION_VEHICULE_FLOAT_NEGATIF);
        }
        this.consommation = consommation;
    }
    public void setNbLitre(int nbLitre) throws VehiculeException {
        if(consommation < 0){
            throw new VehiculeException(ConstanteMetier.VEHICULE_NBLITRE_NEGATIF);
        }
        this.nbLitre = nbLitre;
    }
    private void setImmat(String immat) throws VehiculeException {
         if(Objects.isNull(immat)){
             throw new VehiculeException(ConstanteMetier.IMMAT_VEHICULE_IS_NULL);
         }
        if(immat.isBlank()){
            throw new VehiculeException(ConstanteMetier.IMMAT_VEHICULE_IS_BLANK);
        }
        this.immat = immat;
    }

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public String getImmat() {
        return immat;
    }

    public int getNbLitre() {
        return nbLitre;
    }

    public float getConsommation() {
        return consommation;
    }
    // constructor
    protected Vehicule(String immat, LocalDate dateDeSortie, int nbLitre, float consommation, Vignette classementPollution) throws VehiculeException {
        this.setClassementPollution(classementPollution);
        this.setImmat(immat);
        this.setDateDeSortie(dateDeSortie);
        this.setNbLitre(nbLitre);
        this.setConsommation(consommation);
    }
    //equal hash code

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(immat, vehicule.immat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immat);
    }
    //to string

    @Override
    public String toString() {
        return "Vehicule{" +
                "immat='" + immat + '\'' +
                ", dateDeSortie=" + dateDeSortie +
                ", nbLitre=" + nbLitre +
                ", consommation=" + consommation +
                ", classementPollution=" + classementPollution +
                '}';
    }
}
