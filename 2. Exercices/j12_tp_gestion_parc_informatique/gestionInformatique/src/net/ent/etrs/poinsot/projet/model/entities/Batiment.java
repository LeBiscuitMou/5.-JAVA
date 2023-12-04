package net.ent.etrs.poinsot.projet.model.entities;

import net.ent.etrs.poinsot.projet.model.entities.exceptions.BatimentException;
import net.ent.etrs.poinsot.projet.model.entities.exceptions.PieceException;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Batiment {
    private String libelle;
    private List<Piece> pieces;

    protected Batiment(String libelle) throws BatimentException {
        this.setLibelle(libelle);
    }

    public String getLibelle() {
        return libelle;
    }

    private void setLibelle(String libelle) throws BatimentException {
        if (Objects.isNull(libelle)) {
            throw new BatimentException(ConstanteMetier.BATIMENT_LIBELLE_IS_NULL);
        }
        if (libelle.isBlank()) {
            throw new BatimentException(ConstanteMetier.BATIMENT_LIBELLE_IS_BLANK);
        }
        this.libelle = libelle;
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

    public void ajouterPiece(Piece piece) throws BatimentException {
        if (Objects.isNull(piece)) {
            throw new BatimentException(ConstanteMetier.PIECE_IS_NULL);
        }
        if (this.pieces.contains(piece)) {
            throw new BatimentException(ConstanteMetier.PIECE_EXISTE_DEJA);
        }
        this.pieces.add(piece);
    }

    public void supprimerPiece(Piece piece) throws BatimentException {
        if (Objects.isNull(piece)) {
            throw new BatimentException(ConstanteMetier.PIECE_IS_NULL);
        }
        if (!this.pieces.contains(piece)) {
            throw new BatimentException(ConstanteMetier.PIECE_EXISTE_PAS);
        }
        this.pieces.add(piece);
    }
}