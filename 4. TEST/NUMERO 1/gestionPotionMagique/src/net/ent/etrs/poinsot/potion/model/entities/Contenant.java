package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.ContenantException;
import net.ent.etrs.poinsot.potion.model.references.ConstanteMetier;

import java.util.Objects;

public class Contenant {
    private String nom;
    private int volume;

    public Contenant(String nom, int volume) throws ContenantException {
        this.setNom(nom);
        this.setVolume(volume);
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws ContenantException {
        if (Objects.isNull(nom)) {
            throw new ContenantException(ConstanteMetier.CONTENANT_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new ContenantException(ConstanteMetier.CONTENANT_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) throws ContenantException {
        if (volume <= 0) {
            throw new ContenantException(ConstanteMetier.CONTENANT_VOLUME_IS_NEGATIVE);
        }
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contenant contenant = (Contenant) o;
        return Objects.equals(nom, contenant.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Contenant{" +
                "nom='" + nom + '\'' +
                ", volume=" + volume +
                '}';
    }
}