package net.ent.etrs.vehicule.model.entities;

import net.ent.etrs.vehicule.model.exceptions.VehiculeException;
import net.ent.etrs.vehicule.model.references.ConstantesMetier;
import net.ent.etrs.vehicule.model.references.Vignette;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Vehicule extends AbstractEntity{
    private String immat;
    private LocalDate dateDeSortie;
    private int nbLitre;
    private float consomation;

    private Vignette classementPollution;

    public float autonomie(){
        float autonomie = (100*this.nbLitre)/this.consomation;
        return autonomie;
    }

    protected Vehicule(String immat, LocalDate dateDeSortie, int nbLitre, float consomation, Vignette classementPollution) throws VehiculeException {
        this.setImmat(immat);
        this.setDateDeSortie(dateDeSortie);
        this.setNbLitre(nbLitre);
        this.setConsomation(consomation);
        this.setClassementPollution(classementPollution);
    }

    protected Vehicule(String immat, int nbLitre, Vignette classementPollution) throws VehiculeException {
        this.setImmat(immat);
        this.setNbLitre(nbLitre);
        this.setClassementPollution(classementPollution);
    }

    public String getImmat() {
        return immat;
    }

    private void setImmat(String immat) throws VehiculeException {
        if(Objects.isNull(immat)) {
            throw new VehiculeException(ConstantesMetier.IMMAT_NULL);
        }
        if (immat.isBlank()){
            throw new VehiculeException(ConstantesMetier.IMMAT_BLANK);
        }
        this.immat = immat;
    }

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) throws VehiculeException {
         if(Objects.isNull(dateDeSortie)) {
                     throw new VehiculeException(ConstantesMetier.DATE_DE_SORTIE_NULL);
                 }
         if (dateDeSortie.isAfter(LocalDate.now())){
             throw new VehiculeException(ConstantesMetier.DATE_SORTIE_NON_VALIDE);
         }
        this.dateDeSortie = dateDeSortie;
    }

    public int getNbLitre() {
        return nbLitre;
    }

    private void setNbLitre(int nbLitre) {
        this.nbLitre = nbLitre;
    }

    public float getConsomation() {
        return consomation;
    }

    public void setConsomation(float consomation) {
        this.consomation = consomation;
    }

    public Vignette getClassementPollution() {
        return classementPollution;
    }

    public void setClassementPollution(Vignette classementPollution) throws VehiculeException {
         if(Objects.isNull(classementPollution)) {
                     throw new VehiculeException(ConstantesMetier.VIGNETTE_NULL);
                 }
        this.classementPollution = classementPollution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(immat, vehicule.immat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), immat);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicule{");
        sb.append("immat='").append(immat).append('\'');
        sb.append(", dateDeSortie=").append(dateDeSortie);
        sb.append(", nbLitre=").append(nbLitre);
        sb.append(", consomation=").append(consomation);
        sb.append(", vignette=").append(classementPollution);
        sb.append('}');
        return sb.toString();
    }


    public String toFormattedString() {

        if (Objects.isNull(this.dateDeSortie)) {
            dateDeSortie = LocalDate.of(1111, 11, 11);
        }
        // Définir le pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Formater la LocalDate en String
        String dateFormatee = dateDeSortie.format(formatter);

        String strSortie = String.format(
                        "|----------------|-----------------|-----------------|-----------------|----------------------|%n" +
                        "| Immatriculation| Date de sortie  | Nb de litres    | Consommation    | Classement Pollution |%n" +
                        "|----------------|-----------------|-----------------|-----------------|----------------------|%n" +
                        "| %-14s | %-15s | %-15d | %-15.2f | %-20s |%n"  +
                        "|----------------|-----------------|-----------------|-----------------|----------------------|%n" ,
                immat, dateFormatee, nbLitre, consomation, classementPollution.toString());

        return strSortie;
    }
}
