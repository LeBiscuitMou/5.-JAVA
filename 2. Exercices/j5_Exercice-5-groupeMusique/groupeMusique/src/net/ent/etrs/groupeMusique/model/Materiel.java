package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.MaterielException;
import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;

import java.util.Objects;

public abstract class Materiel {
    private String reference;

    protected Materiel(String reference) throws MaterielException {
        this.setReference(reference);
    }

    protected String getReference() {
        return reference;
    }

    private void setReference(String reference) throws MaterielException {
        //Si c'est null
        if(Objects.isNull(reference)){
            throw new MaterielException(ConstantesMetier.REFERENCE_IS_NULL);
        }
        //Si c'est vide
        if(reference.isBlank()){
            throw new MaterielException(ConstantesMetier.REFERENCE_IS_BLANK);
        }
        //Règles Métier
        //Limiter la taille du nom
        if (reference.length() > ConstantesMetier.REFERENCE_LONGUEUR_MAX){
            throw new MaterielException(ConstantesMetier.REFERENCE_ERROR_LONGUEUR);
        }

        this.reference = reference;
    }
}
