package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.LieuException;
import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;

import java.util.Objects;

public class Lieu {

    private String nom;
    private int nbPlace;

    protected Lieu(String nom,int nbPlace) throws LieuException {
        this.setNom(nom);
        this.setNbPlace(nbPlace);
    }

    protected int getNbPlace() {
        return nbPlace;
    }

    private void setNbPlace(int nbPlace) throws LieuException {
        if(nbPlace < 0){
            throw new LieuException(ConstantesMetier.LIEU_NB_PLACE_ERROR_NEGATIF);
        }
        this.nbPlace = nbPlace;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws LieuException {
        if(Objects.isNull(nom)){
            throw new LieuException(ConstantesMetier.LIEU_NOM_NULL);
        }
        if (nom.isBlank()){
            throw new LieuException(ConstantesMetier.LIEU_NOM_VIDE);
        }
        this.nom = nom;
    }
}
