package net.ent.etrs.poinsot.note.model.entities;

import net.ent.etrs.poinsot.note.model.entities.exceptions.NoteException;
import net.ent.etrs.poinsot.note.model.references.ConstanteMetier;

import java.util.Objects;

public class Note {
    private Float valeur;
    private Integer coeff;

    public Note(Float valeur, Integer coeff) throws NoteException {
        this.setValeur(valeur);
        this.setCoeff(coeff);
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) throws NoteException {
        if (Objects.isNull(valeur)) {
            throw new NoteException(ConstanteMetier.NOTE_VALEUR_IS_NULL);
        }
        if (valeur < 0) {
            throw new NoteException(ConstanteMetier.NOTE_VALEUR_IS_NEGATIVE);
        }
        this.valeur = valeur;
    }

    public Integer getCoeff() {
        return coeff;
    }

    public void setCoeff(Integer coeff) throws NoteException {
        if (Objects.isNull(coeff)) {
            throw new NoteException(ConstanteMetier.NOTE_COEFF_IS_NULL);
        }
        if (coeff < 0) {
            throw new NoteException(ConstanteMetier.NOTE_COEFF_IS_NEGATIVE);
        }
        this.coeff = coeff;
    }
}