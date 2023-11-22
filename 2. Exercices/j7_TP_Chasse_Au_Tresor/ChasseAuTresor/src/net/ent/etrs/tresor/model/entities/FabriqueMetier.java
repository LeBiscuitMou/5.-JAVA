package net.ent.etrs.tresor.model.entities;

import net.ent.etrs.tresor.model.exceptions.AbstractPersonneException;

public class FabriqueMetier {
    private FabriqueMetier() {
    }

    public static Carte fabriquerCarte() {

    }

    public static Deplacant fabriquerJoueur(String identite, int ptVie, Coordonnee coordonnee) throws AbstractPersonneException {
        Deplacant joueur = new Joueur(identite, ptVie, 0);
    }

    public static ChasseAuTresor fabriquerChasseAuTresor() {

    }

    public static Coordonnee fabriquerCoordonnees(int y, int x) {

    }
}