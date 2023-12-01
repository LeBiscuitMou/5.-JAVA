package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.ContenantException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.IngredientException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;
import net.ent.etrs.poinsot.potion.model.references.Nature;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Ingredient fabriquerIngredient(String nom, boolean estMagique, int poids, Nature nature) throws IngredientException {
        return new Ingredient(nom, estMagique, poids, nature);
    }

    public static PotionAmelioration fabriquerPotionAmelioration(String nom, int volume, Contenant contenant) throws PotionException {
        return new PotionAmelioration(nom, volume, contenant);
    }

    public static PotionDegat fabriquerPotionDegat(String nom, int volume, Contenant contenant) throws PotionException {
        return new PotionDegat(nom, volume, contenant);
    }

    public static PotionVie fabriquerPotionVie(String nom, int volume, Contenant contenant) throws PotionException {
        return new PotionVie(nom, volume, contenant);
    }

    public static Contenant fabriquerContenant(String nom, int volume) throws ContenantException {
        return new Contenant(nom, volume);
    }
}