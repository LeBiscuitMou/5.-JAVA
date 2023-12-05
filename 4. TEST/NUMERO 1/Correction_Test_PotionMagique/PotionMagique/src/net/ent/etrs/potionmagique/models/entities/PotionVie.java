package net.ent.etrs.potionmagique.models.entities;

import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.entities.references.ConstanteMetier;
import net.ent.etrs.potionmagique.models.entities.references.Contenant;
import net.ent.etrs.potionmagique.models.entities.references.Nature;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PotionVie extends Potion {
    public PotionVie(String nom, Integer volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }

    @Override
    public String effectPotion() {
        String retour = ConstanteMetier.POTION_NON_FINIE;
        if (estFinie()) {
            int alea = new Random().nextInt(50, 100);
            int nbIngredientsMagique = 1;
            for (Ingredient i : getLesIngredients()) {
                if (i.isEstMagique()) {
                    nbIngredientsMagique++;
                }
            }
            retour = "La potion vous rendra " + alea * getVolume() * nbIngredientsMagique + " points de vie";

        }

        return retour;
    }

    /**
     * Permet d'ajouter un ingrédient à la Potion
     *
     * @param lIngredient l'ingrédient qui est rajouté
     */
    @Override
    public void ajouterIngredient(Ingredient lIngredient) throws PotionException {
        //Il y a déja tous les ingrédients
        if (estFinie()) {
            throw new PotionException(ConstanteMetier.POTION_VIE_MAX_NB_INGREDIENT_ERROR);
        }
        //S'il y a déjà des ingrédients
        if (!this.getLesIngredients().isEmpty()) {
            List<Nature> natureList = new ArrayList<>();
            for (Ingredient i : this.getLesIngredients()) {
                natureList.add(i.getTypeIngredient());
            }
            if (natureList.contains(lIngredient.getTypeIngredient())) {
                throw new PotionException(ConstanteMetier.POTION_VIE_TYPE_INGREDIENT_ALREADY_PRESENT_ERROR);
            }
            this.lesIngredients.add(lIngredient);
        }
        // pour le premier ingredient
        if (this.getLesIngredients().isEmpty()) {
            if (lIngredient.getTypeIngredient().equals(Nature.LIQUIDE)
                    || lIngredient.getTypeIngredient().equals(Nature.PLANTE)
                    || lIngredient.getTypeIngredient().equals(Nature.ANIMAL)) {
                this.lesIngredients.add(lIngredient);
            } else {
                throw new PotionException(ConstanteMetier.POTION_VIE_TYPE_INGREDIENT_ERROR);
            }
        }

    }

    /**
     * Permet de savoir si la Potion est complète
     *
     * @return si la potion est complète ou non
     */
    @Override
    public boolean estFinie() {
        return this.getLesIngredients().size() > ConstanteMetier.POTION_VIE_MAX_NB_INGREDIENT;
    }

    
}
