package net.ent.etrs.tresor.model.entities;

import net.ent.etrs.tresor.model.exceptions.AbstractPersonneException;
import net.ent.etrs.tresor.model.exceptions.JoueurException;
import net.ent.etrs.tresor.model.references.C;

import java.util.Objects;

public class Joueur extends AbstractPersonne {
    private int noj;
    private int nbPas;
    private Coordonnee coords;

    protected Joueur(String identite, int lePtVie, int leNoj) throws AbstractPersonneException {
        super(identite);
        this.setPtVie(lePtVie);
        this.setNoj(leNoj);
    }

    public int getNoj() {
        return noj;
    }

    public void setNoj(int noj) {
        this.noj = noj;
    }

    public int getNbPas() {
        return nbPas;
    }

    public void setNbPas(int nbPas) {
        this.nbPas = nbPas;
    }

    public Coordonnee getCoords() {
        return coords;
    }

    public void setCoords(Coordonnee coords) {
        this.coords = coords;
    }

    @Override
    public void descendreUneLigne() {
        if (coords.getY() < 0) {
            throw new JoueurException(C.)
        }
    }

    @Override
    public void monterUneLigne() {

    }

    @Override
    public void seDeplacer(boolean deplacer) {

    }
}
