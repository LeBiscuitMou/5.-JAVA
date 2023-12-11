package net.ent.etrs.GestionnairePotion.vues.facades;

import net.ent.etrs.GestionnairePotion.model.entities.Ingredient;
import net.ent.etrs.GestionnairePotion.model.entities.Potion;
import net.ent.etrs.GestionnairePotion.model.references.Nature;

import java.util.List;

public interface FacadeVue {


    void afficherLesIngredients(List<Ingredient> ingredientList);
    Ingredient creerUnIngredient();
    Ingredient selectionnerIngredient(List<Ingredient> ingredientList);
    int afficherMenuPrincipal();
    Potion creerUnePotion();
    void afficherToutesLesPotions(List<Potion> potionList);
    void afficherMessageErreur(String msg);
    Potion ajouterUnIngredient(Potion pot, Ingredient ingred);
    void afficherMessage(String msg);
    Potion supprimerUnePotion(List<Potion> potionList);
    Nature selectionnerNatureIngredient();

}
