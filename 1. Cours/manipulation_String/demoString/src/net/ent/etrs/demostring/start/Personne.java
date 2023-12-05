package net.ent.etrs.demostring.start;

import net.ent.etrs.demostring.start.exceptions.PersonneException;
import net.ent.etrs.demostring.start.references.ConstanteMetier;

import java.time.LocalDate;
import java.util.Objects;

public class Personne implements Comparable<Personne> {

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    private float taille;

    public Personne(String nom, String prenom, LocalDate dateNaissance) throws PersonneException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws PersonneException {
        if (Objects.isNull(nom)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws PersonneException {
        if (Objects.isNull(prenom)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_IS_NULL);
        }
        if (prenom.isBlank()) {
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_IS_BLANK);
        }
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) throws PersonneException {
        if (Objects.isNull(dateNaissance)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_DATE_NAISSANCE_IS_NULL);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new PersonneException(ConstanteMetier.PERSONNE_DATE_NAISSANCE_FUTUR);
        }
        this.dateNaissance = dateNaissance;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) throws PersonneException {
        if (taille < 0) {
            throw new PersonneException(ConstanteMetier.PERSONNE_TAILLE_IS_NEGATIVE);
        }
        this.taille = taille;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(dateNaissance, personne.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, dateNaissance);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", taille=" + taille +
                '}';
    }

    @Override
    public int compareTo(Personne o) {
        //nom
        if(this.getDateNaissance().compareTo(o.getDateNaissance())== 0){
            //prenom
            if(this.getPrenom().compareTo(o.getPrenom())== 0){
                //date naissance
                return this.getNom().compareTo(o.getNom());
            }
            else {
                return this.getPrenom().compareTo(o.getPrenom());
            }
        }
        else {
            return this.getDateNaissance().compareTo(o.getDateNaissance());
        }
    }
}
