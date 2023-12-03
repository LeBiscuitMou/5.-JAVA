package net.ent.etrs.kingdomino.models.facade.impl;

import net.ent.etrs.kingdomino.models.entities.Joueur;
import net.ent.etrs.kingdomino.models.entities.Tuile;
import net.ent.etrs.kingdomino.models.entities.exceptions.JoueurException;
import net.ent.etrs.kingdomino.models.entities.references.ConstanteMetier;
import net.ent.etrs.kingdomino.models.facade.FacadeMetier;
import net.ent.etrs.kingdomino.models.facade.exceptions.BusinessException;

import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {

    private List<Joueur> lesJoueurs = new ArrayList<Joueur>();

    private List<Tuile> lePaquetTuiles = new ArrayList<Tuile>();

    @Override
    public void creerJoueur(Joueur joueur) throws BusinessException {
        if (Objects.isNull(joueur)){
            throw new BusinessException(ConstanteMetier.FACADE_JOUEUR_NULL);
        }
        if(this.lesJoueurs.contains(joueur)){
            throw new BusinessException(ConstanteMetier.FACADE_JOUEUR_ALREADY_EXIST);
        }
        this.lesJoueurs.add(joueur);
    }

    @Override
    public List<Joueur> listerTousLesJoueurs() {
        return Collections.unmodifiableList(this.lesJoueurs);
    }

    @Override
    public void sauvegarderTuileJeu(List<Tuile> lstTuile) throws BusinessException {
        if (Objects.isNull(lstTuile)) {
            throw new BusinessException(ConstanteMetier.SVG_TUILES_PARTIE_ERROR);
        }

        this.lePaquetTuiles.addAll(lstTuile);
    }

    @Override
    public List<Tuile> listerToutesLesTuiles() {
        return Collections.unmodifiableList(this.lePaquetTuiles);
    }

    @Override
    public void retirerTuilePioche(List<Tuile> selectionTuile) {
        this.lePaquetTuiles.removeAll(selectionTuile);
    }

    @Override
    public Joueur[] listerTousLesJoueursParPosition() throws JoueurException {
        Joueur[] result = new Joueur[this.lesJoueurs.size()];
        for (int i = 1; i <= this.lesJoueurs.size(); i++) {
            if (this.lesJoueurs.get(i-1).getPosition() == 0) {
                this.lesJoueurs.get(i-1).setPosition(i);
            }
        }

        for (Joueur j: this.lesJoueurs) {
            result[j.getPosition()-1] = j;
        }

        return result;
    }
}
