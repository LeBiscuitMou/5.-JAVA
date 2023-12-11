package net.ent.etrs.GestionnairePotion.presenter;

import net.ent.etrs.GestionnairePotion.model.entities.EntitiesFactory;
import net.ent.etrs.GestionnairePotion.model.entities.Ingredient;
import net.ent.etrs.GestionnairePotion.model.entities.Potion;
import net.ent.etrs.GestionnairePotion.model.exceptions.*;
import net.ent.etrs.GestionnairePotion.model.facades.FacadeMetier;
import net.ent.etrs.GestionnairePotion.model.references.Nature;
import net.ent.etrs.GestionnairePotion.presenter.exceptions.PresenteurException;
import net.ent.etrs.GestionnairePotion.presenter.references.ConstPresenteur;
import net.ent.etrs.GestionnairePotion.vues.facades.FacadeVue;
import net.ent.etrs.GestionnairePotion.vues.references.ConstVue;

import java.util.Objects;

public class Presenteur {
    /* ******************************** VARIABLES ******************************** */
    private FacadeMetier fMet;
    private FacadeVue fVue;
    /* ******************************* CONSTRUCTOR ******************************* */
    protected Presenteur(FacadeMetier fMet, FacadeVue fVue) throws PresenteurException {
        this.setFMet(fMet);
        this.setFVue(fVue);
    }
    /* ********************************* GETTERS ********************************* */

    /* ********************************* SETTERS ********************************* */
    private void setFMet(FacadeMetier fMet) throws PresenteurException {
        if(Objects.isNull(fMet)){
            throw new PresenteurException(ConstPresenteur.ERROR_FACADE_METIER_NULL);
        }
        this.fMet = fMet;
    }

    public void setFVue(FacadeVue fVue) throws PresenteurException {
        if(Objects.isNull(fVue)){
            throw new PresenteurException(ConstPresenteur.ERROR_FACADE_VUE_NULL);
        }
        this.fVue = fVue;
    }

    /* ******************************** FONCTIONS ******************************** */
    public void exec(){
        information();
        routineInitialisation();
        boolean quitter = false;
        do {
            int choixMenu = fVue.afficherMenuPrincipal();
            switch (choixMenu){
                case 1 :
                    afficherLesPotions();
                    break;
                case 2 :
                    afficherLesIngredients();
                    break;
                case 3 :
                    creerPotion();
                    break;
                case 4 :
                    creerIngredient();
                    break;
                case 5 :
                    supprimerPotion();
                    break;
                case 0 :
                    System.out.println("sortie du menu");
                    quitter = true;
                    break;
                default:
                    break;
            }
        }while (!quitter);
    }

    /* **************************** PRIVATE FUNCTIONS **************************** */
    private void afficherLesPotions() {
        try {
            fVue.afficherToutesLesPotions(fMet.selectionnerTousLesPotion());
        } catch (FacadeMetierImplException e) {
            fVue.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherLesIngredients() {
        try {
            fVue.afficherLesIngredients(fMet.selectionnerTousLesIngredient());
        } catch (FacadeMetierImplException e) {
            fVue.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerPotion() {
        try {
            Potion potion = fVue.creerUnePotion();
            while(!potion.isReady()){
                fVue.afficherMessage(ConstVue.CHOIX_INGREDIENT_POUR_POTION_MESSAGE);
                Ingredient ingr = fVue.selectionnerIngredient(fMet.selectionnerTousLesIngredient());
                try {
                    potion.ajouterIngredient(ingr);
                } catch (PotionDeDegatException | PotionDeVieException | PotionAmeliorationException e) {
                    fVue.afficherMessageErreur(e.getMessage());
                }
            }
            fMet.creerPotion(potion);
        } catch (FacadeMetierImplException e) {
            fVue.afficherMessageErreur(e.getMessage());
        }
    }

    private void creerIngredient() {
        try {
            fMet.creerIngredient(fVue.creerUnIngredient());
        } catch (FacadeMetierImplException e) {
            fVue.afficherMessageErreur(e.getMessage());
        }
    }

    private void supprimerPotion(){
        try {
            fMet.supprimerPotion(fVue.supprimerUnePotion(fMet.selectionnerTousLesPotion()));
        } catch (FacadeMetierImplException e) {
            fVue.afficherMessageErreur(e.getMessage());
        }
    }

    /**
     * Crée des ingrédients par défaut pour éviter d'être bloqué lors de la création de potion si aucun ingrédient n'a été créé.
     */
    private void routineInitialisation(){
        try {
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("Os de poulet", false, 10, Nature.ANIMAL));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("Os de dragon", true, 200, Nature.ANIMAL));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("chair de dragon", true, 50, Nature.ANIMAL));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("coca cola", false, 10, Nature.LIQUIDE));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("ice tea pêche", false, 10, Nature.LIQUIDE));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("Oasis tropical", false, 10, Nature.LIQUIDE));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("argon", false, 1, Nature.GAZEUX));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("gaz 1", false, 1, Nature.GAZEUX));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("gaz magique", true, 1, Nature.GAZEUX));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("mandragore", true, 10, Nature.PLANTE));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("belladone", false, 10, Nature.PLANTE));
            fMet.creerIngredient(EntitiesFactory.fabriquerIngredient("mauvaise herbe", false, 10, Nature.PLANTE));
        } catch (FacadeMetierImplException | EntitiesException e) {
            fVue.afficherMessageErreur(e.getMessage());
        }
    }

    private void information(){
        fVue.afficherMessage("Le roi arthur fu tué en l'an de grâce 535, ou peut-être en l'an de grâce 542");
    }
}
