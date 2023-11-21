package net.ent.etrs.groupeMusique.model.facade.impl;

import net.ent.etrs.groupeMusique.model.Concert;
import net.ent.etrs.groupeMusique.model.Fan;
import net.ent.etrs.groupeMusique.model.Musicien;
import net.ent.etrs.groupeMusique.model.facade.FacadeMetier;
import net.ent.etrs.groupeMusique.model.facade.exception.FacadeMetierException;
import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;
import net.ent.etrs.groupeMusique.model.utils.TableauUtils;
import net.ent.etrs.groupeMusique.model.utils.exception.TableauUtilsException;

import java.util.Arrays;

public class FacadeMetierImpl implements FacadeMetier {

    Musicien[] lesMusiciens = new Musicien[0];

    Fan[] lesFans = new Fan[0];

    Concert[] lesConcerts = new Concert[0];


    @Override
    public Musicien sauvegarderMusicien(Musicien musicienACreer) throws FacadeMetierException {
        try {
            TableauUtils.put(musicienACreer,this.lesMusiciens,true);
            return musicienACreer;
        } catch (TableauUtilsException e) {
            throw new FacadeMetierException(ConstantesMetier.FACADE_ERROR_SAVE_MUSICIEN,e);
        }
    }

    @Override
    public void supprimerMusicien(Musicien musicienASupprimer) throws FacadeMetierException {
        //retirer
        try {
            TableauUtils.retirerElementTableau(this.lesMusiciens,musicienASupprimer);
        } catch (TableauUtilsException e) {
            throw new FacadeMetierException(ConstantesMetier.FACADE_ERROR_DELETE_MUSICIEN,e);
        }
    }

    @Override
    public Musicien modifierMusicien(Musicien musicienAModifier) throws FacadeMetierException {

        try {
            //Supprimer l'existant
            supprimerMusicien(musicienAModifier);
            //Ajouter le modifier
            return  sauvegarderMusicien(musicienAModifier);
        } catch (FacadeMetierException e) {
            throw new FacadeMetierException(ConstantesMetier.FACADE_ERROR_MODIFY_MUSICIEN,e);
        }
    }

    @Override
    public Musicien[] recupererLesMusiciens() {
        return Arrays.copyOf(this.lesMusiciens,this.lesMusiciens.length);
    }

    @Override
    public Fan creerFan(Fan fan) {
        return null;
    }

    @Override
    public Concert creerConcert(Concert concert) {
        return null;
    }

    @Override
    public Concert modifierConcert(Concert concert) {
        return null;
    }

    @Override
    public void annulerConcert(Concert concert) {

    }

    @Override
    public Concert[] recupererTousLesConcert() {
        return Arrays.copyOf(this.lesConcerts, this.lesConcerts.length);
    }
}
