package net.ent.etrs.potionmagique.models.entities;

import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.entities.references.ConstanteMetier;
import net.ent.etrs.potionmagique.models.entities.references.Contenant;
import net.ent.etrs.potionmagique.models.entities.references.Nature;

import java.util.Random;

public class PotionDegat extends Potion {
    public PotionDegat(String nom, Integer volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }

    @Override
    public String effectPotion() {
        String retour = ConstanteMetier.POTION_NON_FINIE;
        if (estFinie()) {
            Nature n = trouverNatureDegat();
            switch (n) {
                case LIQUIDE -> retour = "la potion infligera " + calculDegat() + " points de dégât de Froid ";
                case GAZEUX -> retour = "la potion infligera  " + calculDegat() + " points de dégât de Physique ";
                case PLANTE -> retour = "la potion infligera  " + calculDegat() + " points de dégât de Feu ";
            }
        }
        return retour;
    }

    private int calculDegat() {
        return new Random().nextInt(50, 100) * this.getVolume();
    }

    private Nature trouverNatureDegat() {
        for (Ingredient i : this.lesIngredients) {
            if (!(i.getTypeIngredient().equals(Nature.ANIMAL))) {
                return i.getTypeIngredient();
            }
        }
        //Choix par defaut
        return Nature.ANIMAL;
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
            throw new PotionException(ConstanteMetier.POTION_DEGAT_MAX_NB_INGREDIENT_ERROR);
        }
        if (lIngredient.getTypeIngredient().equals(Nature.ANIMAL) && potionPossedeIngredientAnimal()) {
            throw new PotionException(ConstanteMetier.POTION_DEGAT_MAX_INGREDIENT_ANIMAL);
        }
        if (this.lesIngredients.isEmpty()) {
            this.lesIngredients.add(lIngredient);
        } else {
            potionPossedeIngredient(lIngredient);
        }
    }

    private void potionPossedeIngredient(Ingredient lIngredient) throws PotionException {
//        if (lIngredient.getTypeIngredient().equals(Nature.ANIMAL)) {
//            this.lesIngredients.add(lIngredient);
//        } else {
//            //si il n'y a que des Type ANIMAL alors on ajoute
//            if (potionPossedeUniquementIngredientAnimal()) {
//                this.lesIngredients.add(lIngredient);
//            } else {
//                //sinon il y a un autre type et on compare pour vérifier
//                if (trouverNatureDegat().equals(lIngredient.getTypeIngredient())) {
//                    this.lesIngredients.add(lIngredient);
//                } else {
//                    throw new PotionException(ConstanteMetier.POTION_DEGAT_TYPE_INGREDIENT_ERROR);
//                }
//            }
//
//        }

        if (lIngredient.getTypeIngredient().equals(Nature.ANIMAL)
                || potionPossedeUniquementIngredientAnimal()
                || trouverNatureDegat().equals(lIngredient.getTypeIngredient())) {
            this.lesIngredients.add(lIngredient);
        } else {
            throw new PotionException(ConstanteMetier.POTION_DEGAT_TYPE_INGREDIENT_ERROR);
        }
    }

    private boolean potionPossedeUniquementIngredientAnimal() {
        for (Ingredient i : this.lesIngredients) {
            if (!(i.getTypeIngredient().equals(Nature.ANIMAL))) {
                return false;
            }
        }
        return true;
    }


    private boolean potionPossedeIngredientAnimal() {
        int nbIngredientAnimal = 0;
        for (Ingredient i : this.getLesIngredients()) {
            if (i.getTypeIngredient().equals(Nature.ANIMAL)) {
                nbIngredientAnimal++;
            }
        }
        return nbIngredientAnimal > 2;

    }

    /**
     * Permet de savoir si la Potion est complète
     *
     * @return si la potion est complète ou non
     */
    @Override
    public boolean estFinie() {
        return this.getLesIngredients().size() > ConstanteMetier.POTION_DEGAT_MAX_NB_INGREDIENT;
    }
}
