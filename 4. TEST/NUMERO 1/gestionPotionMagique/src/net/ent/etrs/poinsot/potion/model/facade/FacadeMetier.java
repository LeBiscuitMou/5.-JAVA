package net.ent.etrs.poinsot.potion.model.facade;

import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;
import net.ent.etrs.poinsot.potion.model.facade.impl.exceptions.FacadeMetierException;

import java.util.List;

public interface FacadeMetier {
    void supprimerIngredient(Ingredient ingredient) throws FacadeMetierException;
    void supprimerPotion(Potion potion) throws FacadeMetierException;
    void supprimerToutesLesPotions() throws FacadeMetierException;
    Ingredient creerIngredient(Ingredient ingredient) throws FacadeMetierException;
    List<Ingredient> afficherLesIngredients();
    List<Potion> afficherLesPotions();
    Potion creerPotion(Potion potion) throws FacadeMetierException;
}
