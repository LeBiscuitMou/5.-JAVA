package net.ent.etrs.groupeMusique.model.facade;

import net.ent.etrs.groupeMusique.model.Concert;
import net.ent.etrs.groupeMusique.model.Fan;
import net.ent.etrs.groupeMusique.model.Musicien;
import net.ent.etrs.groupeMusique.model.utils.exception.FacadeMetierException;
import net.ent.etrs.groupeMusique.model.utils.exception.TableauUtilsException;

public interface FacadeMetier {

   Musicien sauvegarderMusicien(Musicien musicienACreer) throws TableauUtilsException, FacadeMetierException;

   void supprimerMusicien(Musicien musicienASupprimer) throws FacadeMetierException;

   Musicien modifierMusicien(Musicien musicienAModifier) throws FacadeMetierException;

   Musicien[] recupererLesMusiciens();

   Fan sauvegarderFan(Fan fanACreer) throws FacadeMetierException;

   Concert creerConcert(Concert concertACreer) throws FacadeMetierException;

   Concert modifierConcert(Concert concertAModifier) throws FacadeMetierException;

   void annulerConcert(Concert concertAAnnuler) throws FacadeMetierException;

   Concert[] recupererTousLesConcert();

}
