package net.ent.etrs.CatalogueJeuVideo.presenter;

import net.ent.etrs.CatalogueJeuVideo.model.entities.Console;
import net.ent.etrs.CatalogueJeuVideo.model.entities.JeuVideo;
import net.ent.etrs.CatalogueJeuVideo.model.entities.comparator.JeuParGenresComparator;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.BusinessException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.ConsoleException;
import net.ent.etrs.CatalogueJeuVideo.model.facades.FacadeMetier;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstErrMsg;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstMetier;
import net.ent.etrs.CatalogueJeuVideo.model.references.Genre;
import net.ent.etrs.CatalogueJeuVideo.model.references.Pays;
import net.ent.etrs.CatalogueJeuVideo.presenter.exceptions.PresenteurException;
import net.ent.etrs.CatalogueJeuVideo.views.commons.utils.LectureConsole;
import net.ent.etrs.CatalogueJeuVideo.views.exceptions.ViewException;
import net.ent.etrs.CatalogueJeuVideo.views.facades.FacadeView;
import net.ent.etrs.CatalogueJeuVideo.views.references.ConstView;

import java.time.LocalDate;
import java.util.*;

public class Presenteur {
    /* ******************************** VARIABLES ******************************** */
    private FacadeMetier fMet;
    private FacadeView fVue;
    /* ******************************* CONSTRUCTOR ******************************* */
    protected Presenteur(FacadeMetier fMet, FacadeView fVue) throws PresenteurException {
        this.setFMet(fMet);
        this.setFVue(fVue);
    }
    /* ********************************* GETTERS ********************************* */

    /* ********************************* SETTERS ********************************* */
    private void setFMet(FacadeMetier fMet) throws PresenteurException {
        if(Objects.isNull(fMet)){
            throw new PresenteurException(ConstErrMsg.FACADE_METIER_NULL);
        }
        this.fMet = fMet;
    }

    public void setFVue(FacadeView fVue) throws PresenteurException {
        if(Objects.isNull(fVue)){
            throw new PresenteurException(ConstErrMsg.FACADE_VUE_NULL);
        }
        this.fVue = fVue;
    }

    /* ******************************** FONCTIONS ******************************** */
    public void exec(){
        initialiser();
        boolean quitter = false;
        do {
            int choixMenu = fVue.lectureChoix(fVue.afficherMenuPrincipal().size());
            switch (choixMenu){
                case 1 :
                    creerConsole();
                    break;
                case 2 :
                    creerFabriquant();
                    break;
                case 3 :
                    creerJeuVideo();
                    break;
                case 4 :
                    ajouterConsoleAUnJeuVideo();
                    break;
                case 5 :
                    afficherJeuVideoDUnGenre();
                    break;
                case 6 :
                    afficherJeuVideoParConsole();
                    break;
                case 7 :
                    afficherToutesConsolesAvecLeursJeu();
                    break;
                case 8 :
                    fVue.afficherMessage(ConstView.MESSAGE_SORTIE_PROGRAMME);
                    quitter = true;
                    break;
                default:
                    break;
            }
        }while (!quitter);
    }



    /* **************************** PRIVATE FUNCTIONS **************************** */
    private void creerConsole() {
        try {
            Console console = fVue.saisirConsole(fMet.recupererFabriquants());

            fVue.afficherMessage("voulez vous ajouter une date de sortie de cette console ?");
            boolean quitter = fVue.lectureChoixBoolean();
            while (!quitter) {
                List<Pays> paysPasChoisis = new ArrayList<>(List.of(Pays.values()));
                paysPasChoisis.removeAll(console.getSorties().keySet());
                Pays pays = fVue.selectionnerPays(paysPasChoisis);
                LocalDate date = LectureConsole.lectureLocalDate("la date de sortie ?:", ConstMetier.DATE_PATTERN);

                console.setSortiePays(pays, date);

                fVue.afficherMessage("voulez vous ajouter une date de sortie de cette console ?");
                quitter = fVue.lectureChoixBoolean();
            }
            fMet.sauvegarderConsole(console);
        } catch (BusinessException | ViewException | ConsoleException e) {
            fVue.afficherMessageErreur(e);
        }
    }

    private void creerJeuVideo() {
        try {
            JeuVideo jeu = fVue.saisirJeuVideo(fMet.recupererFabriquants());

            fVue.afficherMessage("voulez vous ajouter une console à ce jeu ?");
            boolean quitter = fVue.lectureChoixBoolean();
            while (!quitter) {
                jeu = fVue.ajouterConsoleJeuVideo(jeu, fMet.recupererConsole());
                fVue.afficherMessage("voulez vous ajouter une autre console à ce jeu ?");
                quitter = fVue.lectureChoixBoolean();
            }
            fMet.sauvergarderJeuVideo(jeu);
        } catch (BusinessException | ViewException e) {
            fVue.afficherMessageErreur(e);
        }
    }

