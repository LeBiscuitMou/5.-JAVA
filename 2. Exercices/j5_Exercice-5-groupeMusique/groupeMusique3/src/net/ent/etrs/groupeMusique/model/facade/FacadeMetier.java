package net.ent.etrs.groupeMusique.model.facade;

import net.ent.etrs.groupeMusique.model.Concert;
import net.ent.etrs.groupeMusique.model.Fan;
import net.ent.etrs.groupeMusique.model.Musicien;
import net.ent.etrs.groupeMusique.model.facade.exception.FacadeMetierException;

public interface FacadeMetier {

   Musicien sauvegarderMusicien(Musicien musicienACreer) throws FacadeMetierException;

   void supprimerMusicien(Musicien musicienASupprimer) throws FacadeMetierException;

   Musicien modifierMusicien(Musicien musicienAModifier) throws FacadeMetierException;

   Musicien[] recupererLesMusiciens();

   Fan sauvegarderFan(Fan fan) throws FacadeMetierException;

   Concert creerConcert(Concert concert) throws FacadeMetierException;

   Concert modifierConcert(Concert concert) throws FacadeMetierException;

   void annulerConcert(Concert concert) throws FacadeMetierException;

   Concert[] recupererTousLesConcert();

}
