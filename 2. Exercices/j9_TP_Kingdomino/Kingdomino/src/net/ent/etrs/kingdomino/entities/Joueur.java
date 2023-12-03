package net.ent.etrs.kingdomino.entities;

import net.ent.etrs.kingdomino.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.references.ConstanteMetier;

import java.util.Objects;

public class Joueur {
    private String nom;
    private String couleur;
    private Tuile tuile;

    public Joueur(String nom, String couleur, Tuile tuile) throws JoueurException {
        this.setNom(nom);
        this.setCouleur(couleur);
        this.setTuile(tuile);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws JoueurException {
        if (null == nom) {
            throw new JoueurException(ConstanteMetier.JOUEUR_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new JoueurException(ConstanteMetier.JOUEUR_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) throws JoueurException {
        if (null == couleur) {
            throw new JoueurException(ConstanteMetier.JOUEUR_COULEUR_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new JoueurException(ConstanteMetier.JOUEUR_COULEUR_IS_BLANK);
        }
        this.couleur = couleur;
    }

    public Tuile getTuile() {
        return tuile;
    }

    public void setTuile(Tuile tuile) throws JoueurException {
        if (null == tuile) {
            throw new JoueurException(ConstanteMetier.JOUEUR_TUILE_IS_NULL);
        }
        this.tuile = tuile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(nom, joueur.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", couleur='" + couleur + '\'' +
                ", tuile=" + tuile +
                '}';
    }
}
