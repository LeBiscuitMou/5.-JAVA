package model;

import model.entities.*;
import model.exceptions.*;
import model.references.C;
import model.references.TypeCase;

import java.util.Objects;

public class FacadeMetier {
    private ChasseAuTresor chasse;

    public ChasseAuTresor getChasse() {
        return chasse;
    }

    public void setChasse(ChasseAuTresor chasse) throws FacadeMetierException {
        if (Objects.isNull(chasse)) {
            throw new FacadeMetierException("ERR: la chasse au trésor vaut NULL");
        }
        this.chasse = chasse;
    }

    public FacadeMetier() throws Exception {
        initialiser();
    }

    private void initialiser() throws Exception {
        setChasse(FabriqueMetier.fabriquerChasseauTresor());

    }

    public char deplacerUnJoueur(int noj) throws JoueurException, AbstractPersonneException, CoordonneeException {
        char c = ' ';
        if (noj == C.NO_JOUEUR0) {
            c = parcourirLigneEtAllerBas(noj);
        } else {
            c = parcourirLigneEtAllerHaut(noj);
        }
        return c;
    }

    /**
     * Méthode charge de faire parcourir une ligne de la grille ds la carte puis de monter d'une ligne.
     *
     * @param noj:int, le numéro du joueur qui se déplace.
     * @return char: renverra 'T' si trouve le trésor sinon NAINPORTENAWACS
     */
    private char parcourirLigneEtAllerHaut(int noj) throws JoueurException, AbstractPersonneException, CoordonneeException {
        char c = ' ';
        // cas du joueur 0: 0,0
        //parcourir la ligne, case par case
        //si case ='T =>maj c
        //si case ='P' => blessure
        Joueur leJoueur = (Joueur) getChasse().getTabJoueurs()[noj];

        int lig = leJoueur.getCoord().getY();

        for (int col = C.DIM-1; col >=0; col--) {
            char uneCase = getChasse().getLaCarte().getGrille()[lig][col];
            //trt des blessures

            if (TypeCase.PIEGE.getSymbole() == uneCase) {
                leJoueur.seDeplacer(true);
            } else {
                //trt SABLE
                if (TypeCase.SABLE.getSymbole() == uneCase) {
                    leJoueur.seDeplacer(false);
                } else {
                    //reperer le trésor
                    //if (TypeCase.TRESOR.getSymbole() == uneCase) {
                    leJoueur.seDeplacer(false);
                    leJoueur.setCoord(FabriqueMetier.fabriquerCoordonnee(lig,col)); //MAJ coordonnées du trésor
                    //1ere solution: return uneCase;
                    //2eme solution
                    c = uneCase;
                    col = C.MIN-1;
                    //}
                }
            }
        }

        // changer la ligne
        leJoueur.monterUneLigne();
        return c;
    }

    /**
     * Méthode chargée de faire parcourir une ligne de la grille ds la carte puis de descendre d'une ligne.
     *
     * @param noj:int, le numéro du joueur qui se déplace.
     * @return char: renverra 'T' si trouve le trésor sinon NAINPORTENAWACS
     */
    private char parcourirLigneEtAllerBas(int noj) throws JoueurException, AbstractPersonneException, CoordonneeException {
        char c = ' ';
        // cas du joueur 0: 0,0
        //parcourir la ligne, case par case
        //si case ='T =>maj c
        //si case ='P' => blessure
        Joueur leJoueur = (Joueur) getChasse().getTabJoueurs()[noj];

        int lig = leJoueur.getCoord().getY();

        for (int col = 0; col < C.DIM; col++) {
            char uneCase = getChasse().getLaCarte().getGrille()[lig][col];
            //trt des blessures

            if (TypeCase.PIEGE.getSymbole() == uneCase) {
                leJoueur.seDeplacer(true);
            } else {

                //trt SABLE
                if (TypeCase.SABLE.getSymbole() == uneCase) {
                    leJoueur.seDeplacer(false);
                } else {
                    //reperer le trésor
                    //if (TypeCase.TRESOR.getSymbole() == uneCase) {
                    leJoueur.seDeplacer(false);
                    leJoueur.setCoord(FabriqueMetier.fabriquerCoordonnee(lig,col));//MAJ coordonnées du trésor
                    //1ere solution: return uneCase;
                    //2eme solution
                    c = uneCase;
                    col = C.DIM;
                    //}
                }
            }
        }

        // changer la ligne
        leJoueur.descendreUneLigne();
        return c;
    }

    /**
     * Méthode chargée de renvoyer l'iodentite du joueur à l'indoce passé en paramètre.
     * @param noj: int, le no du joueur
     * @return String
     */
    public String getIdentiteJoueur(int noj) {
        Joueur depl = (Joueur) getChasse().getTabJoueurs()[noj];

        return depl.getIdentite();
    }

    /**
     * Méthode chargée de renvoyer le no de ligne d'un joueur.
     * @param noj: int, indice du joueur
     * @return int
     */
    public int getLigneJoueur(int noj) {
        Joueur john = (Joueur) getChasse().getTabJoueurs()[noj];
        return john.getCoord().getY();
    }


    /**
     * Méthode chargée de renvoyer les pas de tous les joueurs
     * @return int[]: le tableau des pas
     */
    public int[] getLesPasDesJoueurs() {
        int[] tablo = new int[C.NB_JOUEUR];
        Joueur j0 = (Joueur) getChasse().getTabJoueurs()[0];
        Joueur j1 = (Joueur) getChasse().getTabJoueurs()[1];

        tablo[0]= j0.getNbpas();
        tablo[1]= j1.getNbpas();

        return tablo;
    }

    /**
     * Méthode chargée de renvoyer le tableau des pv des joueurs.
     * @return int[]: le tableau des PV
     */
    public int[] getLesPointVieJoueurs() {
        int[] tablo = new int[C.NB_JOUEUR];
        Joueur j0 = (Joueur) getChasse().getTabJoueurs()[0];
        Joueur j1 = (Joueur) getChasse().getTabJoueurs()[1];

        tablo[0]= j0.getPtVie();
        tablo[1]= j1.getPtVie();

        return tablo;
    }

    /**
     * Méthode chargée de renvoyer les coordonnées du trésor (contenu dans les coorodonnes du joueur gagnant).
     * @param nojg: int , indice du joueur
     * @return Coordonnnee
     * @throws CoordonneeException
     */
    public Coordonnee getCoordonneesTresor(int nojg) throws CoordonneeException {
        Joueur qqn = (Joueur) getChasse().getTabJoueurs()[nojg];
        return qqn.getCoord();
    }
}