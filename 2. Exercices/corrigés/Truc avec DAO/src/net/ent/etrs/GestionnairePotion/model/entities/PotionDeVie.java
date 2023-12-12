package net.ent.etrs.GestionnairePotion.model.entities;

import net.ent.etrs.GestionnairePotion.model.exceptions.PotionDeVieException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionException;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;
import net.ent.etrs.GestionnairePotion.model.references.ConstMetier;
import net.ent.etrs.GestionnairePotion.model.references.Contenant;

import java.util.*;

public class PotionDeVie extends Potion {
    /* ******************************** VARIABLES ******************************** */
    private final List<Ingredient> ingredientList = new ArrayList<>();
    /* ******************************* CONSTRUCTOR ******************************* */
    protected PotionDeVie(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }

    /* ********************************* GETTERS ********************************* */
    @Override
    public String getEffet() {
        if (!isReady()){
            return ConstMetier.POTION_NOT_READY;
        }else {
            return String.format("la potion vous rendra %d points de vie", getValeurEffet());
        }
    }

    public List<Ingredient> getIngredientList() {
        return Collections.unmodifiableList(ingredientList);
    }
    /* ********************************* SETTERS ********************************* */

    /* ******************************** FONCTIONS ******************************** */
    @Override
    public void ajouterIngredient(Ingredient ingredientAjoute) throws PotionDeVieException {
        if (Objects.isNull(ingredientAjoute)){
            throw new PotionDeVieException(ConstErrMsg.POTION_INGREDIENT_NULL);
        }
        if (ingredientList.size() >= ConstMetier.POTION_VIE_MAX_INGREDIENT){
            throw new PotionDeVieException(ConstErrMsg.POTION_INGREDIENT_MAX_ATTEINT);
        }
        switch (ingredientAjoute.getNature()){
            case GAZEUX:
                throw new PotionDeVieException(ConstErrMsg.VIE_INGREDIENT_GAZEUX);
            case ANIMAL :
            case LIQUIDE:
            case PLANTE:
                verifierSiNatureDejaDansPotion(ingredientAjoute);
                break;
            default :
                throw new PotionDeVieException(ConstErrMsg.POTION_INGREDIENT_NATURE_INCONNU);
        }
    }

    @Override
    public boolean isReady() {
        return ingredientList.size() == ConstMetier.POTION_VIE_MAX_INGREDIENT;
    }

    /* **************************** PRIVATE FUNCTIONS **************************** */
    private int getValeurEffet(){
        int nbIngrMag =0;
        for (Ingredient ingr: ingredientList) {
            if (ingr.isEstMagique()){
                nbIngrMag++;
            }
        }
        Random rand = new Random();
        return super.getVolume()*(nbIngrMag+1)*rand.nextInt(ConstMetier.VIE_EFFET_BAS, ConstMetier.VIE_EFFET_HAUT+1);
    }

    private void verifierSiNatureDejaDansPotion(Ingredient ingredientAjoute) throws PotionDeVieException {
        for (Ingredient ingredient:ingredientList) {
            if (ingredient.getNature() == ingredientAjoute.getNature()) {
                throw new PotionDeVieException(ConstErrMsg.VIE_INGREDIENT_NATURE_EXIST);
            }
        }
        ingredientList.add(ingredientAjoute);
    }
}
