package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.AvionException;
import net.ent.etrs.bateau.model.exceptions.HelicoException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

import java.util.Objects;

public class Avion {

    private String identifiant;

    public Avion(String identifiant) throws AvionException {
        this.setIdentifiant(identifiant);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) throws AvionException {
        if (null == identifiant){
            throw new AvionException(ConstantesMetier.AVION_ID_NULL);
        }

        if (identifiant.isBlank()){
            throw new AvionException(ConstantesMetier.AVION_ID_EMPTY);
        }
        this.identifiant = identifiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return Objects.equals(identifiant, avion.identifiant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant);
    }
}
