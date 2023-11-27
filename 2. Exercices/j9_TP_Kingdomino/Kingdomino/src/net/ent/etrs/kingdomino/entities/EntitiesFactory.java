package net.ent.etrs.kingdomino.entities;

public final class EntitiesFactory {
    private EntitiesFactory() {}

    /**
     * Méthode chargée de fabriquer un terrain
     * @return Terrain
     */
    public static Terrain fabriquerTerrain() {
        return new Terrain();
    }

    public static Joueur fabriquerJoueur() {
        return null;
    }
}
