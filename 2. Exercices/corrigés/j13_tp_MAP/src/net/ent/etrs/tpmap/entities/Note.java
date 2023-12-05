package net.ent.etrs.tpmap.entities;


public class Note {


    private Float valeur;

    private Integer coeff;

    public Note(Float valeur, Integer coeff) {
        this.setCoeff(coeff);
        this.setValeur(valeur);
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public Integer getCoeff() {
        return coeff;
    }

    public void setCoeff(Integer coeff) {
        this.coeff = coeff;
    }


}
