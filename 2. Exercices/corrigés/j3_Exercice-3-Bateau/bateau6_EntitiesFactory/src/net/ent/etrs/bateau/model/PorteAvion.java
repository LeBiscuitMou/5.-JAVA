package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

import java.util.Arrays;

public class PorteAvion extends Bateau{

    private Avion[] avionsEmbarques;
    public PorteAvion(String nom, int nbEquipage, float tonnage, String moyenpropulsion) throws BateauException {
        super(nom, nbEquipage, tonnage, moyenpropulsion);
        avionsEmbarques = new Avion[ConstantesMetier.PORTE_AVION_NB_AVIONS_EMBARQUE];
    }

    @Override
    public void setMoyenPropulsion(String moyenPropulsion) {

    }

    public Avion[] getAvionsEmbarques() {
        return Arrays.copyOf(avionsEmbarques,avionsEmbarques.length);
    }

    public void ajouterUnAvion(Avion avionAAjouter){

    }


    public void retirerUnAvion(Avion avionAAjouter){

    }
    
}
