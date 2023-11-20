package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.PersonneException;
import net.ent.etrs.groupeMusique.model.references.Sexe;
import net.ent.etrs.groupeMusique.model.utils.VerificationUtils;
import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;

import java.util.Objects;

public abstract class Personne {
    private String nom;
    private String prenom;
    private Sexe sexe;

    protected Personne(String nom, String prenom, Sexe sexe) throws PersonneException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setSexe(sexe);
    }

    protected String getNom() {
        return nom;
    }

    protected String getPrenom() {
        return prenom;
    }

    protected Sexe getSexe() {
        return sexe;
    }

    protected void setNom(String nom) throws PersonneException {
        //Si c'est null
        if(Objects.isNull(nom)){
            throw new PersonneException(ConstantesMetier.NOM_IS_NULL);
        }
        //Si c'est vide
        if(nom.isBlank()){
            throw new PersonneException(ConstantesMetier.NOM_IS_BLANK);
        }
        //Règles Métier
        //Limiter la taille du nom
        if (nom.length() > ConstantesMetier.NOM_LONGUEUR_MAX){
            throw new PersonneException(ConstantesMetier.NOM_ERROR_LONGUEUR);
        }
        //Pas de chiffre
        if(VerificationUtils.aUnChiffre(nom)){
            throw new PersonneException(ConstantesMetier.NOM_ERROR_CHIFFRE);
        }

        this.nom = nom;
    }

    private void setPrenom(String prenom) throws PersonneException {
    // TODO Corriger        this.setNom(prenom);
        //Si c'est null
        if(Objects.isNull(prenom)){
            throw new PersonneException(ConstantesMetier.PRENOM_IS_NULL);
        }
        //Si c'est vide
        if(prenom.isBlank()){
            throw new PersonneException(ConstantesMetier.PRENOM_IS_BLANK);
        }
        //Règles Métier
        //Limiter la taille du nom
        if (prenom.length() > ConstantesMetier.PRENOM_LONGUEUR_MAX){
            throw new PersonneException(ConstantesMetier.PRENOM_ERROR_LONGUEUR);
        }
        //Pas de chiffre
        if(VerificationUtils.aUnChiffre(prenom)){
            throw new PersonneException(ConstantesMetier.PRENOM_ERROR_CHIFFRE);
        }

        this.prenom = prenom;
    }

    protected void setSexe(Sexe sexe) throws PersonneException {
        if(Objects.isNull(sexe)){
            throw new PersonneException(ConstantesMetier.SEXE_IS_NULL);
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

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe=" + sexe +
                '}';
    }
}
