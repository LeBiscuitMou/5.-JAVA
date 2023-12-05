package net.ent.etrs.potionmagique.view.facade.impl;

import net.ent.etrs.potionmagique.models.entities.*;
import net.ent.etrs.potionmagique.models.entities.exceptions.BusinessException;
import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.entities.references.Contenant;
import net.ent.etrs.potionmagique.models.entities.references.Nature;
import net.ent.etrs.potionmagique.view.commons.utils.AffichageConsole;
import net.ent.etrs.potionmagique.view.commons.utils.LectureConsole;
import net.ent.etrs.potionmagique.view.facade.FacadeView;

import java.util.ArrayList;
import java.util.List;

public class FacadeViewImpl implements FacadeView {


    /**
     * Permet d'afficher un message à l'utilisateur
     *
     * @param message le message à afficher
     */
    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    /**
     * Permet d'afficher un message d'erreur à l'utilisateur
     *
     * @param message le message d'erreur à afficher
     */
    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

    /**
     * Permet d'afficher le menu principal de l'application
     *
     * @return le choix effectué par l'utilisateur
     */
    @Override
    public int afficherMenuPrincipal() {
        List<String> menu = new ArrayList<>();
        menu.add("Afficher toutes les potions");
        menu.add("Afficher tous les ingrédients");
        menu.add("Créer une potion");
        menu.add("Créer un ingrédient");
        menu.add("Supprimer une potion");

        AffichageConsole.afficherMenuSimpleAvecOptionSortie(menu, "Quitter");
        return LectureConsole.lectureChoixInt(0, menu.size());
    }

    /**
     * Permet d'afficher toutes les potions
     *
     * @param lesPotions les potions à afficher
     */
    @Override
    public void afficherToutesLesPotions(List<Potion> lesPotions) {
        for (Potion p : lesPotions) {
            AffichageConsole.afficherMessageAvecSautLigne("- Potion : " + p.getNom() + " Effets : " + p.effectPotion());
            AffichageConsole.afficherMessageAvecSautLigne("Contient les ingrédients suivants :");
            for (Ingredient i : p.getLesIngredients()) {
                AffichageConsole.afficherMessageAvecSautLigne("\t* " + i.getNom() + " Nature : " + i.getTypeIngredient());
            }
        }
    }

    /**
     * Permet d'afficher tous les ingrédients existant
     *
     * @param lesIngredients les ingrédients à afficher
     */
    @Override
    public void afficherLesIngredients(List<Ingredient> lesIngredients) {
        for (Ingredient i : lesIngredients) {
            AffichageConsole.afficherMessageAvecSautLigne("- Ingrédient : " + i.getNom() + " / Type : " + i.getTypeIngredient()
                    + " / Est Magique : " + (i.isEstMagique() ? "Oui" : "Non"));
        }
    }


    /**
     * Permet de créer une potions
     *
     * @return la potion créée
     */
    @Override
    public Potion creerUnePotion() throws BusinessException {

        Potion retour = null;
        String nom = LectureConsole.lectureChaineCaracteres("Saisissez le nom de la potion : ");
        Integer volume = LectureConsole.lectureEntier("Saisisseez le volume de la potion : ");
        Contenant contenant = selectionnerContenantPotion();

        switch (selectionnerTypePotion()) {
            case "PotionAmelioration":
                retour = EntitiesFactory.fabriquerPotionAmelioration(nom, volume, contenant);

                break;
            case "PotionDegat":
                retour = EntitiesFactory.fabriquerPotionDegat(nom, volume, contenant);
                break;
            case "PotionVie":
                retour = EntitiesFactory.fabriquerPotionVie(nom, volume, contenant);
                break;

        }

        return retour;
    }

    /**
     * Permet de selectionner la potion à supprimer
     *
     * @return la potion à supprimer
     */
    @Override
    public Potion supprimerUnePotion(List<Potion> potions) {
        List<String> listNomPotion = new ArrayList<>();
        for (Potion i : potions) {
            listNomPotion.add(i.getNom());
        }
        AffichageConsole.afficherMenuSimple(listNomPotion);
        return potions.get(LectureConsole.lectureChoixInt(0, listNomPotion.size() - 1));
    }

    /**
     * Permet de créer un ingrédient
     *
     * @return l'ingrédient créé
     */
    @Override
    public Ingredient creerUnIngredient() throws BusinessException {
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de l'ingrédient");
        boolean estMagique = LectureConsole.lectureBoolean("Es ce que l'ingrédient est magique");
        int poids;
        do {
            poids = LectureConsole.lectureEntier("Quel est le poids de l'ingrédient ?");
            if (poids <= 0) {
                AffichageConsole.afficherMessageAvecSautLigne("le poids ne peut pas être négatif ou égal à 0");
            }
        } while (poids <= 0);

        Nature nature = selectionnerNatureIngredient();

        return EntitiesFactory.fabriquerIngredient(nom, estMagique, poids, nature);
    }


    /**
     * Permet d'ajouter un ingredient à une potion
     *
     * @param laPotion    la potion a modifiée
     * @param lIngredient l'ingrédient à ajouter
     * @return la potion modifiée
     */
    @Override
    public Potion ajouterUnIngredient(Potion laPotion, Ingredient lIngredient) throws PotionException {
        AffichageConsole.afficherMessageAvecSautLigne("Selectionner un Ingrédient : ");
        laPotion.ajouterIngredient(lIngredient);
        return laPotion;
    }

    /**
     * Permet de choisir un ingredient
     *
     * @param lesIngredients les ingrédient possible
     * @return l'ingredient choisi
     */
    @Override
    public Ingredient selectionnerIngredient(List<Ingredient> lesIngredients) {
        List<String> listNomIngredient = new ArrayList<>();
        for (Ingredient i : lesIngredients) {
            listNomIngredient.add(i.getNom());
        }
        AffichageConsole.afficherMenuSimple(listNomIngredient);
        return lesIngredients.get(LectureConsole.lectureChoixInt(0, listNomIngredient.size()) - 1);
    }

    /**
     * Permet de selectionner la Nature des ingrédients
     *
     * @return la Nature des ingrédients
     */
    @Override
    public Nature selectionnerNatureIngredient() {
        List<String> listNomNature = new ArrayList<>();
        for (Nature n : Nature.values()) {
            listNomNature.add(n.name());
        }
        AffichageConsole.afficherMenuSimple(listNomNature);
        return Nature.values()[LectureConsole.lectureChoixInt(0, listNomNature.size() - 1) - 1];
    }


    private String selectionnerTypePotion() {
        List<String> listNomTypePotion = new ArrayList<>(List.of(PotionDegat.class.getSimpleName(), PotionVie.class.getSimpleName(), PotionAmelioration.class.getSimpleName()));
        AffichageConsole.afficherMenuSimple(listNomTypePotion);
        return listNomTypePotion.get(LectureConsole.lectureChoixInt(0, listNomTypePotion.size() - 1) - 1);
    }

    private Contenant selectionnerContenantPotion() {
        List<String> listNomContenantPotion = new ArrayList<>();
        for (Contenant c : Contenant.values()) {
            listNomContenantPotion.add(c.name() + " " + c.getVolume());
        }
        AffichageConsole.afficherMenuSimple(listNomContenantPotion);
        return Contenant.values()[LectureConsole.lectureChoixInt(0, listNomContenantPotion.size() - 1) - 1];
    }
}