    private void creerFabriquant() {
        try {
            fMet.sauvegarderFabriquant(fVue.saisirFabricant());
        } catch (BusinessException | ViewException e) {
            fVue.afficherMessageErreur(e);
        }
    }

    private void ajouterConsoleAUnJeuVideo() {
        try {
            JeuVideo jeu = fVue.selectionnerJeuVideo(fMet.recupererJeuVideo());
            fVue.ajouterConsoleJeuVideo(jeu, fMet.recupererConsole());
            fMet.modifierJeuVideo(jeu);
            fVue.afficherMessage("le jeu vidéo à était mis à jour avec succès");
        } catch (BusinessException | ViewException e) {
            fVue.afficherMessageErreur(e);
        }
    }

    /**
     * Afficher les jeux video par un Genre → trier par ordre naturel
     */
    private void afficherJeuVideoDUnGenre() {
        // on demande à l'utilisateur de choisir le genre.
        Genre genre = fVue.selectionnerGenre(List.of(Genre.values()));
        try {
            // on récupère les jeux ayant le genre choisi.
            List<JeuVideo> list = new ArrayList<>(fMet.recupererJeuVideoParGenre(genre));
            if(list.isEmpty()){
                fVue.afficherMessage("pas de jeu trouvé ayant le genre " + genre.toString());
            }else {
                // on trie les jeux selon l'ordre naturel.
                Collections.sort(list);
                // on affiche le tout
                fVue.afficherJeuVideo(list);
            }
        } catch (BusinessException e) {
            fVue.afficherMessageErreur(e);
        }
    }

    /**
     * Afficher les jeux video par Console → trier par Genre
     */
    private void afficherJeuVideoParConsole() {
        try {
            Map<Console, List<JeuVideo>> map = fMet.recupererConsoleAvecLeurJeuxVideo();
            // on vire les consoles qui n'ont pas de jeu.
            for(Console console : map.keySet()){
                if(map.get(console).isEmpty()){
                    map.remove(console);
                }
            }
            // on trie par genres (grace à mon comparator "JeuParGenresComparator"
            for(List<JeuVideo> list : map.values()){
                list.sort(new JeuParGenresComparator());
            }
            // on affiche ce qui reste.
            fVue.afficherConsoleAvecJeuVideo(map);
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Afficher toutes les Consoles avec leurs jeux video
     */
    private void afficherToutesConsolesAvecLeursJeu() {
        try {
            fVue.afficherJeuVideo(fMet.recupererJeuVideo());
            fVue.afficherConsoleAvecJeuVideo(fMet.recupererConsoleAvecLeurJeuxVideo());
        } catch (BusinessException e) {
            fVue.afficherMessageErreur(e);
        }
    }


    private void initialiser() {
        List<String> lstInit = new ArrayList<>();
        lstInit.add("JEU;Diablo IV;05/06/2023;HNS;BLIZZARD;08/02/1991;USA");
        lstInit.add("JEU;Overwatch;24/05/2016;Strategie;BLIZZARD;08/02/1991;USA");
        lstInit.add("JEU;Overwatch 2;04/10/2022;MMORPG;BLIZZARD;08/02/1991;USA");
        lstInit.add("JEU;League of Legends;27/10/2009;MOBA;Riot Games;22/09/2006;USA");
        lstInit.add("JEU;Valorant;02/06/2020;FPS;Riot Games;22/09/2006;USA");

        lstInit.add("CONSOLE;Playstation;SONY;16/11/1993;USA;JAPON;03/12/1994;USA;09/09/1995;FRANCE;29/09/1995");
        lstInit.add("CONSOLE;PS One;SONY;16/11/1993;USA;JAPON;14/07/2000;USA;19/09/2000;FRANCE;29/09/2000");
        lstInit.add("CONSOLE;PS 4;SONY;16/11/1993;USA;JAPON;22/02/2014;USA;15/11/2013;FRANCE;29/11/2013");
        lstInit.add("CONSOLE;PS 5;SONY;16/11/1993;USA;JAPON;12/11/2020;USA;12/11/2020;FRANCE;19/11/2020");
        lstInit.add("CONSOLE;Xbox Series X;Microsoft;04/04/1975;USA;JAPON;10/11/2020;USA;10/11/2020;FRANCE;10/11/2020");
        lstInit.add("CONSOLE;Xbox One;Microsoft;04/04/1975;USA;JAPON;04/09/2014;USA;22/11/2013;FRANCE;22/11/2013");

        try {
            this.fMet.initialisation(lstInit);
        } catch (BusinessException e) {
            fVue.afficherMessageErreur(e.getMessage());
        }

    }
}
