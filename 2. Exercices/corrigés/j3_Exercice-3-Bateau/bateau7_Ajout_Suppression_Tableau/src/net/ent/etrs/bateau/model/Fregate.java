package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.FregateException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

public class Fregate extends Bateau{

    private Helico helicoEmbarque;


    protected Fregate(String nom, int nbEquipage, float tonnage, String moyenpropulsion) throws BateauException {
        super(nom, nbEquipage, tonnage, moyenpropulsion);
    }

    public Helico getHelicoEmbarque() {
        return helicoEmbarque;
    }

    public void setHelicoEmbarque(Helico helicoEmbarque) throws FregateException {
        if(null == helicoEmbarque){
            throw new FregateException(ConstantesMetier.FREGATE_HELICO_NULL);
        }

        this.helicoEmbarque = helicoEmbarque;
    }

    @Override
    public void setMoyenPropulsion(String moyenPropulsion) {

    }
}
