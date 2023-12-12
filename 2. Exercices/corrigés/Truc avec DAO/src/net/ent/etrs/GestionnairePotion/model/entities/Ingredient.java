package net.ent.etrs.GestionnairePotion.model.entities;

import net.ent.etrs.GestionnairePotion.model.exceptions.IngredientException;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;
import net.ent.etrs.GestionnairePotion.model.references.ConstMetier;
import net.ent.etrs.GestionnairePotion.model.references.Nature;
import net.ent.etrs.GestionnairePotion.model.utils.StringVerif;
import net.ent.etrs.GestionnairePotion.model.utils.exceptions.StringVerifException;

import java.util.Objects;

public class Ingredient extends AbstractEntity {
    /* ******************************** VARIABLES ******************************** */
    private String nom;
    private boolean estMagique;
    private int poids;
    private Nature nature;
    /* ******************************* CONSTRUCTOR ******************************* */
    protected Ingredient(String nom, boolean estMagique, int poids, Nature nature) throws IngredientException {
        this.setNom(nom);
        this.setEstMagique(estMagique);
        this.setPoids(poids);
        this.setNature(nature);
    }
    /* ********************************* GETTERS ********************************* */
    public String getNom() {
        return nom;
    }
    public boolean isEstMagique() {
        return estMagique;
    }
    public int getPoids() {
        return poids;
    }

    public Nature getNature() {
        return nature;
    }
    /* ********************************* SETTERS ********************************* */
    private void setNom(String nom) throws IngredientException {
        try {
            StringVerif.verifierStringAvecMaximum(nom, ConstMetier.NOM_MAX_SIZE);
        } catch (StringVerifException e) {
            throw new IngredientException(ConstErrMsg.INGREDIENT_NOM_INVALIDE ,e);
        }
        this.nom = nom;
    }

    private void setEstMagique(boolean estMagique) {
        this.estMagique = estMagique;
    }

    private void setPoids(int poids) throws IngredientException {
        if (poids < 0){
            throw new IngredientException(ConstErrMsg.INGREDIENT_POIDS_INVALIDE);
        }
        if (poids > ConstMetier.INGREDIENT_POIDS_MAX){
            throw new IngredientException(ConstErrMsg.INGREDIENT_POIDS_INVALIDE);
        }
        this.poids = poids;
    }

    private void setNature(Nature nature) throws IngredientException {
        if (Objects.isNull(nature)){
            throw new IngredientException(ConstErrMsg.INGREDIENT_NATURE_NULL);
        }
        this.nature = nature;
    }
    /* ******************************** FONCTIONS ******************************** */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;
        return isEstMagique() == that.isEstMagique() && Objects.equals(getNom(), that.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), isEstMagique());
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

    /* **************************** PRIVATE FUNCTIONS **************************** */
}
