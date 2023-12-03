package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionDegatException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;
import net.ent.etrs.poinsot.potion.model.references.ConstanteMetier;
import net.ent.etrs.poinsot.potion.model.references.Nature;
import net.ent.etrs.poinsot.potion.view.commons.utils.AffichageConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        String typeDegat = "";
        Random r = new Random();
        int total = 0;
        this.lesIngredients = super.getLesIngredients();
        for (Ingredient i : lesIngredients) {
            if (i.getNature().equals(Nature.LIQUIDE)) {
                typeDegat = "Dégât de Froid";
            }
            else if (i.getNature().equals(Nature.PLANTE)) {
                typeDegat = "Dégât de Feu";
            }
            else if (i.getNature().equals(Nature.GAZEUX)) {
                typeDegat = "Dégât Physique";
            }
        }
        total = r.nextInt(50, 100) * super.getVolume();
        AffichageConsole.afficherMessageAvecSautLigne("La potion infligera " + total + " points de " + typeDegat);
        return total;
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