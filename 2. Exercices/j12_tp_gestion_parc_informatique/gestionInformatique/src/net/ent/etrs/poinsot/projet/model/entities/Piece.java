package net.ent.etrs.poinsot.projet.model.entities;

import net.ent.etrs.poinsot.projet.model.entities.exceptions.PieceException;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Piece {
    private String numero;
    private List<MaterielInformatique> lstMaterielInformatique = new ArrayList<>();

    protected Piece(String numero) throws PieceException {
        this.setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    private void setNumero(String numero) throws PieceException {
        if (Objects.isNull(numero)) {
            throw new PieceException(ConstanteMetier.PIECE_NUMERO_IS_NULL);
        }
        if (numero.isBlank()) {
            throw new PieceException(ConstanteMetier.PIECE_NUMERO_IS_BLANK);
        }
        this.numero = numero;
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

    public void ajouterMaterielInformatique(MaterielInformatique materielInformatique) throws PieceException {
        if (Objects.isNull(materielInformatique)) {
            throw new PieceException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_NULL_EXCEPTION);
        }
        if (this.lstMaterielInformatique.contains(materielInformatique)) {
            throw new PieceException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_EXCEPTION);
        }
        this.lstMaterielInformatique.add(materielInformatique);
    }

    public void supprimerMaterielInformatique(MaterielInformatique materielInformatique) throws PieceException {
        if (Objects.isNull(materielInformatique)) {
            throw new PieceException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_EXIST_NULL_EXCEPTION);
        }
        if (!this.lstMaterielInformatique.contains(materielInformatique)) {
            throw new PieceException(ConstanteMetier.DAO_MATERIEL_INFORMATIQUE_SUPPRESSION_EXCEPTION);
        }
        this.lstMaterielInformatique.remove(materielInformatique);
    }
}