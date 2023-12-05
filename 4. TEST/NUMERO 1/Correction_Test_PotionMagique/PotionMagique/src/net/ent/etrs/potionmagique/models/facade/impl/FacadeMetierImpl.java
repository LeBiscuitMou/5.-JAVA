package net.ent.etrs.potionmagique.models.facade.impl;

import net.ent.etrs.potionmagique.models.entities.Ingredient;
import net.ent.etrs.potionmagique.models.entities.Potion;
import net.ent.etrs.potionmagique.models.entities.exceptions.BusinessException;
import net.ent.etrs.potionmagique.models.entities.references.ConstanteMetier;
import net.ent.etrs.potionmagique.models.facade.FacadeMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacadeMetierImpl implements FacadeMetier {

    List<Potion> lesPotions = new ArrayList<>();
    List<Ingredient> lesIngredients = new ArrayList<>();

    @Override
    public List<Potion> afficherLesPotions() {
        return Collections.unmodifiableList(this.lesPotions);
    }

    @Override
    public void supprimerPotion(Potion laPotion) throws BusinessException {
        if (null == laPotion) {
            throw new BusinessException(ConstanteMetier.FACADE_POTION_NULL);
        }
        if (!this.lesPotions.contains(laPotion)) {
            throw new BusinessException(ConstanteMetier.FACADE_POTION_NOT_EXIST);
        }
        this.lesPotions.remove(laPotion);
    }

    @Override
    public void supprimerToutesLesPotions() {
        this.lesPotions = new ArrayList<>();
    }

    @Override
    public Potion creerPotion(Potion laPotion) throws BusinessException {
        if (null == laPotion) {
            throw new BusinessException(ConstanteMetier.FACADE_POTION_NULL);
        }
        if (this.lesPotions.contains(laPotion)) {
            throw new BusinessException(ConstanteMetier.FACADE_POTION_EXIST);
        }
        this.lesPotions.add(laPotion);
        return laPotion;
    }

    @Override
    public List<Ingredient> afficherLesIngredients() {
        return Collections.unmodifiableList(this.lesIngredients);
    }

    @Override
    public void supprimerIngredient(Ingredient lIngredient) throws BusinessException {
        if (null == lIngredient) {
            throw new BusinessException(ConstanteMetier.FACADE_INGREDIENT_NULL);
        }
        if (!this.lesPotions.contains(lIngredient)) {
            throw new BusinessException(ConstanteMetier.FACADE_INGREDIENT_NOT_EXIST);
        }
        this.lesIngredients.remove(lIngredient);
    }

    @Override
    public Ingredient creerIngredient(Ingredient lIngredient) throws BusinessException {
        if (null == lIngredient) {
            throw new BusinessException(ConstanteMetier.FACADE_INGREDIENT_NULL);
        }
        if (this.lesPotions.contains(lIngredient)) {
            throw new BusinessException(ConstanteMetier.FACADE_INGREDIENT_EXIST);
        }
        this.lesIngredients.add(lIngredient);
        return lIngredient;
    }
}
