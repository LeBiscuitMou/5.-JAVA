package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.ArmementException;
import net.ent.etrs.bateau.model.references.ConstanteMetier;
import net.ent.etrs.bateau.model.utils.VerificationUtils;

import java.util.Objects;

public class Armement {
    private String nom;
    private float calibre;
    private int portee;

    public Armement(String nom, float calibre, int portee) {
        this.nom = nom;
        this.calibre = calibre;
        this.portee = portee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ArmementException {
        //Test de base
        //SI c'est null
        if(Objects.isNull(nom)){
            throw new ArmementException(ConstanteMetier.BATEAU_NOM_IS_NULL);
        }
        //Si c'est vide
        if(nom.isBlank()){
            throw new ArmementException(ConstanteMetier.BATEAU_NOM_IS_BLANK);
        }

        //Règles Métier
        //Limiter la taille du nom
        if (nom.length() > ConstanteMetier.BATEAU_NOM_LONGUEUR_MAX){
            throw new ArmementException(ConstanteMetier.BATEAU_NOM_TROP_GRAND);
        }

        //Pas de chiffre
        //TODO coder la methode.
        if(VerificationUtils.aUnChiffre(nom)){
            throw new ArmementException(ConstanteMetier.BATEAU_NOM_ERROR_CHIFFRE);
        }

        this.nom = nom;
    }

    public float getCalibre() {
        return calibre;
    }

    public void setCalibre(float calibre) {
        this.calibre = calibre;
    }

    public int getPortee() {
        return portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armement armement = (Armement) o;
        return Float.compare(calibre, armement.calibre) == 0 && Objects.equals(nom, armement.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, calibre);
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