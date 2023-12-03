package net.ent.etrs.gestionrafale.model.entities;

import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierException;

public final class EntitiesFactory {

    private EntitiesFactory() {
    }

    public static Rafale fabriquerRafale(String identificationRafale, int nombrePilote, int carburantInterne, boolean possedeMissileNucleaire) throws RafaleMetierException {

        return fabriquerRafaleAir(identificationRafale, nombrePilote, carburantInterne, possedeMissileNucleaire);
    }

    private static RafaleAir fabriquerRafaleAir(String identificationRafale, int nombrePilote, int carburantInterne, boolean possedeMissileNucleaire) throws RafaleMetierException {
        RafaleAir ra = new RafaleAir(identificationRafale, nombrePilote, carburantInterne);
        ra.setPossedeBombeNucleaire(possedeMissileNucleaire);
        return ra;
    }


}
