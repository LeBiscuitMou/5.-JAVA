package net.ent.etrs.potionmagique.models.entities.references;

public enum Contenant {

    FIOLE(150),
    TUBE(50),
    GOURDE(300),
    JARRE(1000);

    private int volume;

    Contenant(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

}
