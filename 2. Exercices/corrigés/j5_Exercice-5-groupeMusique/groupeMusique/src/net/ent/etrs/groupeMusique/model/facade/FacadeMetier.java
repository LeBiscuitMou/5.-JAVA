package net.ent.etrs.groupeMusique.model.facade;

public interface FacadeMetier {

   void creerMusicien();

   void supprimerMusicien();

   void modifierMusicien();

   void afficherLesMusiciens();

   void creerFan();

   void creerConcert();

   void modifierConcert();

   void annulerConcert();

   void afficherTousLesConcert();

}
