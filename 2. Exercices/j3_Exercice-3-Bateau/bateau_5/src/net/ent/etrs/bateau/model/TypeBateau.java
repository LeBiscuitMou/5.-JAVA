package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.TypeBateauException;
import net.ent.etrs.bateau.model.references.ConstanteMetier;
import net.ent.etrs.bateau.model.utils.VerificationUtils;

import java.util.Objects;

public class TypeBateau {
    private String nom;
    private int longueur;
    private float tonnageMax;

    public TypeBateau( String leNomTypeBateau, int laLongueur, float leTonnageMax) throws TypeBateauException {
        this.setNom(leNomTypeBateau);
        this.setLongueur(laLongueur);
        this.setTonnageMax(leTonnageMax);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws TypeBateauException {
        //Test de base
        //SI c'est null
        if(Objects.isNull(nom)){
            throw new TypeBateauException(ConstanteMetier.BATEAU_NOM_IS_NULL);
        }
        //Si c'est vide
        if(nom.isBlank()){
            throw new TypeBateauException(ConstanteMetier.BATEAU_NOM_IS_BLANK);
        }

        //Règles Métier
        //Limiter la taille du nom
        if (nom.length() > ConstanteMetier.BATEAU_NOM_LONGUEUR_MAX){
            throw new TypeBateauException(ConstanteMetier.BATEAU_NOM_TROP_GRAND);
        }

        //Pas de chiffre
        //TODO coder la methode.
        if(VerificationUtils.aUnChiffre(nom)){
            throw new TypeBateauException(ConstanteMetier.BATEAU_NOM_ERROR_CHIFFRE);
        }
        this.nom = nom;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public float getTonnageMax() {
        return tonnageMax;
    }

    public void setTonnageMax(float tonnageMax) {
        this.tonnageMax = tonnageMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeBateau that = (TypeBateau) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "TypeBateau{" +
                "nom='" + nom + '\'' +
                ", longueur=" + longueur +
                ", tonnageMax=" + tonnageMax +
                '}';
    }
}
