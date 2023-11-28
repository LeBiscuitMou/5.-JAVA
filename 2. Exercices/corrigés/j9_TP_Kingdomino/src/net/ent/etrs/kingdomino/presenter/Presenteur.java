package net.ent.etrs.kingdomino.presenter;

import net.ent.etrs.kingdomino.models.entities.EntitiesFactory;
import net.ent.etrs.kingdomino.models.entities.Joueur;
import net.ent.etrs.kingdomino.models.entities.Tuile;
import net.ent.etrs.kingdomino.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.kingdomino.models.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.models.entities.references.ConstanteMetier;
import net.ent.etrs.kingdomino.models.entities.references.Couleur;
import net.ent.etrs.kingdomino.models.facade.FacadeMetier;
import net.ent.etrs.kingdomino.models.facade.exceptions.BusinessException;
import net.ent.etrs.kingdomino.models.facade.impl.FactoryFacadeMetier;
import net.ent.etrs.kingdomino.view.facade.FacadeView;
import net.ent.etrs.kingdomino.view.facade.exception.FacadeViewException;
import net.ent.etrs.kingdomino.view.facade.impl.FactoryFacadeView;

import java.util.*;
import java.util.zip.CheckedOutputStream;

public class Presenteur {

    private static final FacadeView facadeView = FactoryFacadeView.fabriquerFacadeView();

    private static final FacadeMetier facadeMetier = FactoryFacadeMetier.fabriquerFacadeMetier();


    private List<Tuile> initTuileJeu() throws EntitiesFactoryException {
        List<Tuile> result = new ArrayList<>();
        //Ble
        for (int i = 0; i < ConstanteMetier.NB_TUILE_BLE_SANS_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileBle(0));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_BLE_1_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileBle(1));
        }
        //Eau
        for (int i = 0; i < ConstanteMetier.NB_TUILE_EAU_SANS_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileEau(0));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_EAU_1_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileEau(1));
        }
        //Foret
        for (int i = 0; i < ConstanteMetier.NB_TUILE_FORET_SANS_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileForet(0));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_FORET_1_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileForet(1));
        }
        //Prairie
        for (int i = 0; i < ConstanteMetier.NB_TUILE_PRAIRIE_SANS_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuilePrairie(0));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_PRAIRIE_1_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuilePrairie(1));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_PRAIRIE_2_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuilePrairie(2));
        }
        //Marais
        for (int i = 0; i < ConstanteMetier.NB_TUILE_MARAIS_SANS_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileMarais(0));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_MARAIS_1_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileMarais(1));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_MARAIS_2_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileMarais(2));
        }
        // Mine
        for (int i = 0; i < ConstanteMetier.NB_TUILE_MINE_SANS_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileMine(0));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_MINE_1_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileMine(1));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_MINE_2_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileMine(2));
        }
        for (int i = 0; i < ConstanteMetier.NB_TUILE_MINES_3_CR; i++) {
            result.add(EntitiesFactory.fabriquerTuileMine(3));
        }

        // Doit contenir 96 tuiles
        return result;
    }

    private List<Tuile> initilisationPioche(int NbJoueur) throws EntitiesFactoryException {

        Random r = new Random();
        List<Tuile> initJeu = initTuileJeu();
        List<Tuile> result = new ArrayList<>(NbJoueur * ConstanteMetier.NB_DOMINO_BY_JOUEUR);
        for (int i = 0; i < NbJoueur*ConstanteMetier.NB_DOMINO_BY_JOUEUR; i++) {
            Tuile tirage = initJeu.get(r.nextInt(0,initJeu.size()));
            result.add(tirage);
            initJeu.remove(tirage);
        }
        Collections.shuffle(result);
        return result;
    }

    public void start(){

        try {
            initialiserJoueur();
            int nbJoueur = facadeMetier.listerTousLesJoueurs().size();
            List<Tuile> lstTuile = initilisationPioche(nbJoueur);
            facadeMetier.sauvegarderTuileJeu(lstTuile);
            demarragePartie(nbJoueur);
        } catch (EntitiesFactoryException | JoueurException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void demarragePartie(int nbJoueur) throws JoueurException, FacadeViewException {
        do{
            List<Tuile> selectionTuile = affichageDesTuiles(facadeMetier.listerToutesLesTuiles(),nbJoueur);
            facadeMetier.retirerTuilePioche(selectionTuile);

            Joueur[] lesJoueurs = facadeMetier.listerTousLesJoueursParPosition();

            for (int i = 0; i < lesJoueurs.length; i++) {
                affichageTerrainJoueur(lesJoueurs[i]);
                selectionTuile = selectionTuileParJoueur(selectionTuile,lesJoueurs[i],i);
                affichageTerrainJoueur(lesJoueurs[i]);
            }



        }while (facadeMetier.listerToutesLesTuiles().size() > 0);
        facadeView.afficherResultat(facadeMetier.listerTousLesJoueurs());
    }

    private void joueurPlaceTuile(Joueur joueur , Tuile tuile) {
        //TODO
        //Récupéré les position possible
        //Choisir la position
        //Sauvegarder le Joueur
    }

    private void affichageTerrainJoueur(Joueur joueur) {
        facadeView.afficherTerrainJoueur(joueur);
    }

    private List<Tuile> selectionTuileParJoueur(List<Tuile> selectionTuile,Joueur joueur, int positionJoueur) throws JoueurException, FacadeViewException {
        Tuile t = facadeView.afficherChoixTuile(selectionTuile,joueur,positionJoueur);
        selectionTuile.remove(t);
        joueurPlaceTuile(joueur,t);
        return selectionTuile;
    }

    private List<Tuile> affichageDesTuiles(List<Tuile> tuiles,int nbJoueur) {
        List<Tuile> result = new ArrayList<>();
        for (int i = 0; i < nbJoueur; i++) {
            result.add(tuiles.get(i));
        }
        return result;
    }

    private void initialiserJoueur() throws EntitiesFactoryException {
        int nbJoueur = facadeView.saisirNbJoueur();
        List<Couleur> lstCouleur = new ArrayList<>(Arrays.asList(Couleur.values()));
        for (int i = 0; i < nbJoueur; i++) {
            creationJoueur(lstCouleur);
        }
    }

    private void creationJoueur(List<Couleur> lstCouleur) throws EntitiesFactoryException {
        Joueur j = facadeView.saisirJoueur(lstCouleur);
        try {
            facadeMetier.creerJoueur(j);
        } catch (BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
            creationJoueur(lstCouleur);
        }
        lstCouleur.remove(j.getCouleurJoueur());
    }

}
