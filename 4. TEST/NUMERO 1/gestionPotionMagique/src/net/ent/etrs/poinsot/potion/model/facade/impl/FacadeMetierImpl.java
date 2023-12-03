package net.ent.etrs.poinsot.potion.model.facade.impl;

import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;
import net.ent.etrs.poinsot.potion.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.potion.model.facade.impl.exceptions.FacadeMetierException;
import net.ent.etrs.poinsot.potion.model.references.ConstanteMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements FacadeMetier {
    private List<Potion> persistanceListePotions = new ArrayList<>();
    private List<Ingredient> persistanceListeIngredients = new ArrayList<>();

    @Override
    public void supprimerIngredient(Ingredient ingredient) throws FacadeMetierException {
        if (Objects.isNull(ingredient)) {
            throw new FacadeMetierException(ConstanteMetier.INGREDIENT_IS_NULL);
        }
        if (!this.persistanceListeIngredients.contains(ingredient)) {
            throw new FacadeMetierException(ConstanteMetier.INGREDIENT_NOT_EXIST);
        }
        this.persistanceListeIngredients.remove(ingredient);
    }

    @Override
    public void supprimerPotion(Potion potion) throws FacadeMetierException {
        if (Objects.isNull(potion)) {
            throw new FacadeMetierException(ConstanteMetier.POTION_IS_NULL);
        }
        if (!this.persistanceListePotions.contains(potion)) {
            throw new FacadeMetierException(ConstanteMetier.POTION_NOT_EXIST);
        }
        this.persistanceListePotions.remove(potion);
    }

    @Override
    public void supprimerToutesLesPotions() throws FacadeMetierException {
        if (persistanceListePotions.isEmpty()) {
            throw new FacadeMetierException(ConstanteMetier.LISTE_POTIONS_VIDE);
        }
        this.persistanceListePotions.clear();
    }

    @Override
    public Ingredient creerIngredient(Ingredient ingredient) throws FacadeMetierException {
        if (Objects.isNull(ingredient)) {
            throw new FacadeMetierException(ConstanteMetier.INGREDIENT_IS_NULL);
        }
        if (persistanceListeIngredients.contains(ingredient)) {
            throw new FacadeMetierException(ConstanteMetier.INGREDIENT_EXISTE_DEJA);
        }
        this.persistanceListeIngredients.add(ingredient);
        return ingredient;
    }

    @Override
    public List<Ingredient> afficherLesIngredients() {
        return Collections.unmodifiableList(persistanceListeIngredients);
    }

    @Override
    public List<Potion> afficherLesPotions() {
        return Collections.unmodifiableList(persistanceListePotions);
    }

    @Override
    public Potion creerPotion(Potion potion) throws FacadeMetierException {
        if (Objects.isNull(potion)) {
            throw new FacadeMetierException(ConstanteMetier.INGREDIENT_IS_NULL);
        }
        if (persistanceListePotions.contains(potion)) {
            throw new FacadeMetierException(ConstanteMetier.POTION_EXISTE_DEJA);
        }
        this.persistanceListePotions.add(potion);
        return potion;
    }
}