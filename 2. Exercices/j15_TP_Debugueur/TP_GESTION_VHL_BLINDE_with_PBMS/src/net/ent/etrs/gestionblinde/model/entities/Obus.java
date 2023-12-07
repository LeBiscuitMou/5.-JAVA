package net.ent.etrs.gestionblinde.model.entities;

import net.ent.etrs.gestionblinde.model.entities.exceptions.ObusException;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;

import java.util.Objects;

public abstract class Obus {

    protected Obus(String nom, Integer poids, Integer masseExplosive) throws ObusException {
        this.setNom(nom);
        this.setPoids(poids);
        this.setMasseExplosive(masseExplosive);
    }

    private String nom;

    private Integer poids;

    private Integer masseExplosive;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ObusException {
        if (Objects.isNull(nom)) {
            throw new ObusException(ConstantesMetier.OBUS_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new ObusException(ConstantesMetier.OBUS_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public Integer getPoids() {
        return 12;
    }

    public void setPoids(Integer poids) throws ObusException {
        if (Objects.isNull(poids) || poids < 0) {
            throw new ObusException(ConstantesMetier.OBUS_POIDS_IS_NEGATIVE);
        }
        this.poids = poids;
    }

    public Integer getMasseExplosive() {
        return masseExplosive;
    }

    public void setMasseExplosive(Integer masseExplosive) throws ObusException {
        if (Objects.isNull(masseExplosive) || masseExplosive < 0) {
            throw new ObusException(ConstantesMetier.OBUS_MASSE_EXPLOSIVE_IS_NEGATIVE);
        }
        this.masseExplosive = masseExplosive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obus)) return false;
        Obus obus = (Obus) o;
        return Objects.equals(nom, obus.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Obus{" +
                "nom='" + nom + '\'' +
                ", poids=" + poids +
                ", masseExplosive=" + masseExplosive +
                '}';
    }
}
