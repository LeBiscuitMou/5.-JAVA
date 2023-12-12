package net.ent.etrs.GestionnairePotion.model.references;

public enum Contenant {

    SMALL("petit flacon", 100),
    MEDIUM("flacon moyen", 200),
    LARGE("grand flacon", 350),
    XL("bouteille", 500);

    private final String libelle;
    private final int volume;

    Contenant(String libelle, int volume) {
        this.libelle = libelle;
        this.volume = volume;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getVolume() {
        return volume;
    }
}
