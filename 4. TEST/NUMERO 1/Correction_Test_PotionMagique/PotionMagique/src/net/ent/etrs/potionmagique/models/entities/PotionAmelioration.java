package net.ent.etrs.potionmagique.models.entities;

import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.entities.references.ConstanteMetier;
import net.ent.etrs.potionmagique.models.entities.references.Contenant;
import net.ent.etrs.potionmagique.models.entities.references.Nature;

import java.util.Random;


public class PotionAmelioration extends Potion {


    public PotionAmelioration(String nom, Integer volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }

    @Override
    public String effectPotion() {
        String retour = ConstanteMetier.POTION_NON_FINIE;
        if (estFinie()) {
            int nbPlante = 0;
            int nbLiquide = 0;
            for (Ingredient i : getLesIngredients()) {
                if ((i.getTypeIngredient().equals(Nature.PLANTE))) {
                    nbPlante++;
                } else {
                    nbLiquide++;
                }
            }
            if (nbPlante > nbLiquide) {
                retour = "La potion améliore de " + calculDegat() + " points la vitesse de la personne";
            } else {
                retour = "La potion améliore de " + calculDegat() + " points la force de la personne";
            }
        }

        return retour;
    }

    private int calculDegat() {
        return new Random().nextInt(50, 100) * this.getVolume();
    }

    /**
     * Permet d'ajouter un ingrédient à la Potion
     *
     * @param lIngredient l'ingrédient qui est rajouté
     */
    @Override
    public void ajouterIngredient(Ingredient lIngredient) throws PotionException {
        if (estFinie()) {
            throw new PotionException(ConstanteMetier.POTION_AMELIO_MAX_NB_INGREDIENT_ERROR);
        }
        if (!(lIngredient.getTypeIngredient().equals(Nature.LIQUIDE)
                || lIngredient.getTypeIngredient().equals(Nature.PLANTE))) {
            throw new PotionException(ConstanteMetier.POTION_VIE_TYPE_INGREDIENT_ERROR);
        }
        // pour le premier ingredient
        if (this.getLesIngredients().isEmpty()) {
            this.lesIngredients.add(lIngredient);
        } else {
            //S'il y a déjà des ingrédients
            //vérifier que l'on ajout pas un 4e ingrédient d'un même type
            verifNbIngredientType(lIngredient);

            this.lesIngredients.add(lIngredient);
        }
    }

    private void verifNbIngredientType(Ingredient lIngredient) throws PotionException {
        int nbIngredient = 0;
        for (Ingredient i : this.getLesIngredients()) {
            if (i.getTypeIngredient().equals(lIngredient.getTypeIngredient())) {
                nbIngredient++;
            }
        }
        if (nbIngredient > 3) {
            throw new PotionException(ConstanteMetier.POTION_AMELIO_MAX_TYPE_INGREDIENT_ERROR);
        }

    }


    /**
     * Permet de savoir si la Potion est complète
     *
     * @return si la potion est complète ou non
     */
    @Override
    public boolean estFinie() {
        return this.getLesIngredients().size() > ConstanteMetier.POTION_AMELIO_MAX_NB_INGREDIENT;
    }


}
