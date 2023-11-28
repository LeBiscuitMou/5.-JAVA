package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.TuileException;
import net.ent.etrs.kingdomino.models.entities.references.ConstanteMetier;

import java.util.Objects;

public abstract class Tuile {

    private int nbCouronne;

    protected Tuile(int nbCouronne) throws TuileException {
        this.setNbCouronne(nbCouronne);
    }


    public int getNbCouronne() {
        return nbCouronne;
    }

    public abstract char getSymbol();

    private void setNbCouronne(int nbCouronne) throws TuileException {
        if(nbCouronne >= 0 && nbCouronne <= ConstanteMetier.NB_MAX_COURONNE) {
            this.nbCouronne = nbCouronne;
        }else {
            throw new TuileException(ConstanteMetier.TUILE_NB_COURONNE_ERROR);
        }

    }

}
