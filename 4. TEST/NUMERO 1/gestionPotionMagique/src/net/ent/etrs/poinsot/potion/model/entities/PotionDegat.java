package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionDegatException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;
import net.ent.etrs.poinsot.potion.model.references.ConstanteMetier;

import java.util.ArrayList;
import java.util.List;

public class PotionDegat extends Potion {
    private List<Ingredient> lesIngredients = new ArrayList<>();

    public PotionDegat(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }

    @Override
    public int effetPotion() throws PotionDegatException {
        if (!estFinie()) {
            throw new PotionDegatException(ConstanteMetier.POTION_NON_TERMINEE);
        }
    }

    @Override
    public boolean estFinie() {
        return lesIngredients.size() == 4;
    }

    @Override
    public void ajouterIngredient(Ingredient ingredient) throws PotionException {
        super.ajouterIngredient(ingredient);
    }
}