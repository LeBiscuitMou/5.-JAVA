package net.ent.etrs.emploi.model.entities;

import net.ent.etrs.emploi.model.entities.exceptions.UniteValeurException;
import net.ent.etrs.emploi.model.references.ConstantesMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UniteValeur {
    private String nom;
    private LocalDate dateDebut;
    private List<Matiere> lesMatieres = new ArrayList<>();

    public UniteValeur(String nom, LocalDate dateDebut) throws UniteValeurException {
        this.setNom(nom);
        this.setDateDebut(dateDebut);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws UniteValeurException {
        if (Objects.isNull(nom)) {
            throw new UniteValeurException(ConstantesMetier.UNITE_VALEUR_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new UniteValeurException(ConstantesMetier.UNITE_VALEUR_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) throws UniteValeurException {
        if (Objects.isNull(dateDebut)) {
            throw new UniteValeurException(ConstantesMetier.UNITE_VALEUR_DATE_DEBUT_IS_NULL);
        }
        if (dateDebut.isBefore(LocalDate.now())) {
            throw new UniteValeurException(ConstantesMetier.UNITE_VALEUR_DATE_DEBUT_IS_BEFORE_NOW);
        }
        this.dateDebut = dateDebut;
    }

    public List<Matiere> getLesMatieres() {
        return Collections.unmodifiableList(this.lesMatieres);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniteValeur that = (UniteValeur) o;
        return Objects.equals(nom, that.nom) && Objects.equals(dateDebut, that.dateDebut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, dateDebut);
    }

    @Override
    public String toString() {
        return "UniteValeur{" +
                "nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                '}';
    }

    public boolean estValide(List<Matiere> matieres) throws UniteValeurException {
        if (Objects.isNull(matieres)) {
            throw new UniteValeurException(ConstantesMetier.UNITE_VALEUR_LISTE_MATIERES_IS_NULL);
        }
        if (matieres.size() >= ConstantesMetier.NOMBRE_MATIERES_MINIMUM) {
            return true;
        }
        throw new UniteValeurException(ConstantesMetier.UNITE_VALEUR_EST_VALIDE_ERROR);
    }
}