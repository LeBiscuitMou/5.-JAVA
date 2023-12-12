package net.ent.etrs.GestionnairePotion.model.entities;

import net.ent.etrs.GestionnairePotion.model.exceptions.IngredientException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionAmeliorationException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionDeDegatException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionException;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;
import net.ent.etrs.GestionnairePotion.model.references.ConstMetier;
import net.ent.etrs.GestionnairePotion.model.references.Contenant;
import net.ent.etrs.GestionnairePotion.model.references.Nature;

import java.util.*;

public class PotionDeDegat extends Potion {
    /* ******************************** VARIABLES ******************************** */
    private final List<Ingredient> ingredientList = new ArrayList<>();
    /* ******************************* CONSTRUCTOR ******************************* */
    protected PotionDeDegat(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }
    /* ********************************* GETTERS ********************************* */
    @Override
    public String getEffet() throws PotionDeDegatException {
        if (!isReady()){
            return ConstMetier.POTION_NOT_READY;
        }else {
            return String.format("la potion infligera %d points de dégat de %s", getValeurEffet(), getTypeDegat());
        }
    }

    public List<Ingredient> getIngredientList() {
        return Collections.unmodifiableList(ingredientList);
    }
    /* ********************************* SETTERS ********************************* */

    /* ******************************** FONCTIONS ******************************** */
    @Override
    public void ajouterIngredient(Ingredient ingredientAjoute) throws PotionDeDegatException {
        if (Objects.isNull(ingredientAjoute)){
            throw new PotionDeDegatException(ConstErrMsg.POTION_INGREDIENT_NULL);
        }
        if (ingredientList.size() >= ConstMetier.POTION_DEGAT_MAX_INGREDIENT){
            throw new PotionDeDegatException(ConstErrMsg.POTION_INGREDIENT_MAX_ATTEINT);
        }
        switch (ingredientAjoute.getNature()){
            case ANIMAL :
                int occA = 0;
                for (Ingredient ingredient:ingredientList) {
                    if (ingredient.getNature() == Nature.ANIMAL) {
                        occA++;
                    }
                }
                if (occA >= ConstMetier.DEGAT_MAX_INGREDIENT_MEME_NATURE){
                    throw new PotionDeDegatException(ConstErrMsg.POTION_INGREDIENT_MAX_MEME_NATURE_ATTEINT);
                }
                ingredientList.add(ingredientAjoute);
                break;
            case GAZEUX:
            case LIQUIDE:
            case PLANTE:
                if(pouvoirAjouterIngredient(ingredientAjoute.getNature())){
                    ingredientList.add(ingredientAjoute);
                }
                break;
            default :
                throw new PotionDeDegatException(ConstErrMsg.POTION_INGREDIENT_NATURE_INCONNU);
        }
    }

    @Override
    public boolean isReady() {
        return ingredientList.size() == ConstMetier.POTION_DEGAT_MAX_INGREDIENT;
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
        return super.getVolume()*(nbIngrMag+1)*rand.nextInt(ConstMetier.DEGAT_EFFET_BAS, ConstMetier.DEGAT_EFFET_HAUT+1);
    }

    private String getTypeDegat() throws PotionDeDegatException {
        boolean liquide = false;
        boolean plante = false;
        boolean gazeux = false;
        for (Ingredient ingr: ingredientList) {
            if (ingr.getNature() == Nature.LIQUIDE){
                liquide = true;
                break;
            }
            if (ingr.getNature() == Nature.PLANTE){
                plante = true;
                break;
            }
            if (ingr.getNature() == Nature.GAZEUX){
                gazeux = true;
                break;
            }
        }

        if (liquide){
            return ConstMetier.DEGAT_2;
        }
        if (plante){
            return ConstMetier.DEGAT_1;
        }
        if (gazeux){
            return ConstMetier.DEGAT_3;
        }
        throw new PotionDeDegatException(ConstErrMsg.DEGAT_ERR_TYPE);
    }

    private boolean pouvoirAjouterIngredient(Nature natureIngredientAjoute) throws PotionDeDegatException {
        int occ = 0;
        for (Ingredient ingredient:ingredientList) {
            if (ingredient.getNature() == natureIngredientAjoute) {
                occ++;
            }
            if(ingredient.getNature() != Nature.ANIMAL && ingredient.getNature() != natureIngredientAjoute){
                throw new PotionDeDegatException(ConstErrMsg.POTION_INGREDIENT_IMPOSSIBLE_AJOUTER);
            }
        }
        if (occ >= ConstMetier.DEGAT_MAX_INGREDIENT_MEME_NATURE){
            throw new PotionDeDegatException(ConstErrMsg.POTION_INGREDIENT_MAX_MEME_NATURE_ATTEINT);
        }
        return true;
    }
}
