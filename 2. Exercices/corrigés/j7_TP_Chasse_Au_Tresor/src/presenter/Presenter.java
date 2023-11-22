package presenter;

import model.FacadeMetier;
import model.entities.*;
import model.exceptions.*;
import model.references.C;
import model.references.TypeCase;
import presenter.exceptions.PresenterException;
import view.Ihm;
import view.OutilsIhm;

import java.util.Objects;

public class Presenter {
    private Ihm vue;
    private FacadeMetier metier;


    public void setVue(Ihm vue) throws PresenterException {
        if(Objects.isNull(vue)){
            throw new PresenterException("ERR: la vue vaut NULL");
        }
        this.vue = vue;
    }


    public void setMetier(FacadeMetier metier) throws PresenterException {
        if(Objects.isNull(metier)){
            throw new PresenterException("ERR: le métier vaut NULL");
        }
        this.metier = metier;
    }

    public Presenter(Ihm vue, FacadeMetier metier) throws PresenterException {
        setVue(vue);
        setMetier(metier);
    }

    public void exec() throws FacadeMetierException, ScoreException, EquipageException, JoueurException, AbstractPersonneException, CoordonneeException {
        vue.afficher(">>début de la chasse au trésor");
        //Affichage de la carte
        Carte uneCarte = metier.getChasse().getLaCarte();
        OutilsIhm.afficherCarte(vue,uneCarte);

        //Deplacement des joueurs, chacun leur tour
        //JQA trouver le tresor

        //ATTENTION:
        // le joueur1 part de 0,0 et descendra
        //le joueur2 part de 9,9 et remonteraa
        boolean tresor=false;
        int ctrPassage=0;
        int noJoueurGagnant=-1;
        do{
            //chaque passage +1
            ctrPassage++;

            for (int noj = 0; noj <C.NB_JOUEUR ; noj++) {

                //recupérer les infos du joueur: identite, noLigne
                String identite = metier.getIdentiteJoueur(noj);
                int ligneCourante = metier.getLigneJoueur(noj);
                OutilsIhm.afficherUnPassage(vue,ctrPassage,identite,ligneCourante);

                //TRT PRINCIPAL
                char c = metier.deplacerUnJoueur(noj);

                //tresor = (TypeCase.TRESOR.getSymbole()==c);
                if((TypeCase.TRESOR.getSymbole()==c)){
                    noJoueurGagnant = noj;
                    tresor = true;
                    noj = C.NB_JOUEUR;
                }
            }

        }while(!tresor);

        //Affichage des résultats
        int[] tabPas = metier.getLesPasDesJoueurs();
        int[] tabPv = metier.getLesPointVieJoueurs();

        OutilsIhm.afficherLesResultats(vue, tabPas,tabPv, noJoueurGagnant);

        //BONUS
        Coordonnee coordT = metier.getCoordonneesTresor(noJoueurGagnant);

        OutilsIhm.afficherCoordonneesTresor(vue,coordT);


    }
}
