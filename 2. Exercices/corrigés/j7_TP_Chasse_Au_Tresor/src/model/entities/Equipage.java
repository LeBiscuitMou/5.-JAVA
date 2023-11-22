package model.entities;

import model.exceptions.EquipageException;
import model.exceptions.ScoreException;
import model.references.C;

import java.util.Objects;

public class Equipage {
    private int no;
    private String capitaine;
    private int ctrMarin;
    private Score leScore;

    public Score getLeScore() {
        return leScore;
    }

    public void setLeScore(Score leScore) throws EquipageException {
        if (Objects.isNull(leScore)) {
            throw new EquipageException("ERR: le score vaut NULL");
        }
        this.leScore = leScore;
    }

    public int getNo() {
        return no;
    }

    public String getCapitaine() {
        return capitaine;
    }

    public int getCtrMarin() {
        return ctrMarin;
    }

    public void setNo(int no) throws EquipageException {
        if (no < 0) {
            throw new EquipageException("ERR:no équipage incorrect");
        }
        this.no = no;
    }

    public void setCapitaine(String capitaine) throws EquipageException {
        if (Objects.isNull(capitaine)) {
            throw new EquipageException(("ERR: nom du capitaine vaut NULL"));
        }
        if (capitaine.isBlank()) {
            throw new EquipageException(("ERR: nom du capitaine est incorrect (vide ou avec espaces)"));
        }
        if (capitaine.length() < C.LG_MIN_CAPITAINE) {
            throw new EquipageException(("ERR: nom du capitaine est incorrect (vide ou avec espaces)"));

        }
        this.capitaine = capitaine;
    }

    public void setCtrMarin(int ctrMarin) throws EquipageException {
        if (ctrMarin < 0) {
            throw new EquipageException("ERR: nombre de marin est incorrect (<0)");
        }
        this.ctrMarin = ctrMarin;
    }

    public Equipage(int no, String capitaine, int ctrMarin) throws EquipageException, ScoreException {
        setNo(no);
        setCapitaine(capitaine);
        setCtrMarin(ctrMarin);
        setLeScore(new Score(C.NB_PIEGE,0));
    }

    @Override
    public String toString() {
        return "Equipage{" +
                "no=" + no +
                ", capitaine='" + capitaine + '\'' +
                ", ctrMarin=" + ctrMarin +
                ", leScore=" + leScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipage equipage = (Equipage) o;
        return no == equipage.no && capitaine.equals(equipage.capitaine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, capitaine);
    }

    /**
     * Méthode qui réalise le déplacement sur la carte.
     * Départ en [0:0]
     * Parcourt la carte ligne par ligne
     * incrementer le nmobre de case parcourue
     * Si trouve P => incrémente le nbP
     * Si trouve T => fait passer TresroTrouve à True
     * @param laCarte
     */
    public boolean seDeplacer(Carte laCarte) throws ScoreException, EquipageException {

        for (int y = 0; y < C.DIM; y++) {
            for (int x = 0; x < C.DIM; x++) {
               if(y==0 && x==0){
                   //Départ
               }else{
                   //nb de case parcourue
                   leScore.incrementerNombreCase();

                   // Piège
                   if(laCarte.isPiegeAt(y,x)){
                       leScore.incrementerNombrePiege();
                   }

                   //Trésor
                   if(laCarte.isTresorAt(y,x)){
                     leScore.trouverTresor();
                     //--Maj du nb de marin
                     setCtrMarin(getCtrMarin()- leScore.getNbPiege());
                     return true;
                   }
               }
            }
        }
        return false;

    }
}
