package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.FactoryException;
import net.ent.etrs.bateau.model.exceptions.FregateException;
import net.ent.etrs.bateau.model.exceptions.HelicoException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    //Fabriquer des Bateaux
    //Fregate
    public static Bateau fabriquerFregate(String nom, int nbEquipage, float tonnage, MoyenPropulsion moyenpropulsion, Helico helicoptere) throws FactoryException {
        try {
            Fregate f = new Fregate(nom, nbEquipage, tonnage, moyenpropulsion);
            f.setHelicoEmbarque(helicoptere);

            return f;
        } catch (BateauException | FregateException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_FREGATE_ERROR,e);
        }
    }
    //PA
    public static  Bateau fabriquerPorteAvion(String nom, int nbEquipage, float tonnage, MoyenPropulsion moyenpropulsion) throws FactoryException {
        try {
            return new PorteAvion(nom, nbEquipage, tonnage, moyenpropulsion);
        } catch (BateauException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_PORTE_AVION_ERROR,e);
        }
    }

    public static Helico fabriquerHelico(String identifiantHelicoptere) throws FactoryException {
        try {
            return new Helico(identifiantHelicoptere);
        } catch (HelicoException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_HELICO_ERROR,e);
        }
    }


    /////////////
    //Avion

    //Helico


}
