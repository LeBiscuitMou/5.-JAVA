package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.TypeBateauException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

import java.util.Objects;

public class TypeBateau {
    private String nom;
    private int longueur;
    private float tonnageMax;

    public TypeBateau(String nom, int longueur, float tonnageMax) throws TypeBateauException {
        this.setNom(nom);
        this.setLongueur(longueur);
        this.setTonnageMax(tonnageMax);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws TypeBateauException {
        if (Objects.isNull(nom)){
            throw new TypeBateauException(ConstantesMetier.TYPEBATEAU_NOM_ERROR_NULL);
        }

        if (nom.isBlank()){
            throw new TypeBateauException(ConstantesMetier.TYPEBATEAU_NOM_ERROR_EMPTY);
        }

        if (nom.length() > ConstantesMetier.TYPEBATEAU_NOM_LONGUEUR_MAX){
            throw new TypeBateauException(ConstantesMetier.TYPEBATEAU_NOM_ERROR_SIZE);
        }
        this.nom = nom;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) throws TypeBateauException {
        if (longueur <= ConstantesMetier.TYPEBATEAU_LONGUEUR_MIN){
            throw new TypeBateauException(ConstantesMetier.TYPEBATEAU_LONGUEUR_ERROR);
        }
        if (longueur > ConstantesMetier.TYPEBATEAU_LONGUEUR_MAX){
            throw new TypeBateauException(ConstantesMetier.TYPEBATEAU_LONGUEUR_ERROR);
        }
        this.longueur = longueur;
    }

    public float getTonnageMax() {
        return tonnageMax;
    }

    public void setTonnageMax(float tonnageMax) throws TypeBateauException {
        if (tonnageMax <= ConstantesMetier.TYPEBATEAU_TONNAGE_MIN){
            throw new TypeBateauException(ConstantesMetier.TYPEBATEAU_TONNAGE_ERROR);
        }
        if (tonnageMax > ConstantesMetier.TYPEBATEAU_TONNAGE_MAX){
            throw new TypeBateauException(ConstantesMetier.TYPEBATEAU_TONNAGE_ERROR);
        }
        this.tonnageMax = tonnageMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeBateau that)) return false;
        return Objects.equals(getNom(), that.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom());
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
