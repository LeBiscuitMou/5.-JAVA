package net.ent.etrs.model.entities;

import net.ent.etrs.model.entities.exceptions.PieceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Piece {

    private String numero;

    private List<MaterielInformatique> lstMaterielInformatique = new ArrayList<>();

    protected Piece(final String numero) throws PieceException {
        setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    private void setNumero(final String numero) throws PieceException {
        if (Objects.isNull(numero)){
            throw new PieceException();
        }

        if (numero.length() != 3){
            throw new PieceException();
        }

        try {
            Integer.parseInt(numero);
        }catch (NumberFormatException e){
            throw new PieceException();
        }

        this.numero = numero;
    }

    public void ajouterMaterielInformatique(final MaterielInformatique materielInformatique) throws PieceException {
        if (Objects.isNull(materielInformatique)){
            throw new PieceException();
        }
        if (this.lstMaterielInformatique.contains(materielInformatique)){
            throw new PieceException();
        }
        this.lstMaterielInformatique.add(materielInformatique);
    }

    public void supprimerMaterielInformatique(final MaterielInformatique materielInformatique) throws PieceException {
        if (Objects.isNull(materielInformatique)){
            throw new PieceException();
        }
        if (!this.lstMaterielInformatique.contains(materielInformatique)){
            throw new PieceException();
        }
        this.lstMaterielInformatique.remove(materielInformatique);
    }

    public List<MaterielInformatique> getLstMaterielInformatique() {
        return Collections.unmodifiableList(lstMaterielInformatique);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(numero, piece.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "numero='" + numero + '\'' +
                '}';
    }
}
