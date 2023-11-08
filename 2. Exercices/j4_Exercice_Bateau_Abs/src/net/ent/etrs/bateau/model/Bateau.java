package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.references.ConstanteMetier;
import net.ent.etrs.bateau.model.utils.VerificationUtils;

import java.util.Arrays;
import java.util.Objects;

public abstract class Bateau {
    private String nom;
    private int nbEquipage;
    private boolean estPret;
    private MoyenPropulsion moyenPropulsion;
    private Armement[] armements;

    public Bateau(String nom, int nbEquipage, boolean estPret, MoyenPropulsion moyenPropulsion, Armement[] armements) throws BateauException {
        this.setNom(nom);
        this.setNbEquipage(nbEquipage);
        this.setEstPret(estPret);
        this.setMoyenPropulsion(moyenPropulsion);
        this.armements = armements;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws BateauException {
        //Test de base
        //SI c'est null
        if(Objects.isNull(nom)){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_IS_NULL);
        }
        //Si c'est vide
        if(nom.isBlank()){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_IS_BLANK);
        }

        //Règles Métier
        //Limiter la taille du nom
        if (nom.length() > ConstanteMetier.BATEAU_NOM_LONGUEUR_MAX){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_TROP_GRAND);
        }

        //Pas de chiffre
        //TODO coder la methode.
        if(VerificationUtils.aUnChiffre(nom)){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_ERROR_CHIFFRE);
        }

        this.nom = nom;
    }

    public int getNbEquipage() {
        return nbEquipage;
    }

    public void setNbEquipage(int nbEquipage) {
        //Test de base
        if(nbEquipage < 0){

        }

        //Tester la max
        if(nbEquipage > 4000){

        }

        this.nbEquipage = nbEquipage;
    }

    public boolean isEstPret() {
        return estPret;
    }

    public void setEstPret(boolean estPret) {
        this.estPret = estPret;
    }

    public MoyenPropulsion getMoyenPropulsion() {
        return moyenPropulsion;
    }

    public void setMoyenPropulsion(MoyenPropulsion moyenPropulsion) {
        this.moyenPropulsion = moyenPropulsion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bateau bateau = (Bateau) o;
        return Objects.equals(nom, bateau.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Bateau{" +
                "nom='" + nom + '\'' +
                ", nbEquipage=" + nbEquipage +
                ", estPret=" + estPret +
                ", moyenPropulsion=" + moyenPropulsion +
                '}';
    }
}