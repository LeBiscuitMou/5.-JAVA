package net.ent.etrs.gestionrafale.model.entities.references;

public enum Bombe {
    GBU12("GBU-12 Paveway II", 273),
    GBU24("GBU-24 Paveway III", 1162),
    GBU49("GBU-49 Paveway II", 225),
    GBU22("GBU-22 Paveway III", 326),
    MK82("Bombe Mark 82", 227),
    SBU54("Smart Bomb Unit - 54", 340),
    SBU64("Smart Bomb Unit - 64", 350),
    AASM_1000("Armement Air-Sol Modulaire 1000", 1000),
    AASM_250("Armement Air-Sol Modulaire 250", 250),
    SCALP("SCALP-EG", 1300);

    /**
     * Nom de la bombe
     */
    private final String libelle;
    /**
     * Poids de la bombe en kg
     */
    private final int poids;

    Bombe(String libelle, int poids) {
        this.libelle = libelle;
        this.poids = poids;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getPoids() {
        return poids;
    }
}
