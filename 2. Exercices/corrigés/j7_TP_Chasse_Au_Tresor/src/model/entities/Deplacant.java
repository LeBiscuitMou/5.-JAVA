package model.entities;

import model.exceptions.AbstractPersonneException;
import model.exceptions.CoordonneeException;
import model.exceptions.JoueurException;

public interface Deplacant {
    /**
     * Méthode gerant la descente d'une ligne: y+1.
     */
    void descendreUneLigne() throws CoordonneeException;

    /**
     * Méthode gérant la montéee d'une ligne: y-1.
     */
    void monterUneLigne() throws CoordonneeException;

    /**
     * Méthode charge de déplacer un joueur.
     * @param isPiege:boolean, déplacement sur une piège?
     */
    void seDeplacer(boolean isPiege) throws JoueurException, AbstractPersonneException;
}
