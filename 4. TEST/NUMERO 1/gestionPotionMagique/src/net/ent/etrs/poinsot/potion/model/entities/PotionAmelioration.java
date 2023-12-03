package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;

import java.util.ArrayList;
import java.util.List;

public class PotionAmelioration extends Potion {
    List<Ingredient> lesIngredients = new ArrayList<>();

    public PotionAmelioration(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }

    @Override
    public int effetPotion() {
        return 0;
    }

    @Override
    public boolean estFinie() {
        return lesIngredients.size() == 5;
    }

    @Override
    public void ajouterIngredient(Ingredient ingredient) throws PotionException {
        super.ajouterIngredient(ingredient);
    }
}