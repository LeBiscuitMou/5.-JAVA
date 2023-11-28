package net.ent.etrs.poinsot.exemplePersonne.model.entities;

import net.ent.etrs.poinsot.exemplePersonne.model.entities.exceptions.VoitureException;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.references.ConstanteMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Voiture {
    private String immatriculation;
    private List<Personne> lesPersonnes = new ArrayList<>();

    public Voiture(String immatriculation) throws VoitureException {
        this.setImmatriculation(immatriculation);
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) throws VoitureException {
        if (Objects.isNull(immatriculation)) {
            throw new VoitureException(ConstanteMetier.VOITURE_IMMAT_NULL);
        }
        if (immatriculation.isBlank()) {
            throw new VoitureException(ConstanteMetier.VOITURE_IMMAT_VIDE);
        }
        this.immatriculation = immatriculation;
    }

    public List<Personne> getLesPersonnes() {
        return Collections.unmodifiableList(this.lesPersonnes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return Objects.equals(immatriculation, voiture.immatriculation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "immatriculation='" + immatriculation + '\'' +
                '}';
    }
}