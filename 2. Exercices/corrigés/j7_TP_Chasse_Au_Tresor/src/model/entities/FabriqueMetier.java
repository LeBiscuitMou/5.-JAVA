package model.entities;

import model.exceptions.*;
import model.references.C;

public final class FabriqueMetier {
    private FabriqueMetier(){}

    /**
     * Méthode chargée de fabriquer uneCarte.
     * @return Carte
     * @throws Exception
     */
    public static Carte fabriquerCarte() throws Exception {
        return new Carte();
    }

    /**
     * Méthode chargée de renvoyer unechasseAuTresor.
     * @return chasseAuTresor
     * @throws Exception
     */
    public static ChasseAuTresor fabriquerChasseauTresor() throws Exception {
        return new ChasseAuTresor();
    }

    /**
     * Méthode chargée de renvoyer une Cooroonnee.
     * @param ligne: int
     * @param colonne: int
     * @return Coordonnee
     * @throws CoordonneeException
     */
    public static Coordonnee fabriquerCoordonnee(int ligne, int colonne) throws CoordonneeException {
        return new Coordonnee(ligne,colonne);
    }

    /**
     * Méthode chargée de renvoyer un Joueur sous la forme d'un Deplacant.
     * @param ident: string, l'identité du joueur
     * @param noJoueur: int, le numero du joueur
     * @return Deplacant
     * @throws CoordonneeException
     * @throws JoueurException
     * @throws AbstractPersonneException
     */
    public static Deplacant fabriquerUnJoueur(String ident, int noJoueur) throws CoordonneeException, JoueurException, AbstractPersonneException {
        Coordonnee c =null;
        if(noJoueur==0){
            c= fabriquerCoordonnee(C.MIN,C.MIN);
        }else {
           c= fabriquerCoordonnee(C.DIM-1,C.DIM-1);
        }
        return new Joueur(ident,c);
    }
}
