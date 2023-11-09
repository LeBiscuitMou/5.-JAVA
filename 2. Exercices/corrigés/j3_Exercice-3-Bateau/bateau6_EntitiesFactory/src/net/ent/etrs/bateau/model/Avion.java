package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.AvionException;
import net.ent.etrs.bateau.model.exceptions.HelicoException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

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
}
