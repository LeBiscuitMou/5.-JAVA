package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.IngredientException;
import net.ent.etrs.poinsot.potion.model.entities.references.Nature;
import net.ent.etrs.poinsot.potion.model.references.ConstanteMetier;

import java.util.Objects;

public class Ingredient {
    private String nom;
    private boolean estMagique;
    private int poids;
    private Nature nature;

    protected Ingredient(String nom, boolean estMagique, int poids, Nature nature) throws IngredientException {
        this.setNom(nom);
        this.setEstMagique(estMagique);
        this.setPoids(poids);
        this.setNature(nature);
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws IngredientException {
        if (Objects.isNull(nom)) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public boolean isEstMagique() {
        return estMagique;
    }

    private void setEstMagique(boolean estMagique) {
        this.estMagique = estMagique;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) throws IngredientException {
        if (poids < 0) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_POIDS_IS_NEGATIVE);
        }
        this.poids = poids;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) throws IngredientException {
        if (Objects.isNull(nature)) {
            throw new IngredientException(ConstanteMetier.INGREDIENT_NATURE_IS_NULL);
        }
        this.nature = nature;
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
                ", nature=" + nature +
                '}';
    }
}