package net.ent.etrs.musique.model;

import net.ent.etrs.musique.model.exceptions.PersonneException;
import net.ent.etrs.musique.model.references.ConstanteMetier;
import net.ent.etrs.musique.model.utils.VerificationUtils;

import java.util.Objects;

public abstract class Personne {
    private String nom;
    private String prenom;
    private Sexe sexe;

    public Personne(String nom, String prenom, Sexe sexe) throws PersonneException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setSexe(sexe);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws PersonneException {
        // Test de base
        // si c'est null
        if (Objects.isNull(nom)){
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_ERROR_NULL);
        }
        // si c'est vide
        if (nom.isBlank()){
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_ERROR_EMPTY);
        }

        // Règles métiers
        // limiter la taille
        if (nom.length() > ConstanteMetier.PERSONNE_NOM_LONGUEUR_MAX){
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_ERROR_SIZE);
        }
        // pas de chiffre
        if(VerificationUtils.verificationStringContain(nom)){
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_ERROR_NUMBER);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws PersonneException {
        // Test de base
        // si c'est null
        if (Objects.isNull(prenom)){
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_ERROR_NULL);
        }
        // si c'est vide
        if (prenom.isBlank()){
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_ERROR_EMPTY);
        }

        // Règles métiers
        // limiter la taille
        if (prenom.length() > ConstanteMetier.PERSONNE_PRENOM_LONGUEUR_MAX){
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_ERROR_SIZE);
        }
        // pas de chiffre
        if(VerificationUtils.verificationStringContain(prenom)){
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_ERROR_NUMBER);
        }
        this.prenom = prenom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) throws PersonneException {
        if (Objects.isNull(sexe)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_SEXE_ERROR_NULL);
        }
        this.sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && sexe == personne.sexe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, sexe);
    }
}