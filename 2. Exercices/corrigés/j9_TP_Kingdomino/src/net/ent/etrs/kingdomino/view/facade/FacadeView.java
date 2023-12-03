package net.ent.etrs.kingdomino.view.facade;

import net.ent.etrs.kingdomino.models.entities.Joueur;
import net.ent.etrs.kingdomino.models.entities.Tuile;
import net.ent.etrs.kingdomino.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.kingdomino.models.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.models.entities.references.Couleur;
import net.ent.etrs.kingdomino.view.facade.exception.FacadeViewException;

import java.util.List;

public interface FacadeView {

    void afficherMessage(String message);

    void afficherMessageErreur(String message);

    Joueur saisirJoueur(List<Couleur> couleurs) throws EntitiesFactoryException;

    int saisirNbJoueur();


    void afficherTerrainJoueur(Joueur joueur);

    Tuile afficherChoixTuile(List<Tuile> selectionTuile, Joueur joueur, int oldPosition) throws FacadeViewException, JoueurException;

    void afficherResultat(List<Joueur> joueurs);
}
