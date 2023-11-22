package net.ent.etrs.tresor.model.entities;

import net.ent.etrs.tresor.model.exceptions.AbstractPersonneException;
import net.ent.etrs.tresor.model.references.C;

import java.util.Objects;

public abstract class AbstractPersonne implements Deplacant {
    private String identite;
    private int ptVie;

    protected AbstractPersonne(String identite) throws AbstractPersonneException {
        this.setIdentite(identite);
        this.setPtVie(this.ptVie);
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) throws AbstractPersonneException {
        if (Objects.isNull(identite)) {
            throw new AbstractPersonneException(C.ABSTRACT_PERSONNE_IDENTITE_NULL);
        }
        if (identite.isBlank()) {
            throw new AbstractPersonneException(C.ABSTRACT_PERSONNE_IDENTITE_BLANK);
        }
        this.identite = identite;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) throws AbstractPersonneException {
        if (ptVie < 0) {
            throw new AbstractPersonneException(C.ABSTRACT_PERSONNE_PT_VIE_NEGATIF);
        }
        if (ptVie < C.PT_VIE_MINIMUM) {
            throw new AbstractPersonneException(C.ABSTRACT_PERSONNE_PT_VIE_MINIMUM);
        }
        this.ptVie = ptVie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPersonne that = (AbstractPersonne) o;
        return Objects.equals(identite, that.identite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identite);
    }

    @Override
    public String toString() {
        return "AbstractPersonne{" +
                "identite='" + identite + '\'' +
                ", ptVie=" + ptVie +
                '}';
    }

    public abstract void descendreUneLigne();
    public abstract void monterUneLigne();
    public abstract void seDeplacer(boolean deplacer);

    public void recevoirDegat() {

    }
}