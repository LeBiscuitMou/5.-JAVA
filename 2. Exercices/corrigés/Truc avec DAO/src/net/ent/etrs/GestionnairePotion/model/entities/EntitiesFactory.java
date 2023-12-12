package net.ent.etrs.GestionnairePotion.model.entities;

import net.ent.etrs.GestionnairePotion.model.exceptions.EntitiesException;
import net.ent.etrs.GestionnairePotion.model.exceptions.IngredientException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionException;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;
import net.ent.etrs.GestionnairePotion.model.references.Contenant;
import net.ent.etrs.GestionnairePotion.model.references.Nature;

public final class EntitiesFactory {
    private EntitiesFactory() {  }


    public static Ingredient fabriquerIngredient(String nom, boolean estMagique, int poids, Nature nature) throws EntitiesException {
        try {
            return new Ingredient(nom, estMagique, poids, nature);
        } catch (IngredientException e) {
            throw new EntitiesException(ConstErrMsg.EF_CREATION_INGREDIENT ,e);
        }
    }

    public static Potion fabriquerPotionAmelioration(String nom, int volume, Contenant contenant) throws EntitiesException {
        try {
            return new PotionAmelioration(nom, volume, contenant);
        } catch (PotionException e) {
            throw new EntitiesException(ConstErrMsg.EF_CREATION_POTION, e);
        }
    }

    public static Potion fabriquerPotionDeDegat(String nom, int volume, Contenant contenant) throws EntitiesException {
        try {
            return new PotionDeDegat(nom, volume, contenant);
        } catch (PotionException e) {
            throw new EntitiesException(ConstErrMsg.EF_CREATION_POTION, e);
        }
    }

    public static Potion fabriquerPotionDeVie(String nom, int volume, Contenant contenant) throws EntitiesException {
        try {
            return new PotionDeVie(nom, volume, contenant);
        } catch (PotionException e) {
            throw new EntitiesException(ConstErrMsg.EF_CREATION_POTION, e);
        }
    }
}
