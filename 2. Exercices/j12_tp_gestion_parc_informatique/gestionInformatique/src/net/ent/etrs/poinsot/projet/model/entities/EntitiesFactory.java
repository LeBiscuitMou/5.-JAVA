package net.ent.etrs.poinsot.projet.model.entities;

import net.ent.etrs.poinsot.projet.model.entities.exceptions.*;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;
import net.ent.etrs.poinsot.projet.model.references.TailleEcran;
import net.ent.etrs.poinsot.projet.model.references.TypeOrdinateur;
import net.ent.etrs.poinsot.projet.model.references.TypeReseau;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static MaterielInformatique fabriquerOrdinateur(String numSerie, LocalDate dateGarantie, TypeOrdinateur typeOrdinateur, TypeReseau typeReseau) throws EntitiesFactoryException {
        try {
            Ordinateur o = new Ordinateur(numSerie, dateGarantie);
            o.setTypeOrdinateur(typeOrdinateur);
            o.setTypeReseau(typeReseau);
            return o;
        } catch (MaterielInformatiqueException | OrdinateurException e) {
            throw new EntitiesFactoryException(ConstanteMetier.ORDINATEUR_TYPE_ORDINATEUR_IS_NULL, e);
        }
    }

    public static MaterielInformatique fabriquerEcran(String numSerie, LocalDate dateGarantie, TailleEcran tailleEcran) throws EntitiesFactoryException {
        try {
            Ecran ecran = new Ecran(numSerie, dateGarantie);
            ecran.setTailleEcran(tailleEcran);
            return ecran;
        } catch (MaterielInformatiqueException | EcranException e) {
            throw new EntitiesFactoryException(ConstanteMetier.ECRAN_TAILLE_ECRAN_IS_NULL, e);
        }
    }

    public static Piece fabriquerPiece(String numero) throws EntitiesFactoryException {
        try {
            return new Piece(numero);
        } catch (PieceException e) {
            throw new EntitiesFactoryException(ConstanteMetier.PIECE_IS_NULL, e);
        }
    }

    public static Batiment fabriquerBatiment(String libelle) throws EntitiesFactoryException {
        try {
            return new Batiment(libelle);
        } catch (BatimentException e) {
            throw new EntitiesFactoryException(ConstanteMetier.DAO_BATIMENT_CREATION_EXCEPTION, e);
        }
    }
}