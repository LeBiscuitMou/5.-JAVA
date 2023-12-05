package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.BatimentDao;
import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.MaterielInformatiqueDao;
import net.ent.etrs.model.dao.excpetions.DaoException;
import net.ent.etrs.model.entities.Batiment;
import net.ent.etrs.model.entities.EntitiesFactory;
import net.ent.etrs.model.entities.MaterielInformatique;
import net.ent.etrs.model.entities.Piece;
import net.ent.etrs.model.entities.exceptions.*;
import net.ent.etrs.model.entities.references.TailleEcran;
import net.ent.etrs.model.entities.references.TypeOrdinateur;
import net.ent.etrs.model.entities.references.TypeReseau;
import net.ent.etrs.model.facade.exceptions.BusinessException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FacadeMetierImpl implements FacadeMetier{

    protected FacadeMetierImpl() {
    }

    private BatimentDao batimentDao = DaoFactory.fabriquerBatimentDao();
    private MaterielInformatiqueDao materielInformatiqueDao = DaoFactory.fabriquerMaterielInformatiqueDao();

    @Override
    public void initialierApplication() {
       initMateriel();
       initBatiment();

    }

    private void initBatiment() {
        try {
            MaterielInformatiqueDao materielInformatiqueDao = DaoFactory.fabriquerMaterielInformatiqueDao();
            MaterielInformatique ordinateur1 = materielInformatiqueDao.read("12345678");

            MaterielInformatique ordinateur2 = materielInformatiqueDao.read("45688714");
            MaterielInformatique ordinateur4 = materielInformatiqueDao.read("65489731");
            MaterielInformatique ordinateur3 = materielInformatiqueDao.read("98756421");
            MaterielInformatique ordinateur5 = materielInformatiqueDao.read("11566789");



            MaterielInformatique ecran1 = materielInformatiqueDao.read("45678931");
            MaterielInformatique ecran2 = materielInformatiqueDao.read("65564131");
            MaterielInformatique ecran3 = materielInformatiqueDao.read("97861313");
            MaterielInformatique ecran4 = materielInformatiqueDao.read("45566446");
            MaterielInformatique ecran5 = materielInformatiqueDao.read("98763144");

            Batiment bat201 = EntitiesFactory.fabriquerBatiment("201");
            Piece p201010 = EntitiesFactory.fabriquerPiece("010");
            Piece p201110 = EntitiesFactory.fabriquerPiece("110");
            Piece p201210 = EntitiesFactory.fabriquerPiece("210");
            Piece p201223 = EntitiesFactory.fabriquerPiece("223");

            p201010.ajouterMaterielInformatique(ordinateur1);
            p201010.ajouterMaterielInformatique(ecran1);
            p201110.ajouterMaterielInformatique(ordinateur2);
            p201110.ajouterMaterielInformatique(ecran2);
            p201210.ajouterMaterielInformatique(ordinateur3);
            p201210.ajouterMaterielInformatique(ecran3);
            p201223.ajouterMaterielInformatique(ordinateur4);
            p201223.ajouterMaterielInformatique(ecran4);

            bat201.ajouterPiece(p201010);
            bat201.ajouterPiece(p201110);
            bat201.ajouterPiece(p201210);
            bat201.ajouterPiece(p201223);

            Batiment bat202 = EntitiesFactory.fabriquerBatiment("202");
            bat202.ajouterPiece(EntitiesFactory.fabriquerPiece("010"));
            bat202.ajouterPiece(EntitiesFactory.fabriquerPiece("115"));
            bat202.ajouterPiece(EntitiesFactory.fabriquerPiece("232"));

            Batiment bat203 = EntitiesFactory.fabriquerBatiment("203");
            Piece p203009 = EntitiesFactory.fabriquerPiece("009");
            p203009.ajouterMaterielInformatique(ordinateur5);
            p203009.ajouterMaterielInformatique(ecran5);
            bat203.ajouterPiece(p203009);
            bat203.ajouterPiece(EntitiesFactory.fabriquerPiece("010"));

            Batiment bat204 = EntitiesFactory.fabriquerBatiment("204");
            bat204.ajouterPiece(EntitiesFactory.fabriquerPiece("215"));
            bat204.ajouterPiece(EntitiesFactory.fabriquerPiece("216"));
            bat204.ajouterPiece(EntitiesFactory.fabriquerPiece("217"));


            this.batimentDao.create(bat201);

            this.batimentDao.create(bat202);
            this.batimentDao.create(bat203);
            this.batimentDao.create(bat204);
        } catch (DaoException | BatimentConstructionException | PieceConstructionException | PieceException |
                 BatimentException e) {
            e.printStackTrace();
        }
    }

    private void initMateriel() {
        try {
            MaterielInformatique ordinateur1 = EntitiesFactory.fabriquerOrdinateur("12345678", LocalDate.now().plusYears(2), TypeOrdinateur.BUR, TypeReseau.INTERNET);

            MaterielInformatique ordinateur2 = EntitiesFactory.fabriquerOrdinateur("45688714", LocalDate.now().plusYears(3), TypeOrdinateur.DEV, TypeReseau.INTRADEF);
            MaterielInformatique ordinateur4 = EntitiesFactory.fabriquerOrdinateur("65489731", LocalDate.now().plusYears(3), TypeOrdinateur.SIMU, TypeReseau.INTRADEF);
            MaterielInformatique ordinateur3 = EntitiesFactory.fabriquerOrdinateur("98756421", LocalDate.now().plusYears(1), TypeOrdinateur.OPS, TypeReseau.INTERNET);
            MaterielInformatique ordinateur5 = EntitiesFactory.fabriquerOrdinateur("11566789", LocalDate.now().plusYears(6), TypeOrdinateur.BUR, TypeReseau.INTRADEF);

            this.materielInformatiqueDao.create(ordinateur1);
            this.materielInformatiqueDao.create(ordinateur2);
            this.materielInformatiqueDao.create(ordinateur3);
            this.materielInformatiqueDao.create(ordinateur4);
            this.materielInformatiqueDao.create(ordinateur5);

            MaterielInformatique ecran1 = EntitiesFactory.fabriquerEcran("45678931", LocalDate.now().plusMonths(12), TailleEcran.P19);
            MaterielInformatique ecran2 = EntitiesFactory.fabriquerEcran("65564131", LocalDate.now().plusMonths(3), TailleEcran.P21);
            MaterielInformatique ecran3 = EntitiesFactory.fabriquerEcran("97861313", LocalDate.now().plusMonths(8), TailleEcran.P22);
            MaterielInformatique ecran4 = EntitiesFactory.fabriquerEcran("45566446", LocalDate.now().plusMonths(23), TailleEcran.P19);
            MaterielInformatique ecran5 = EntitiesFactory.fabriquerEcran("98763144", LocalDate.now().plusMonths(4), TailleEcran.P22);

            this.materielInformatiqueDao.create(ecran1);
            this.materielInformatiqueDao.create(ecran2);
            this.materielInformatiqueDao.create(ecran3);
            this.materielInformatiqueDao.create(ecran4);
            this.materielInformatiqueDao.create(ecran5);

        } catch (MaterielInformatiqueConstructionException | DaoException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void creerMaterielInformatique(final MaterielInformatique materielInformatique) throws BusinessException {
        try {
            this.materielInformatiqueDao.create(materielInformatique);
        } catch (DaoException e) {
//            //todo e.printStackTrace()
//            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }


    @Override
    public void supprimerMaterielInformatique(final MaterielInformatique materielInformatique) throws BusinessException {
        try {
            this.materielInformatiqueDao.delete(materielInformatique.getNumSerie());
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<MaterielInformatique> listerMaterielInformatique() {
        return this.materielInformatiqueDao.readAll();
    }

    @Override
    public List<MaterielInformatique> listerMaterielInformatiqueBatiment(Batiment batiment) {
        return this.materielInformatiqueDao.readAllByBatiment(batiment);
    }

    @Override
    public List<MaterielInformatique> listerMaterielInformatiqueNonAffecte() {
        List<MaterielInformatique> lstMaterielInformatiqueNonAffecte = new ArrayList<>(this.materielInformatiqueDao.readAll());
        lstMaterielInformatiqueNonAffecte.removeAll(this.materielInformatiqueDao.readAllMaterielInformatiqueAffecte());
        return lstMaterielInformatiqueNonAffecte;
    }

    @Override
    public List<Batiment> listerBatiment() {
        return this.batimentDao.readAll();
    }

    @Override
    public void affecterMaterielInformatiquePiece(final Batiment batiment) throws BusinessException {
        try {
            this.batimentDao.update(batiment);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
