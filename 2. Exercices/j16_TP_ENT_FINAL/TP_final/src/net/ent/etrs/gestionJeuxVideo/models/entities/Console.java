package net.ent.etrs.gestionJeuxVideo.models.entities;

import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.ConsoleException;
import net.ent.etrs.gestionJeuxVideo.models.references.ConstanteMetier;
import net.ent.etrs.gestionJeuxVideo.models.references.Pays;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class Console extends AbstractEntity {
    private Fabriquant fabriquant;
    private Map<Pays, LocalDate> sorties;
    private String nom;

    protected Console(Fabriquant fabriquant, String nom) throws ConsoleException {
        this.setFabriquant(fabriquant);
        this.setNom(nom);
    }

    public Fabriquant getFabriquant() {
        return fabriquant;
    }

    private void setFabriquant(Fabriquant fabriquant) throws ConsoleException {
        if (Objects.isNull(fabriquant)) {
            throw new ConsoleException(ConstanteMetier.FABRIQUANT_NOM_ERROR);
        }
        this.fabriquant = fabriquant;
    }

    public Map<Pays, LocalDate> getSorties() {
        return sorties;
    }

    public void setSortiePays(Pays pays, LocalDate dateSortie) throws ConsoleException {
        if (Objects.isNull(pays) || Objects.isNull(dateSortie)) {
            throw new ConsoleException(ConstanteMetier.CONSOLE_SORTIES_IS_NULL);
        }

    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws ConsoleException {
        if (Objects.isNull(nom)) {
            throw new ConsoleException(ConstanteMetier.CONSOLE_NOM_ERROR);
        }
        if (nom.isBlank()) {
            throw new ConsoleException(ConstanteMetier.CONSOLE_NOM_ERROR);
        }
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return Objects.equals(fabriquant, console.fabriquant) && Objects.equals(nom, console.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fabriquant, nom);
    }

    @Override
    public String toString() {
        return "Console{" +
                "fabriquant=" + fabriquant +
                ", nom='" + nom + '\'' +
                '}';
    }
}