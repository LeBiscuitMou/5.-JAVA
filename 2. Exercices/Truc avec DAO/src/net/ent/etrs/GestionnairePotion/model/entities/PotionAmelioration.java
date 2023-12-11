package net.ent.etrs.GestionnairePotion.model.entities;

import net.ent.etrs.GestionnairePotion.model.exceptions.IngredientException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionAmeliorationException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionDeVieException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionException;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;
import net.ent.etrs.GestionnairePotion.model.references.ConstMetier;
import net.ent.etrs.GestionnairePotion.model.references.Contenant;
import net.ent.etrs.GestionnairePotion.model.references.Nature;

import java.util.*;

public class PotionAmelioration extends Potion {
    /* ******************************** VARIABLES ******************************** */
    private final List<Ingredient> ingredientList = new ArrayList<>();
    /* ******************************* CONSTRUCTOR ******************************* */
    protected  PotionAmelioration(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }
    /* ********************************* GETTERS ********************************* */
    @Override
    public String getEffet() {
        if (!isReady()){
            return ConstMetier.POTION_NOT_READY;
        }else {
            return String.format("la potion infligera %d points de dégât de %s", getValeurEffet(), getTypeAmelioration());
        }
    }

    public List<Ingredient> getIngredientList() {
        return Collections.unmodifiableList(ingredientList);
    }
    /* ********************************* SETTERS ********************************* */

    /* ******************************** FONCTIONS ******************************** */
    @Override
    public void ajouterIngredient(Ingredient ingredientAjoute) throws PotionAmeliorationException {
        if (Objects.isNull(ingredientAjoute)){
            throw new PotionAmeliorationException(ConstErrMsg.POTION_INGREDIENT_NULL);
        }
        if (ingredientList.size() >= ConstMetier.POTION_AMELIORATION_MAX_INGREDIENT){
            throw new PotionAmeliorationException(ConstErrMsg.POTION_INGREDIENT_MAX_ATTEINT);
        }
        switch (ingredientAjoute.getNature()){
            case ANIMAL :
                throw new PotionAmeliorationException(ConstErrMsg.AMELIORATION_INGREDIENT_ANIMAL);
            case GAZEUX:
                throw new PotionAmeliorationException(ConstErrMsg.AMELIORATION_INGREDIENT_GAZEUX);
            case LIQUIDE:
            case PLANTE:
                verifierOccurrenceIngredient(ingredientAjoute);
                break;
            default :
                throw new PotionAmeliorationException(ConstErrMsg.POTION_INGREDIENT_NATURE_INCONNU);
        }
    }

    @Override
    public boolean isReady() {
        return ingredientList.size() == ConstMetier.POTION_AMELIORATION_MAX_INGREDIENT;
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
        return super.getVolume()*(nbIngrMag+1)*rand.nextInt(ConstMetier.AMELIORATION_EFFET_BAS, ConstMetier.AMELIORATION_EFFET_HAUT+1);
    }

    private String getTypeAmelioration(){
        int occPlante = 0;
        for (Ingredient ingr: ingredientList) {
            if (ingr.getNature() == Nature.PLANTE){
                occPlante++;
            }
        }
        if (occPlante == ConstMetier.AMELIORATION_MAX_INGREDIENT_MEME_NATURE){
            return ConstMetier.AMELIORATION_1;
        }else {
            return ConstMetier.AMELIORATION_2;
        }
    }


    private void verifierOccurrenceIngredient(Ingredient ingredientAjoute) throws PotionAmeliorationException {
        int occ = 0;
        for (Ingredient ingredient:ingredientList) {
            if (ingredient.getNature() == ingredientAjoute.getNature()) {
                occ++;
            }
        }
        if (occ >= ConstMetier.AMELIORATION_MAX_INGREDIENT_MEME_NATURE){
            throw new PotionAmeliorationException(ConstErrMsg.POTION_INGREDIENT_MAX_MEME_NATURE_ATTEINT);
        }
        ingredientList.add(ingredientAjoute);
    }
}
