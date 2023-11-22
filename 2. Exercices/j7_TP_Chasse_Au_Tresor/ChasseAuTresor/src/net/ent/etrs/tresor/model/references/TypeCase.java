package net.ent.etrs.tresor.model.references;

public enum TypeCase {
    TRESOR('T'),
    PIEGE('P'),
    SABLE('.');

    private final char caractere;
    TypeCase(char caractere) {
        this.caractere = caractere;
    }

    public char getCaractere() {
        return caractere;
    }
}