package net.ent.etrs.gestionblinde.model.entities;

import net.ent.etrs.gestionblinde.model.entities.exceptions.VehiculeBlindeMetierException;

import java.util.UUID;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static VehiculeBlinde fabriquerCharAssaut(String emat8, Integer poids){
        try {
            return new CharAssault(emat8,poids);
        } catch (VehiculeBlindeMetierException e) {
            throw new RuntimeException(e);
        }
    }

    public static VehiculeBlinde fabriquerVhlTransportTroupes(String emat8, Integer poids){
        try {
            return new VehiculeTransportTroupes(emat8,poids);
        } catch (VehiculeBlindeMetierException e) {
            throw new RuntimeException(e);
        }
    }

    public static Obus fabriquerObus25(String nom, Integer poids, Integer masseExplosive) {
        return new Obus25(nom, poids, masseExplosive);
    }

    public static Obus fabriquerObus120(String nom, Integer poids, Integer masseExplosive) {
        return new Obus120(nom, poids, masseExplosive);
    }
}
