package net.ent.etrs.model.entities;

import net.ent.etrs.model.entities.exceptions.EcranException;
import net.ent.etrs.model.entities.exceptions.MaterielInformatiqueException;
import net.ent.etrs.model.entities.references.Constantes;
import net.ent.etrs.model.entities.references.TailleEcran;

import java.time.LocalDate;
import java.util.Objects;


public class Ecran extends MaterielInformatique{


    private TailleEcran tailleEcran;


    private Ecran() {
    }

    protected Ecran(final String numSerie, final LocalDate dateGarantie) throws MaterielInformatiqueException, EcranException {
        super(numSerie, dateGarantie);
    }

    public TailleEcran getTailleEcran() {
        return tailleEcran;
    }

    public void setTailleEcran(final TailleEcran tailleEcran) throws EcranException {
        if (Objects.isNull(tailleEcran)){
            throw new EcranException(Constantes.MSG_TAILLE_ECRAN_ECXEPTION);
        }
        this.tailleEcran = tailleEcran;
    }

    @Override
    public String toString() {
        return "Ecran{" +
                "tailleEcran=" + tailleEcran +
                "} " + super.toString();
    }
}
