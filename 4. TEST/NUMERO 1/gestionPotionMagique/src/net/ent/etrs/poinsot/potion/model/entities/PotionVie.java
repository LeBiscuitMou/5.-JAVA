package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PotionVie extends Potion {
    private List<Ingredient> lesIngredients = new ArrayList<>();

    public PotionVie(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }

    public List<Ingredient> getLesIngredients() {
        return Collections.unmodifiableList(lesIngredients);
    }

    @Override
    public int effetPotion() {
        Random r = new Random();
        int nbMagique = 0;
        for (Ingredient i : this.lesIngredients) {
            if (i.isEstMagique()) {
                nbMagique++;
            }
        }

        return r.nextInt(50, 100) * this.getVolume() * (nbMagique + 1);
    }
}