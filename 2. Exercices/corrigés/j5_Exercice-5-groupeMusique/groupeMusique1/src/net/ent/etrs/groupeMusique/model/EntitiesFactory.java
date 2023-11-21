package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.*;
import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;
import net.ent.etrs.groupeMusique.model.references.Sexe;
import net.ent.etrs.groupeMusique.model.references.TypeConcert;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    //Fabriquer des personnes
    //Musicien
    public static Personne fabriquerMusicien(String nom, String prenom, Sexe sexe, String nomArtiste) throws FactoryException {
        try {
            return new Musicien(nom, prenom, sexe, nomArtiste);
        } catch (PersonneException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_MUSICIEN_ERROR,e);
        }
    }
    //Fan
    public static Personne fabriquerFan(String nom, String prenom, Sexe sexe,Musicien leMusicienFavoris) throws FactoryException {
        try {
            return new Fan(nom, prenom, sexe,leMusicienFavoris);
        } catch (PersonneException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_FAN_ERROR,e);
        }
    }

    // Fabriquer du materiels
    //Son Lumière
    public static Materiel fabriquerSonLumiere(String reference) throws FactoryException {
        try {
            return new SonLumiere(reference);
        } catch (MaterielException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_SON_LUMIERE_ERROR,e);
        }
    }
    //Instrument
    public static Materiel fabriquerInstrument(String reference) throws FactoryException {
        try {
            return new Instrument(reference);
        } catch (MaterielException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_INSTRUMENT_ERROR,e);
        }
    }

    //Lieu
    public static Lieu fabriquerLieu(String leNom,int nbPlace) throws FactoryException {
        try {
            return new Lieu(leNom,nbPlace);
        } catch (LieuException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_LIEU_ERROR,e);
        }
    }

    //Concert


}
