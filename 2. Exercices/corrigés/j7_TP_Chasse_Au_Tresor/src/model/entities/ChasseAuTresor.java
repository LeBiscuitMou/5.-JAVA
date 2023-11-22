package model.entities;

import model.exceptions.ChasseAuTresorException;
import model.exceptions.CoordonneeException;
import model.exceptions.EquipageException;
import model.references.C;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class ChasseAuTresor {

    private Carte laCarte;
    private Deplacant[] tabJoueurs;

    private void setLaCarte(Carte laCarte) throws Exception {

        if (Objects.isNull(laCarte)) {
            throw new Exception("ERR: la carte vaut NULL");
        }
        this.laCarte = laCarte;
    }

    public void setTabJoueurs(Deplacant[] tabJoueurs) {
        this.tabJoueurs = tabJoueurs;
    }

    public Carte getLaCarte() {
        return laCarte;
    }

    public ChasseAuTresor() throws Exception {
        initialiserLeJeu();
    }

    /**
     * Méthode chargée d'initialiser les donnes(DONC les attributs de la classe).
     * 1) la carte
     * 2) tabJoueurs :ATTENTION  Deplacant[]
     */
    private void initialiserLeJeu() throws Exception {
        // 1) la carte
        setLaCarte(FabriqueMetier.fabriquerCarte());

        //2) les joueurs
        Deplacant[] tabJoueurs2 = new Deplacant[C.NB_JOUEUR];
        Coordonnee coord1 = FabriqueMetier.fabriquerCoordonnee(C.MIN, C.MIN);

        Random rand = new Random();

        //tabJoueurs[0]=FabriqueMetier.fabriquerUnJoueur(String identite, int ptVie, coord1);
        tabJoueurs2[0] = FabriqueMetier.fabriquerUnJoueur(C.IDENT_J1,  C.NO_JOUEUR0);
        tabJoueurs2[1] = FabriqueMetier.fabriquerUnJoueur(C.IDENT_J2,  C.NO_JOUEUR1);

        setTabJoueurs(tabJoueurs2);

    }


    public Deplacant[] getTabJoueurs() {
        return tabJoueurs;
    }
}
