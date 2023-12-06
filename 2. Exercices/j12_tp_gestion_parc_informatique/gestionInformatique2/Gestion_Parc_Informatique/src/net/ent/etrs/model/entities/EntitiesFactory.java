package net.ent.etrs.model.entities;

import net.ent.etrs.model.entities.exceptions.*;
import net.ent.etrs.model.entities.references.TailleEcran;
import net.ent.etrs.model.entities.references.TypeOrdinateur;
import net.ent.etrs.model.entities.references.TypeReseau;

import java.time.LocalDate;


public final class EntitiesFactory {

    private EntitiesFactory() {
    }

    public static MaterielInformatique fabriquerOrdinateur(final String numSerie, final LocalDate dateGarantie, final TypeOrdinateur typeOrdinateur, final TypeReseau typeReseau) throws MaterielInformatiqueConstructionException {
        try {
            Ordinateur ordinateur = new Ordinateur(numSerie, dateGarantie);
            ordinateur.setTypeOrdinateur(typeOrdinateur);
            ordinateur.setTypeReseau(typeReseau);
            return ordinateur;
        } catch (MaterielInformatiqueException | OrdinateurException e) {
//            //todo e.printStackTrace()
//            e.printStackTrace();
            throw new MaterielInformatiqueConstructionException(e.getMessage());
        }
    }

    public static MaterielInformatique fabriquerEcran(final String numSerie, final LocalDate dateGarantie, final TailleEcran tailleEcran) throws MaterielInformatiqueConstructionException {
        try {
            Ecran ecran = new Ecran(numSerie, dateGarantie);
            ecran.setTailleEcran(tailleEcran);
            return ecran;
        } catch (MaterielInformatiqueException | EcranException e) {
//            //todo e.printStackTrace()
//            e.printStackTrace();
            throw new MaterielInformatiqueConstructionException(e.getMessage());
        }
    }

    public static Piece fabriquerPiece(final String numero) throws PieceConstructionException {
        try {
            return new Piece(numero);
        } catch (PieceException e) {
            throw new PieceConstructionException();
        }
    }

    public static Batiment fabriquerBatiment(final String libelle) throws BatimentConstructionException {
        try {
            return new Batiment(libelle);
        } catch (BatimentException e) {
            throw new BatimentConstructionException();
        }
    }
}
