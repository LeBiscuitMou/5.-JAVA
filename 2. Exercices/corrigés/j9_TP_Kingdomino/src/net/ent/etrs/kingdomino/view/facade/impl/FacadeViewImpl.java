package net.ent.etrs.kingdomino.view.facade.impl;

import net.ent.etrs.kingdomino.models.entities.EntitiesFactory;
import net.ent.etrs.kingdomino.models.entities.Joueur;
import net.ent.etrs.kingdomino.models.entities.Tuile;
import net.ent.etrs.kingdomino.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.kingdomino.models.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.models.entities.references.Couleur;
import net.ent.etrs.kingdomino.view.commons.utils.AffichageConsole;
import net.ent.etrs.kingdomino.view.commons.utils.LectureConsole;
import net.ent.etrs.kingdomino.view.facade.FacadeView;
import net.ent.etrs.kingdomino.view.facade.exception.FacadeViewException;
import net.ent.etrs.kingdomino.view.references.ConstanteView;

import java.util.ArrayList;
import java.util.List;

public class FacadeViewImpl implements FacadeView {
    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

    @Override
    public Joueur saisirJoueur(List<Couleur> couleurs) throws EntitiesFactoryException {
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom du Joueur");

        List<String> lstCouleur = new ArrayList<String>();
        for (Couleur c : couleurs) {
            lstCouleur.add(c.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lstCouleur);
        AffichageConsole.afficherMessageAvecSautLigne("Selectionner une Couleur");
        int choix = LectureConsole.lectureChoixInt(0, lstCouleur.size());

        Couleur couleur = Couleur.valueOf(lstCouleur.get(choix-1));
        return EntitiesFactory.fabriquerJoueur(nom,couleur);
    }

    @Override
    public int saisirNbJoueur() {
        AffichageConsole.afficherMessageAvecSautLigne("Saisir le nombre de joueur entre 3 et 4");
        return LectureConsole.lectureChoixInt(3,4);
    }

    @Override
    public void afficherTerrainJoueur(Joueur joueur) {
        AffichageConsole.afficherMessageAvecSautLigne("Terrain du Joueur : "+joueur.getNom());
        for (int i = 0; i < Joueur.getTailleTerrain(); i++) {
            for (int j = 0; j < Joueur.getTailleTerrain(); j++) {
                AffichageConsole.afficherMessageSansSautLigne(String.format("%s |",joueur.getTerrain()[i][j] == null ? "" : joueur.getTerrain()[i][j].getSymbol()));
            }
            AffichageConsole.afficherMessageAvecSautLigne("");
        }

    }

    @Override
    public Tuile afficherChoixTuile(List<Tuile> selectionTuile, Joueur joueur, int oldPosition) throws FacadeViewException, JoueurException {
        if (selectionTuile.size() == 0) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUNE_TUILE);
        }
        List<String> lstTuile = new ArrayList<String>();
        for (Tuile r : selectionTuile) {
            lstTuile.add(r.toString());
        }
        AffichageConsole.afficherMenuSimple(lstTuile);
        AffichageConsole.afficherMessageAvecSautLigne("Selectionner une Tuile");
        int choix = LectureConsole.lectureChoixInt(0, lstTuile.size());
        joueur.setPosition(choix + oldPosition);
        return selectionTuile.get(choix - 1);
    }

    @Override
    public void afficherResultat(List<Joueur> joueurs) {
        for (Joueur j: joueurs) {
            AffichageConsole.afficherMessageAvecSautLigne(j.getNom() +" Score = "+ calculerScore(j.getTerrain()));
        }
    }

    private int calculerScore(Tuile[][] terrain) {
        int total = 0;
        int ble = 0;
        int bleCR = 0;


        return total;
    }
}
