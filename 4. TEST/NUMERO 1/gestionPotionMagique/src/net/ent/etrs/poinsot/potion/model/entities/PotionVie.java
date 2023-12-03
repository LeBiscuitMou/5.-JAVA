package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionVieException;
import net.ent.etrs.poinsot.potion.model.references.ConstanteMetier;
import net.ent.etrs.poinsot.potion.view.commons.utils.AffichageConsole;

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
    public int effetPotion() throws PotionVieException {
        if (!estFinie()) {
            throw new PotionVieException(ConstanteMetier.POTION_NON_TERMINEE);
        }
        int total = 0;
        Random r = new Random();
        int nbIngMagique = 0;

        for (Ingredient i : this.lesIngredients) {
            if (i.isEstMagique()) {
                nbIngMagique++;
            }
        }
        total = r.nextInt(50, 100) * this.getVolume() * (nbIngMagique + 1);
        AffichageConsole.afficherMessageAvecSautLigne("La potion vous rendra " + total + " points de vie");
        return total;
    }
    @Override
    public boolean estFinie() {
        return this.lesIngredients.size() == 3;
    }

    @Override
    public void ajouterIngredient(Ingredient ingredient) throws PotionException {
        super.ajouterIngredient(ingredient);
    }
}