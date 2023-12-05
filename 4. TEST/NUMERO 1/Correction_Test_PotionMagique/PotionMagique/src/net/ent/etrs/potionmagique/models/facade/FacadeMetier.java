package net.ent.etrs.potionmagique.models.facade;

import net.ent.etrs.potionmagique.models.entities.Ingredient;
import net.ent.etrs.potionmagique.models.entities.Potion;
import net.ent.etrs.potionmagique.models.entities.exceptions.BusinessException;

import java.util.List;

public interface FacadeMetier {


    List<Potion> afficherLesPotions();

    void supprimerPotion(Potion laPotion) throws BusinessException;

    void supprimerToutesLesPotions();

    Potion creerPotion(Potion laPotion) throws BusinessException;

    List<Ingredient> afficherLesIngredients();

    void supprimerIngredient(Ingredient lIngredient) throws BusinessException;

    Ingredient creerIngredient(Ingredient lIngredient) throws BusinessException;
}
