package net.ent.etrs.tresor.model.entities;

import net.ent.etrs.tresor.model.exceptions.AbstractPersonneException;
import net.ent.etrs.tresor.model.references.C;

import java.util.Arrays;

public class Carte {
    private char[][] grille = new char[C.NB_CARTE][C.NB_CARTE];

    public Carte() {
        initialiserCarte();
    }

    public char[][] getGrille() {
        return grille;
    }

    public void setGrille(char[][] grille) {
        this.grille = grille;
    }

    @Override
    public String toString() {
        return "Carte{}";
    }

    private void initialiserCarte() {
        this.setGrille(this.grille);
    }

    public boolean isTresorAt(Coordonnee coordonnee) {

    }

    public boolean isPiegeAt(Coordonnee coordonnee) {

    }

    public boolean isSableAt(Coordonnee coordonnee) {

    }
}
