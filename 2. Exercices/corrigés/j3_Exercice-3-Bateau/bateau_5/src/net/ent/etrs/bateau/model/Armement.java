package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.ArmementException;
import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.TypeBateauException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

import java.util.Objects;

public class Armement {
    private String nom;
    private float calibre;
    private int portee;

    public Armement(String nom, float calibre, int portee) throws ArmementException {
        this.setNom(nom);
        this.setCalibre(calibre);
        this.setPortee(portee);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ArmementException {
        if (Objects.isNull(nom)){
            throw new ArmementException(ConstantesMetier.ARMEMENT_NOM_ERROR_NULL);
        }

        if (nom.isBlank()){
            throw new ArmementException(ConstantesMetier.ARMEMENT_NOM_ERROR_EMPTY);
        }

        if (nom.length() > ConstantesMetier.ARMEMENT_NOM_LONGUEUR_MAX){
            throw new ArmementException(ConstantesMetier.ARMEMENT_NOM_ERROR_SIZE);
        }
        this.nom = nom;
    }

    public float getCalibre() {
        return calibre;
    }

    public void setCalibre(float calibre) throws ArmementException {
        if (calibre < ConstantesMetier.ARMEMENT_CALIBRE_MIN){
            throw new ArmementException(ConstantesMetier.ARMEMENT_CALIBRE_ERROR + " " + calibre);
        }

        if (calibre > ConstantesMetier.ARMEMENT_CALIBRE_MAX){
            throw new ArmementException(ConstantesMetier.ARMEMENT_CALIBRE_ERROR + " " + calibre);
        }
        this.calibre = calibre;
    }

    public int getPortee() {
        return portee;
    }

    public void setPortee(int portee) throws ArmementException {
        if (portee < ConstantesMetier.ARMEMENT_PORTEE_MIN){
            throw new ArmementException(ConstantesMetier.ARMEMENT_PORTEE_ERROR + " " + portee);
        }

        if (portee > ConstantesMetier.ARMEMENT_PORTEE_MAX){
            throw new ArmementException(ConstantesMetier.ARMEMENT_PORTEE_ERROR + " " + portee);
        }
        this.portee = portee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armement armement)) return false;
        return Float.compare(getCalibre(), armement.getCalibre()) == 0 && Objects.equals(getNom(), armement.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getCalibre());
    }

    @Override
    public String toString() {
        return "Armement{" +
                "nom='" + nom + '\'' +
                ", calibre=" + calibre +
                ", portee=" + portee +
                '}';
    }
}
