package net.ent.etrs.model.entities;

import net.ent.etrs.model.entities.exceptions.BatimentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Batiment {




    private String libelle;

    private List<Piece> pieces = new ArrayList<>();

    protected Batiment(final String libelle) throws BatimentException {
        setLibelle(libelle);
    }

    public String getLibelle() {
        return libelle;
    }

    private void setLibelle(final String libelle) throws BatimentException {
        if (Objects.isNull(libelle) || libelle.length() != 3){
            throw new BatimentException();
        }
        try {
            Integer.parseInt(libelle);
        }catch (NumberFormatException e){
            throw new BatimentException();
        }
        this.libelle = libelle;
    }

    public void ajouterPiece(final Piece piece) throws BatimentException {

        new ArrayList<Piece>(this.pieces);


        if (Objects.isNull(piece)){
            throw new BatimentException();
        }
        if (this.pieces.contains(piece)){
            throw new BatimentException();
        }
        this.pieces.add(piece);
    }

    public void supprimerPiece(final Piece piece) throws BatimentException {
        if (Objects.isNull(piece)){
            throw new BatimentException();
        }
        if (!this.pieces.contains(piece)){
            throw new BatimentException();
        }
        this.pieces.remove(piece);
    }

    public List<Piece> getPieces() {
        return Collections.unmodifiableList(pieces);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batiment batiment = (Batiment) o;
        return Objects.equals(libelle, batiment.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "libelle='" + libelle + '\'' +
                '}';
    }
}
