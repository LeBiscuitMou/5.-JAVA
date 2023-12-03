package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.kingdomino.models.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.models.entities.references.ConstanteMetier;
import net.ent.etrs.kingdomino.models.entities.references.Couleur;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Joueur {

    private static final int TAILLE_TERRAIN = 5;

    private String nom;

    private Couleur couleurJoueur;

    private int position;

    private Tuile[][] terrain = new Tuile[TAILLE_TERRAIN][TAILLE_TERRAIN];

    public Joueur(String nom, Couleur couleurJoueur) throws JoueurException {
this.setNom(nom);
this.setCouleurJoueur(couleurJoueur);
        try {
            terrain[2][2] = EntitiesFactory.fabriquerTuileChateau();
        } catch (EntitiesFactoryException e) {
            throw new JoueurException(ConstanteMetier.JOUEUR_IMPOSSIBLE_CHATEAU,e);
        }
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws JoueurException {
        if (Objects.isNull(nom)) {
            throw new JoueurException(ConstanteMetier.JOUEUR_NOM_NULL);
        }
        if (nom.isBlank()) {
            throw new JoueurException(ConstanteMetier.JOUEUR_NOM_VIDE);
        }
        this.nom = nom;
    }

    public Couleur getCouleurJoueur() {
        return couleurJoueur;
    }

    private void setCouleurJoueur(Couleur couleurJoueur) throws JoueurException {
        if (Objects.isNull(couleurJoueur)) {
            throw new JoueurException(ConstanteMetier.JOUEUR_COULEUR_NULL);
        }
        this.couleurJoueur = couleurJoueur;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) throws JoueurException {
        if (position < 1 || position > ConstanteMetier.NB_MAX_JOUEUR){
            throw new JoueurException(ConstanteMetier.JOUEUR_POSITION_INCORRECT);
        }
        this.position = position;
    }

    public Tuile[][] getTerrain() {
        return Arrays.copyOf(this.terrain, this.terrain.length);
    }

    public static int getTailleTerrain() {
        return TAILLE_TERRAIN;
    }

    public boolean ajouterTuileAuTerrain(Tuile tuile, int x, int y){
        if(verificationPlacementTuile(tuile,x,y)){
            terrain[x][y] = tuile;
            return true;
        }
        return false;

    }

    private boolean verificationPlacementTuile(Tuile tuile, int x, int y) {
        return tuileAdjacenteChateau(tuile,x,y) || tuileAdjacenteMemeType(tuile,x,y);
    }

    private boolean tuileAdjacenteMemeType(Tuile tuile, int x, int y) {
        //Si c'est une Tuile de même type
       return this.terrain[x+1][y].equals(tuile) ||
                this.terrain[x][y+1].equals(tuile) ||
                this.terrain[x-1][y].equals(tuile) ||
                this.terrain[x][y-1].equals(tuile);
    }

    private boolean tuileAdjacenteChateau(Tuile tuile, int x, int y) {
        //Si c'est le chateau
       return this.terrain[x+1][y] instanceof Chateau ||
        this.terrain[x][y+1] instanceof Chateau ||
        this.terrain[x-1][y] instanceof Chateau ||
        this.terrain[x][y-1] instanceof Chateau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(nom, joueur.nom) && couleurJoueur == joueur.couleurJoueur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, couleurJoueur);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", couleurJoueur=" + couleurJoueur +
                ", position=" + position +
                '}';
    }
}
