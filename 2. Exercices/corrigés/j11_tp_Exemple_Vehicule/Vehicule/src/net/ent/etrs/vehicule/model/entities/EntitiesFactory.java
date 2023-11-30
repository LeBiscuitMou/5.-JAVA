package net.ent.etrs.vehicule.model.entities;

import net.ent.etrs.vehicule.model.exceptions.FactoryException;
import net.ent.etrs.vehicule.model.exceptions.VehiculeException;
import net.ent.etrs.vehicule.model.references.ConstantesMetier;
import net.ent.etrs.vehicule.model.references.Vignette;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Vehicule creerVehicule(String immat, LocalDate dateDeSortie, int nbLitre, float consomation, Vignette vignette) throws FactoryException {
        try {
            return new Vehicule(immat, dateDeSortie, nbLitre, consomation, vignette);
        } catch (VehiculeException e) {
            throw new FactoryException(ConstantesMetier.FACTORY_CREER_VEHICULE_IMPOSSIBLE);
        }
    }


}
