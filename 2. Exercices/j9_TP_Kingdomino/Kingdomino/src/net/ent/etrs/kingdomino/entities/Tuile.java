package net.ent.etrs.kingdomino.entities;

import net.ent.etrs.kingdomino.entities.exceptions.TuileException;
import net.ent.etrs.kingdomino.entities.references.TypeTuile;
import net.ent.etrs.kingdomino.references.ConstanteMetier;

import java.util.Objects;

public class Tuile {
    private TypeTuile typeTuile;
    private int nbCouronne;

    protected Tuile(TypeTuile typeTuile, int nbCouronne) throws TuileException {
        this.setTypeTuile(typeTuile);
        this.setNbCouronne(nbCouronne);
    }

    public TypeTuile getTypeTuile() {
        return typeTuile;
    }

    public void setTypeTuile(TypeTuile typeTuile) throws TuileException {
        if (Objects.isNull(typeTuile)) {
            throw new TuileException(ConstanteMetier.TUILE_TYPE_TUILE_IS_NULL);
        }
        this.typeTuile = typeTuile;
    }

    public int getNbCouronne() {
        return nbCouronne;
    }

    public void setNbCouronne(int nbCouronne) throws TuileException {
        if (nbCouronne < 0) {
            throw new TuileException(ConstanteMetier.TUILE_NB_COURONNE_NEGATIF);
        }
        if (nbCouronne > ConstanteMetier.NB_COURONNES_MAX) {
            throw new TuileException(ConstanteMetier.TUILE_NB_COURONNE_TROP_ELEVE);
        }
        this.nbCouronne = nbCouronne;
    }
}