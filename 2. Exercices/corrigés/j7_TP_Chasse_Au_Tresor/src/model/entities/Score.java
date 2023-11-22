package model.entities;

import model.exceptions.ScoreException;
import model.references.C;

import java.util.Objects;

public class Score {
    private boolean tresorTrouve;
    private int nbPiege;
    private int nbCase;

    public boolean isTresorTrouve() {
        return tresorTrouve;
    }

    public int getNbPiege() {
        return nbPiege;
    }

    public int getNbCase() {
        return nbCase;
    }

    public void setTresorTrouve(boolean tresorTrouve) {
        this.tresorTrouve = tresorTrouve;
    }

    public void setNbPiege(int nbPiege) throws ScoreException {
        if(nbPiege<=0){
            throw new ScoreException("ERR: le nombre de piège est incorrect");
        }
        this.nbPiege = nbPiege;
    }

    public void setNbCase(int nbCase) throws ScoreException {
        if(nbCase<0 || nbCase>(C.DIM * C.DIM)){
            throw new ScoreException("ERR: le nombre case parcourure est incorrect");
        }
        this.nbCase = nbCase;
    }

    public Score(int nbPiege, int nbCase) throws ScoreException {
        setTresorTrouve(false);
        setNbPiege(nbPiege);
        setNbCase(nbCase);
    }


    public void incrementerNombrePiege() throws ScoreException {
        setNbPiege(getNbPiege()+1);
    }
    public void incrementerNombreCase() throws ScoreException {
        setNbCase(getNbCase()+1);
    }
    public void trouverTresor(){
        setTresorTrouve(true);
    }

    @Override
    public String toString() {
        return "Score{" +
                "tresorTrouve=" + tresorTrouve +
                ", nbPiege=" + nbPiege +
                ", nbCase=" + nbCase +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return tresorTrouve == score.tresorTrouve && nbPiege == score.nbPiege && nbCase == score.nbCase;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tresorTrouve, nbPiege, nbCase);
    }
}
