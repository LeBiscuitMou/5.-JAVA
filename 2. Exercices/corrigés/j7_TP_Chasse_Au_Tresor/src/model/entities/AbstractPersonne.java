package model.entities;

import model.exceptions.AbstractPersonneException;
import model.exceptions.CoordonneeException;
import model.exceptions.JoueurException;
import model.references.C;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractPersonne implements Deplacant {
    private String identite;
    private int ptVie;

    public AbstractPersonne(String identite) throws AbstractPersonneException {
        setIdentite(identite);
        setPtVie(C.PT_VIE_MINI+new Random().nextInt(C.PT_VIE_MINI)+10);
    }

    public String getIdentite() {
        return identite;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setIdentite(String identite) throws AbstractPersonneException {
        if(Objects.isNull(identite)){
            throw new AbstractPersonneException("ERR: identite vaut NULL ");
        }
        if(identite.isBlank()){
            throw new AbstractPersonneException("ERR: identite ne contient que des ESPACES ou est VIDE ");
        }
        this.identite = identite;
    }

    public void setPtVie(int ptVie) throws AbstractPersonneException {
        if(ptVie< C.MIN){
            //throw new AbstractPersonneException("ERR:PT de vie négatif");
            this.ptVie=C.MIN;
        }else {
            this.ptVie = ptVie;
        }
    }

    /**
     * Méthode gerant la descente d'une ligne: y+1.
     */
    @Override
    public abstract void descendreUneLigne() throws CoordonneeException;

    /**
     * Méthode gérant la montéee d'une ligne: y-1.
     */
    @Override
    public abstract void monterUneLigne() throws CoordonneeException;

    /**
     * Méthode charge de déplacer un joueur.
     *
     * @param isPiege :boolean, déplacement sur une piège?
     */
    @Override
    public abstract void seDeplacer(boolean isPiege) throws JoueurException, AbstractPersonneException;

    public void recevoirDegat() throws AbstractPersonneException {
        //System.out.println("pv = "+getPtVie());
        setPtVie(getPtVie()-1);
    }
}
