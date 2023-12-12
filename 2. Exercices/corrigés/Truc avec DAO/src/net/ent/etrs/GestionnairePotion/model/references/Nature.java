package net.ent.etrs.GestionnairePotion.model.references;

public enum Nature {

    LIQUIDE("LIQUIDE"),
    PLANTE("PLANTE"),
    ANIMAL("ANIMAL"),
    GAZEUX("GAZEUX");

    private final String libelle;

    Nature(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
