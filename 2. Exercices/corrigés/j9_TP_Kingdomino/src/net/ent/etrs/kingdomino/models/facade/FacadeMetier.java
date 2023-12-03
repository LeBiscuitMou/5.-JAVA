package net.ent.etrs.kingdomino.models.facade;

import net.ent.etrs.kingdomino.models.entities.Joueur;
import net.ent.etrs.kingdomino.models.entities.Tuile;
import net.ent.etrs.kingdomino.models.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.models.facade.exceptions.BusinessException;

import java.util.List;

public interface FacadeMetier {

    void creerJoueur(Joueur joueur) throws BusinessException;

    List<Joueur> listerTousLesJoueurs();

    void sauvegarderTuileJeu(List<Tuile> lstTuile) throws BusinessException;

    List<Tuile> listerToutesLesTuiles();

    void retirerTuilePioche(List<Tuile> selectionTuile);

    Joueur[] listerTousLesJoueursParPosition() throws JoueurException;
}
