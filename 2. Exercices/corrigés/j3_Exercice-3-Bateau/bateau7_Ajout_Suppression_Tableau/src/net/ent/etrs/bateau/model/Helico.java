package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.HelicoException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

public class Helico {

    private String identifiant;

    public Helico(String identifiant) throws HelicoException {
        this.setIdentifiant(identifiant);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) throws HelicoException {
        if (null == identifiant){
            throw new HelicoException(ConstantesMetier.HELICO_ID_NULL);
        }

        if (identifiant.isBlank()){
            throw new HelicoException(ConstantesMetier.HELICO_ID_EMPTY);
        }

        this.identifiant = identifiant;
    }
}
