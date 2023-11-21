package net.ent.etrs.rafale.model.references;

public enum CodeOTAN {

    FOX1("Foxtrot 1"),
    FOX2("Foxtrot 2"),
    FOX3("Foxtrot 3");

    private final String libelle;

    CodeOTAN(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
