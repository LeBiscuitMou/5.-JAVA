package net.ent.etrs.poinsot.projet.model.entities;

import net.ent.etrs.poinsot.projet.model.entities.exceptions.VehiculeException;
import net.ent.etrs.poinsot.projet.model.entities.references.Vignette;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;

import java.time.LocalDate;
import java.util.Objects;

public class Vehicule {
    private String immat;
    private LocalDate dateSortie;
    private int nbLitre;
    private float consommation;
    private Vignette vignette;

    public Vehicule(String immat, LocalDate dateSortie, int nbLitre, float consommation, Vignette vignette) throws VehiculeException {
        this.setImmat(immat);
        this.setDateSortie(dateSortie);
        this.setNbLitre(nbLitre);
        this.setConsommation(consommation);
        this.setVignette(vignette);
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) throws VehiculeException {
        if (Objects.isNull(immat)) {
            throw new VehiculeException(ConstanteMetier.VEHICULE_IMMAT_IS_NULL);
        }
        if (immat.isBlank()) {
            throw new VehiculeException(ConstanteMetier.VEHICULE_IMMAT_IS_BLANK);
        }
        this.immat = immat;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) throws VehiculeException {
        if (Objects.isNull(dateSortie)) {
            throw new VehiculeException(ConstanteMetier.VEHICULE_DATE_SORTIE_IS_NULL);
        }
        if (dateSortie.isAfter(LocalDate.now())) {
            throw new VehiculeException(ConstanteMetier.VEHICULE_DATE_SORTIE_FUTUR);
        }
        this.dateSortie = dateSortie;
    }

    public int getNbLitre() {
        return nbLitre;
    }

    public void setNbLitre(int nbLitre) throws VehiculeException {
        if (nbLitre < 0) {
            throw new VehiculeException(ConstanteMetier.VEHICULE_NB_LITRE_IS_NEGATIVE);
        }
        this.nbLitre = nbLitre;
    }

    public float getConsommation() {
        return consommation;
    }

    public void setConsommation(float consommation) throws VehiculeException {
        if (consommation < 0) {
            throw new VehiculeException(ConstanteMetier.VEHICULE_CONSOMMATION_IS_NEGATIVE);
        }
        this.consommation = consommation;
    }

    public Vignette getVignette() {
        return vignette;
    }

    public void setVignette(Vignette vignette) throws VehiculeException {
        if (Objects.isNull(vignette)) {
            throw new VehiculeException(ConstanteMetier.VEHICULE_VIGNETTE_IS_NULL);
        }
        this.vignette = vignette;
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
        return Objects.hash(immat);
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "immat='" + immat + '\'' +
                ", dateSortie=" + dateSortie +
                ", nbLitre=" + nbLitre +
                ", consommation=" + consommation +
                ", vignette=" + vignette +
                '}';
    }

    public int autonomie() {
        return (int) ((nbLitre / consommation) * 100);
    }
}