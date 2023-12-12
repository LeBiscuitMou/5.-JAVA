package net.ent.etrs.pjjeudesociete.models.entities;

import net.ent.etrs.pjjeudesociete.models.entities.exceptions.MaisonEditionException;
import net.ent.etrs.pjjeudesociete.models.references.ConstanteMetier;
import net.ent.etrs.pjjeudesociete.models.references.Pays;

import java.time.LocalDate;
import java.util.Objects;

public class MaisonEdition extends AbstractEntity {
    private String nom;
    private LocalDate dateFondation;
    private Pays pays;

    protected MaisonEdition(String nom, LocalDate dateFondation, Pays pays) throws MaisonEditionException {
        this.setNom(nom);
        this.setDateFondation(dateFondation);
        this.setPays(pays);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws MaisonEditionException {
        if (Objects.isNull(nom) || nom.isBlank()) {
            throw new MaisonEditionException(ConstanteMetier.ME_NOM_INCORRECT);
        }
        this.nom = nom;
    }

    public LocalDate getDateFondation() {
        return dateFondation;
    }

    public void setDateFondation(LocalDate dateFondation) throws MaisonEditionException {
        if (Objects.isNull(dateFondation)) {
            throw new MaisonEditionException(ConstanteMetier.ME_DATE_CREATION_NULL);
        }
        if (dateFondation.isAfter(LocalDate.now())) {
            throw new MaisonEditionException(ConstanteMetier.ME_DATE_CREATION_FUTUR);
        }
        this.dateFondation = dateFondation;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) throws MaisonEditionException {
        if (Objects.isNull(pays)) {
            throw new MaisonEditionException(ConstanteMetier.ME_PAYS_NULL);
        }
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaisonEdition that = (MaisonEdition) o;
        return Objects.equals(nom, that.nom) && Objects.equals(dateFondation, that.dateFondation) && pays == that.pays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nom, dateFondation, pays);
    }

    @Override
    public String toString() {
        return "MaisonEdition{" +
                "nom='" + nom + '\'' +
                ", dateFondation=" + dateFondation +
                ", pays=" + pays +
                '}';
    }
}