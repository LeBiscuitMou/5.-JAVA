package net.ent.etrs.potionmagique.models.entities;

import net.ent.etrs.potionmagique.models.entities.exceptions.BusinessException;
import net.ent.etrs.potionmagique.models.entities.exceptions.IngredientException;
import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.entities.references.ConstanteMetier;
import net.ent.etrs.potionmagique.models.entities.references.Contenant;
import net.ent.etrs.potionmagique.models.entities.references.Nature;

public final class EntitiesFactory {

    private EntitiesFactory() {
    }

    public static Ingredient fabriquerIngredient(String nom, boolean estMagique, int poids, Nature nature) throws BusinessException {
        try {
            return new Ingredient(nom, estMagique, poids, nature);
        } catch (IngredientException e) {
            throw new BusinessException(ConstanteMetier.INGREDIENT_CONSTRUCTION, e);
        }
    }


    public static Potion fabriquerPotionVie(String nom, Integer volume, Contenant contenant) throws BusinessException {
        try {
            return new PotionVie(nom, volume, contenant);
        } catch (PotionException e) {
            throw new BusinessException(ConstanteMetier.POTION_VIE_CONSTRUCTION, e);
        }
    }

    public static Potion fabriquerPotionDegat(String nom, Integer volume, Contenant contenant) throws BusinessException {
        try {
            return new PotionDegat(nom, volume, contenant);
        } catch (PotionException e) {
            throw new BusinessException(ConstanteMetier.POTION_VIE_CONSTRUCTION, e);
        }
    }

    public static Potion fabriquerPotionAmelioration(String nom, Integer volume, Contenant contenant) throws BusinessException {
        try {
            return new PotionAmelioration(nom, volume, contenant);
        } catch (PotionException e) {
            throw new BusinessException(ConstanteMetier.POTION_VIE_CONSTRUCTION, e);
        }
    }
}
