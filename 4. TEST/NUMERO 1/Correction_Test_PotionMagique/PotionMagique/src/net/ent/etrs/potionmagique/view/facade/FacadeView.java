package net.ent.etrs.potionmagique.view.facade;

import net.ent.etrs.potionmagique.models.entities.Ingredient;
import net.ent.etrs.potionmagique.models.entities.Potion;
import net.ent.etrs.potionmagique.models.entities.exceptions.BusinessException;
import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.entities.references.Nature;

import java.util.List;

public interface FacadeView {

    /**
     * Permet d'afficher un message à l'utilisateur
     *
     * @param message le message à afficher
     */
    void afficherMessage(String message);

    /**
     * Permet d'afficher un message d'erreur à l'utilisateur
     *
     * @param message le message d'erreur à afficher
     */
    void afficherMessageErreur(String message);

    /**
     * Permet d'afficher le menu principal de l'application
     *
     * @return le choix effectué par l'utilisateur
     */
    int afficherMenuPrincipal();

    /**
     * Permet d'afficher toutes les potions
     *
     * @param lesPotions les potions à afficher
     */
    void afficherToutesLesPotions(List<Potion> lesPotions);

    /**
     * Permet d'afficher tous les ingrédients existant
     *
     * @param lesIngredients les ingrédients à afficher
     */
    void afficherLesIngredients(List<Ingredient> lesIngredients);


    /**
     * Permet de créer une potions
     *
     * @return la potion créée
     */
    Potion creerUnePotion() throws BusinessException;

    /**
     * Permet de selectionner la potion à supprimer
     *
     * @param potions les potions qui peuvent être supprimer
     * @return la potion à supprimer
     */
    Potion supprimerUnePotion(List<Potion> potions);

    /**
     * Permet de créer un ingrédient
     *
     * @return l'ingrédient créé
     */
    Ingredient creerUnIngredient() throws BusinessException;


    /**
     * Permet d'ajouter un ingredient à une potion
     *
     * @param laPotion    la potion a modifiée
     * @param lIngredient l'ingrédient à ajouter
     * @return la potion modifiée
     */
    Potion ajouterUnIngredient(Potion laPotion, Ingredient lIngredient) throws PotionException;

    /**
     * Permet de choisir un ingredient
     *
     * @param lesIngredients les ingrédient possible
     * @return l'ingredient choisi
     */
    Ingredient selectionnerIngredient(List<Ingredient> lesIngredients);

    /**
     * Permet de selectionner la Nature des ingrédients
     *
     * @return la Nature des ingrédients
     */
    Nature selectionnerNatureIngredient();

}
