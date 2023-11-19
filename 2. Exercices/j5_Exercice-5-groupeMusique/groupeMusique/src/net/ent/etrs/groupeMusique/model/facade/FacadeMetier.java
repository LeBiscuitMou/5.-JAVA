package net.ent.etrs.groupeMusique.model.facade;

import net.ent.etrs.groupeMusique.model.Concert;
import net.ent.etrs.groupeMusique.model.Musicien;

public interface FacadeMetier {

   void creerMusicien();

   Musicien[] supprimerMusicien(Musicien musicienASuppr, int index);

   void modifierMusicien();

   Musicien[] afficherLesMusiciens();

   void creerFan();

   void creerConcert();

   void modifierConcert();

   void annulerConcert();

   Concert[] afficherTousLesConcert();

}
