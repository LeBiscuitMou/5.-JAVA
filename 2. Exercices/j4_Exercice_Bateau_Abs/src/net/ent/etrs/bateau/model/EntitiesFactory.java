package net.ent.etrs.bateau.model;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    // Fabriquer des bâteaux
    // Frégates
    public static Bateau fabriquerFregate(String nom, int nbEquipage, float tonnage, String moyenPropulsion) {
        return new Fregate(nom, nbEquipage, tonnage, moyenPropulsion);
    }
    // PA
    public static Bateau fabriquerPorteAvion() {

    }


    // Avion

    // Helico
}