package net.ent.etrs.poinsot.projet.model.entities;

import net.ent.etrs.poinsot.projet.model.entities.exceptions.EcranException;
import net.ent.etrs.poinsot.projet.model.entities.exceptions.MaterielInformatiqueException;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;
import net.ent.etrs.poinsot.projet.model.references.TailleEcran;

import java.time.LocalDate;
import java.util.Objects;

public class Ecran extends MaterielInformatique {
    private TailleEcran tailleEcran;

    protected Ecran(String numSerie, LocalDate dateGarantie) throws MaterielInformatiqueException {
        super(numSerie, dateGarantie);
    }

    public TailleEcran getTailleEcran() {
        return tailleEcran;
    }

    public void setTailleEcran(TailleEcran tailleEcran) throws EcranException {
        if (Objects.isNull(tailleEcran)) {
            throw new EcranException(ConstanteMetier.ECRAN_TAILLE_ECRAN_IS_NULL);
        }
        this.tailleEcran = tailleEcran;
    }

    @Override
    public String toString() {
        return "Ecran{" +
                "tailleEcran=" + tailleEcran +
                '}';
    }
}