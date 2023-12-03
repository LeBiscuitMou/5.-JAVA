package model.references;

public enum TypeCase {
    TRESOR('T'),
    PIEGE('P'),
    SABLE('.');

    private char symbole;

    public char getSymbole() {
        return symbole;
    }

    private TypeCase(char c){
        symbole = c;
    }


}
