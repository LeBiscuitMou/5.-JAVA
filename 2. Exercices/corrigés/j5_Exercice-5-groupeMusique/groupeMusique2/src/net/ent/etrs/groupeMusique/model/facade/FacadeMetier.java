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

   Fan creerFan(Fan fan);

   Concert creerConcert(Concert concert);

   Concert modifierConcert(Concert concert);

   void annulerConcert(Concert concert);

   Concert[] recupererTousLesConcert();

}
