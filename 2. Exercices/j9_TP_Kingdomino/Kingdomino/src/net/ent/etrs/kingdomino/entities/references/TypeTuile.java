package net.ent.etrs.kingdomino.entities.references;

public enum TypeTuile {
    FORET('F'),
    PRAIRIE('P'),
    BLE('B'),
    EAU('E'),
    MARAIS('M'),
    MINE('m'),
    CHATEAU('C');

    private final char symbole;

    TypeTuile(char symbole) {
        this.symbole = symbole;
    }

    public char getSymbole() {
        return symbole;
    }
}