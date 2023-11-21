package net.ent.etrs.rafale.model;

import net.ent.etrs.rafale.model.exceptions.FactoryException;
import net.ent.etrs.rafale.model.exceptions.RafaleException;
import net.ent.etrs.rafale.model.references.ConstantesMetier;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Rafale fabriquerRafale(String idRafale, int carburantInterne, int nombrePilote, boolean possedeBombeNucleaire) throws FactoryException {
        return fabriquerRafaleAir(idRafale, carburantInterne, nombrePilote, possedeBombeNucleaire);
    }

    private static RafaleAir fabriquerRafaleAir(String idRafale, int carburantInterne, int nombrePilote, boolean possedeBombeNucleaire) throws FactoryException {
        try {
            return new RafaleAir(idRafale, carburantInterne, nombrePilote, possedeBombeNucleaire);
        } catch (RafaleException e) {
            throw new FactoryException(ConstantesMetier.RAFALE_METIER_NOT_CREATE, e);
        }
    }
}