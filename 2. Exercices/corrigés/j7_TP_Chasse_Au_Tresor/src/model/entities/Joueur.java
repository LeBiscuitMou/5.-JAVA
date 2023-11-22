package model.entities;

import model.exceptions.AbstractPersonneException;
import model.exceptions.CoordonneeException;
import model.exceptions.JoueurException;

import java.util.Objects;

public class Joueur extends AbstractPersonne {
    private int nbpas;
    private Coordonnee coord;

    public Coordonnee getCoord() {
        return coord;
    }

    public void setCoord(Coordonnee coord) throws JoueurException {
        if(Objects.isNull(coord)){
            throw new JoueurException("ERR: coordonnee incorrecte");
        }
        this.coord = coord;
    }

    public int getNbpas() {
        return nbpas;
    }

    public void setNbpas(int nbp) throws JoueurException {

        if(nbp<0){
            //throw new JoueurException("ERR: nb de pas incorrect");
            this.nbpas = 0;
        }
        this.nbpas = nbp;

    }

    public Joueur(String ident, Coordonnee c) throws JoueurException, AbstractPersonneException {
        super(ident);
        setCoord(c);
        setNbpas(0);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Joueur{");
        sb.append("nbpas=").append(nbpas);
        sb.append(", coord=").append(coord);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Méthode gerant la descente d'une ligne: y+1.
     */
    @Override
    public void descendreUneLigne() throws CoordonneeException {
        coord.setY(coord.getY()+1);
    }

    /**
     * Méthode gérant la montéee d'une ligne: y-1.
     */
    @Override
    public void monterUneLigne() throws CoordonneeException {
        coord.setY(coord.getY()-1);
    }

    /**
     * Méthode charge de déplacer un joueur.
     *
     * @param isPiege :boolean, déplacement sur une piège?
     */
    @Override
    public void seDeplacer(boolean isPiege) throws JoueurException, AbstractPersonneException {
        //gestion du nb de pas
        setNbpas(getNbpas()+1);

        // gestion du piege
        if(isPiege){
            //setPtVie(getPtVie()-1);
            recevoirDegat();
        }

    }
}
