package net.ent.etrs.GestionnairePotion.model.facades;

import net.ent.etrs.GestionnairePotion.model.entities.Ingredient;
import net.ent.etrs.GestionnairePotion.model.entities.Potion;
import net.ent.etrs.GestionnairePotion.model.exceptions.FacadeMetierImplException;

import java.util.List;

public interface FacadeMetier {

    void supprimerIngredient(Ingredient ingredientASupprimer) throws FacadeMetierImplException;

    void supprimerPotion(Potion potionASupprimer) throws FacadeMetierImplException;

    void supprimerToutesLesPotions() throws FacadeMetierImplException;

    void creerIngredient(Ingredient ingredientAAjouter) throws FacadeMetierImplException;

    List<Ingredient> selectionnerTousLesIngredient() throws FacadeMetierImplException;

    List<Potion> selectionnerTousLesPotion() throws FacadeMetierImplException;

    void creerPotion(Potion potionAAjouter) throws FacadeMetierImplException;
}
