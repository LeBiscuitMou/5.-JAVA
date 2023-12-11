package net.ent.etrs.gestionJeuxVideo.models.entities;

import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.FabriquantException;
import net.ent.etrs.gestionJeuxVideo.models.references.ConstanteMetier;
import net.ent.etrs.gestionJeuxVideo.models.references.Pays;

import java.time.LocalDate;
import java.util.Objects;

public class Fabriquant extends AbstractEntity {
    private LocalDate dateCreation;
    private String nom;
    private Pays pays;

    public Fabriquant(LocalDate dateCreation, String nom, Pays pays) throws FabriquantException {
        this.setDateCreation(dateCreation);
        this.setNom(nom);
        this.setPays(pays);
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) throws FabriquantException {
        if (Objects.isNull(dateCreation)) {
            throw new FabriquantException(ConstanteMetier.CONSOLE_PAYS_DATE_NULL);
        }
        if (dateCreation.isBefore(LocalDate.now())) {
            throw new FabriquantException(ConstanteMetier.JEU_VIDEO_DATE_PASSE);
        }
        this.dateCreation = dateCreation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws FabriquantException {
        if (Objects.isNull(nom)) {
            throw new FabriquantException(ConstanteMetier.FABRIQUANT_NOM_ERROR);
        }
        if (nom.isBlank()) {
            throw new FabriquantException(ConstanteMetier.FABRIQUANT_NOM_ERROR);
        }
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) throws FabriquantException {
        if (Objects.isNull(pays)) {
            throw new FabriquantException(ConstanteMetier.CONSOLE_PAYS_DATE_NULL);
        }
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fabriquant that = (Fabriquant) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Fabriquant{" +
                "dateCreation=" + dateCreation +
                ", nom='" + nom + '\'' +
                ", pays=" + pays +
                '}';
    }
}