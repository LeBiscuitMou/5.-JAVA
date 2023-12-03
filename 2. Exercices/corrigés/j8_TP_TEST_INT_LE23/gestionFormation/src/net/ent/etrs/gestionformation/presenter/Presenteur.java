package net.ent.etrs.gestionformation.presenter;

import net.ent.etrs.gestionformation.models.entities.Cours;
import net.ent.etrs.gestionformation.models.entities.Journee;
import net.ent.etrs.gestionformation.models.entities.Matiere;
import net.ent.etrs.gestionformation.models.entities.UniteValeur;
import net.ent.etrs.gestionformation.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionformation.models.facade.FacadeMetier;
import net.ent.etrs.gestionformation.models.facade.exceptions.BusinessException;
import net.ent.etrs.gestionformation.presenter.exceptions.PresenteurException;
import net.ent.etrs.gestionformation.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionformation.view.facade.FacadeView;
import net.ent.etrs.gestionformation.view.facade.exceptions.FacadeViewException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Presenteur {

    private FacadeView facadeView;

    private  FacadeMetier facadeMetier;

    public Presenteur(FacadeView fv, FacadeMetier fm) throws PresenteurException {
        setFacadeView(fv);
        setFacadeMetier(fm);
    }

    public void setFacadeView(FacadeView facadeView) throws PresenteurException {
        if(Objects.isNull(facadeView)){
            throw new PresenteurException("Impossible de créer la vue");
        }
        this.facadeView = facadeView;
    }

    public void setFacadeMetier(FacadeMetier facadeMetier) throws PresenteurException {
        if(Objects.isNull(facadeMetier)){
            throw new PresenteurException("Impossible de créer le metier");
        }
        this.facadeMetier = facadeMetier;
    }

    private List<String> initMenu(){
        List<String> list = new ArrayList<String>();
        list.add("Créer une Matiere");
        list.add("Ajouter un Cours à une Matière");
        list.add("Afficher les Cours d'une Matière");
        list.add("Créer une Unite de Valeur");
        list.add("Ajouter une Matière à une UV");
        list.add("Afficher les Matières d'une UV");
        list.add("Créer une journée de cours");
        list.add("Afficher une journée de cours");
        list.add("Généré une semaine de cours puis l'Afficher");

        return list;
    }

    public void start() {
        int choix = -1;
        List<String> menuPrincipal = initMenu();
        do {
            facadeView.afficherMenu(menuPrincipal);
            choix = LectureConsole.lectureChoixInt(0,menuPrincipal.size());
            gererChoixMenuPrincipal(choix);

        }while (choix != 0);


    }

    private void gererChoixMenuPrincipal(int choix) {

        switch (choix){
            case 1 -> createMatiere();
            case 2 -> addCoursToMatiere();
            case 3 -> afficherCoursDUneMAtiere();
            case 4 -> createUV();
            case 5 -> addMatiereToUV();
            case 6 -> afficherLesMatiereDUnUV();
            case 7 -> createDay();
            case 8 -> afficherDay();
            case 9 -> genereWeekofUV();
        }

    }

    private void afficherDay() {
        //TODO afficher une journée
    }

    private void createDay() {
        try {
            Journee jour = facadeView.saisirJour();
            UniteValeur uv = facadeView.selectionnerUV(facadeMetier.ListerToutesLesUV());
            boolean jourFini = false;
            do{
                facadeView.afficherMessage("Selectionner la matiere :");
                Matiere matiere = facadeView.selectionnerMatière(uv.getLesMatieres());
                facadeView.afficherMessage("Selectionner le cours à ajouter :");
                Cours c = facadeView.selectionnerCours(matiere.getLesCours());
                jour = facadeView.ajouterCours(c,jour);
                jourFini = facadeMetier.journeeComplete(jour);
            }while (jourFini);
        facadeView.afficherMessage(jour.toString());
        } catch (FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherLesMatiereDUnUV() {
        try {
           UniteValeur uv = facadeView.selectionnerUV(facadeMetier.ListerToutesLesUV());
            List<Matiere> matiereList = facadeMetier.ListerToutesLesMatiereDuneUV(uv);
            facadeView.afficherMatiereOfUV(matiereList);
        } catch (FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    private void afficherCoursDUneMAtiere() {
        try {
            Matiere matiere = facadeView.selectionnerMatière(facadeMetier.ListerTouteslesMatiere());
            List<Cours> lesCours = facadeMetier.ListerTouslesCoursDuneMatiere(matiere);
            facadeView.afficherCoursOfMatiere(lesCours);
        } catch (FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }

    }


    private void genereWeekofUV() {
        try {
            UniteValeur uv = facadeView.selectionnerUV(facadeMetier.ListerToutesLesUV());
            List<Journee> semaine = facadeMetier.genererSemaine(uv);
            facadeView.afficherSemaine(semaine);
        } catch (FacadeViewException | EntitiesFactoryException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void addMatiereToUV() {
        try {
            UniteValeur uv = facadeView.selectionnerUV(facadeMetier.ListerToutesLesUV());

            boolean continuer;
            do{
                Matiere matiere = facadeView.selectionnerMatière(facadeMetier.ListerTouteslesMatiere());
                continuer = LectureConsole.lectureBoolean("Souhaitez vous ajouter une autre matiere ?");
                facadeMetier.ajouterUneMatiereAUneUV(uv,matiere);
            }while (continuer);
        } catch (FacadeViewException | BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void createUV() {
        try {
        UniteValeur uv = facadeView.saisirUV();
            facadeMetier.creerUV(uv);
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }

    }

    private void addCoursToMatiere() {
        try {
            Matiere matiere = facadeView.selectionnerMatière(facadeMetier.ListerTouteslesMatiere());

        boolean continuer = false;
        do{
            Cours c = facadeView.saisirCours(matiere);
            facadeMetier.ajouterUnCoursAUneMatiere(matiere,c);
            continuer = LectureConsole.lectureBoolean("Souhaitez vous ajouter un autre cours ?");

        }while (continuer);
        } catch (FacadeViewException | BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void createMatiere() {

        try {
            Matiere m = facadeView.saisirMatiere();
            facadeMetier.creerMatiere(m);
        } catch (BusinessException | FacadeViewException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }
}
