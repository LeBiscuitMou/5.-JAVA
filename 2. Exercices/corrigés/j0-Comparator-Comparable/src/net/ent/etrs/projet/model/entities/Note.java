package net.ent.etrs.projet.model.entities;

import net.ent.etrs.projet.model.exceptions.NoteException;
import net.ent.etrs.projet.model.references.ErrorMsg;

public class Note {
    /* ******************************** VARIABLES ******************************** */
    private float valeur;
    private Integer coeff;
    /* ******************************* CONSTRUCTOR ******************************* */
    public Note(float valeur, Integer coeff) throws NoteException {
        this.setValeur(valeur);
        this.setCoeff(coeff);
    }
    /* ********************************* GETTERS ********************************* */
    public float getValeur() {
        return valeur;
    }

    public Integer getCoeff() {
        return coeff;
    }
    /* ********************************* SETTERS ********************************* */
    public void setValeur(float valeur) throws NoteException {
        if(valeur < 0){
            throw new NoteException(ErrorMsg.NOTE_VALEUR_NEGATIF);
        }
        this.valeur = valeur;
    }

    public void setCoeff(Integer coeff) throws NoteException {
        if(null == coeff){
            throw new NoteException(ErrorMsg.NOTE_COEFF_NULL);
        }
        if(coeff < 0){
            throw new NoteException(ErrorMsg.NOTE_COEFF_NEGATIF);
        }
        this.coeff = coeff;
    }
    /* ******************************** FONCTIONS ******************************** */

    @Override
    public String toString() {
        return String.format("%.4f (coeff:%d)", valeur, coeff);
    }
    /* **************************** PRIVATE FUNCTIONS **************************** */
}
