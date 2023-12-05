package net.ent.etrs.potionmagique.models.entities;

import net.ent.etrs.potionmagique.models.entities.exceptions.IngredientException;
import net.ent.etrs.potionmagique.models.entities.references.ConstanteMetier;
import net.ent.etrs.potionmagique.models.entities.references.Nature;

import java.util.Objects;

public class Ingredient {

    private String nom;

    private boolean estMagique;

    private Integer poids;

    private Nature typeIngredient;

    public Ingredient(String nom, boolean estMagique, Integer poids, Nature typeIngredient) throws IngredientException {
        this.setNom(nom);
        this.setEstMagique(estMagique);
        this.setPoids(poids);
        this.setTypeIngredient(typeIngredient);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws IngredientException {
        if (Objects.isNull(nom)) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_NOM_NULL);
        }
        if (nom.isBlank()) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_NOM_VIDE);
        }
        this.nom = nom;
    }

    public boolean isEstMagique() {
        return estMagique;
    }

    public void setEstMagique(boolean estMagique) {
        this.estMagique = estMagique;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) throws IngredientException {
        if (null == poids) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_POIDS_NULL);
        }
        if (poids <= 0) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_POIDS_NEGATIF_OR_ZERO);
        }
        this.poids = poids;
    }

    public Nature getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(Nature typeIngredient) throws IngredientException {
        if (null == typeIngredient) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_NATURE_NULL);
        }
        this.typeIngredient = typeIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return estMagique == that.estMagique && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, estMagique);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "nom='" + nom + '\'' +
                ", estMagique=" + estMagique +
                ", poids=" + poids +
                ", typeIngredient=" + typeIngredient +
                '}';
    }
}
