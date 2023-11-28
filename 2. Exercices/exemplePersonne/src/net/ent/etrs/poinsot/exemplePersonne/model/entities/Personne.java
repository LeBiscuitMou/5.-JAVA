package net.ent.etrs.poinsot.exemplePersonne.model.entities;

import net.ent.etrs.poinsot.exemplePersonne.model.entities.exceptions.PersonneException;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.references.ConstanteMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Personne {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<Voiture> lesVoitures = new ArrayList<>();

    protected Personne(String nom, String prenom, LocalDate dateNaissance) throws PersonneException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws PersonneException {
        if (Objects.isNull(nom)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_NULL);
        }
        if (nom.isBlank()) {
            throw new PersonneException(ConstanteMetier.PERSONNE_NOM_VIDE);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    private void setPrenom(String prenom) throws PersonneException {
        if (Objects.isNull(prenom)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_NULL);
        }
        if (prenom.isBlank()) {
            throw new PersonneException(ConstanteMetier.PERSONNE_PRENOM_VIDE);
        }
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    private void setDateNaissance(LocalDate dateNaissance) throws PersonneException {
        if (Objects.isNull(dateNaissance)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_DATE_NAISSANCE_NULL);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new PersonneException(ConstanteMetier.PERSONNE_DATE_NAISSANCE_FUTUR);
        }
        this.dateNaissance = dateNaissance;
    }

    public List<Voiture> getLesVoitures() {
        return Collections.unmodifiableList(this.lesVoitures);
    }

    public void ajouterVoiture(Voiture laVoiture) throws PersonneException {
        if (Objects.isNull(laVoiture)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_VOITURE_NULL);
        }
        if (this.lesVoitures.contains(laVoiture)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_VOITURE_DEJA_PRESENT);
        }
        this.lesVoitures.add(laVoiture);
    }

    public void retirerVoiture(Voiture laVoiture) throws PersonneException {
        if (Objects.isNull(laVoiture)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_VOITURE_NULL);
        }
        if (!this.lesVoitures.contains(laVoiture)) {
            throw new PersonneException(ConstanteMetier.PERSONNE_VOITURE_PAS_PRESENT);
        }
        this.lesVoitures.remove(laVoiture);
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
                '}';
    }
}