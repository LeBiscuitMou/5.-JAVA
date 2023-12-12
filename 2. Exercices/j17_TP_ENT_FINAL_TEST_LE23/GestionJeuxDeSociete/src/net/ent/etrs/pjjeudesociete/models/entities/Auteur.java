package net.ent.etrs.pjjeudesociete.models.entities;

import net.ent.etrs.pjjeudesociete.models.entities.exceptions.AuteurException;
import net.ent.etrs.pjjeudesociete.models.references.ConstanteMetier;

import java.util.Objects;

public class Auteur extends AbstractEntity {
    private String nom;
    private String prenom;

    protected Auteur(String nom, String prenom) throws AuteurException {
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws AuteurException {
        if (Objects.isNull(nom) || nom.isBlank()) {
            throw new AuteurException(ConstanteMetier.ME_NOM_INCORRECT);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws AuteurException {
        if (Objects.isNull(prenom) || prenom.isBlank()) {
            throw new AuteurException(ConstanteMetier.AUTEUR_PRENOM_INCORRECT);
        }
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(nom, auteur.nom) && Objects.equals(prenom, auteur.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nom, prenom);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}