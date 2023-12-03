package net.ent.etrs.gestionVehicule.model.entities;

import net.ent.etrs.gestionVehicule.model.entities.exception.EntitiesFactoryExceptions;
import net.ent.etrs.gestionVehicule.model.entities.exception.VehiculeException;
import net.ent.etrs.gestionVehicule.model.references.ConstanteMetier;
import net.ent.etrs.gestionVehicule.model.references.Vignette;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }


    public static Vehicule fabriquerVehicule(String immat, LocalDate dateDeSortie, int nbLitre, float consommation, Vignette classementPollution) throws EntitiesFactoryExceptions {
        try {
            return new Vehicule(immat, dateDeSortie, nbLitre, consommation, classementPollution);
        } catch (VehiculeException e) {
            throw new EntitiesFactoryExceptions(ConstanteMetier.IMPOSSIBLE_CREER_VEHICULE, e);
        }
    }


}
