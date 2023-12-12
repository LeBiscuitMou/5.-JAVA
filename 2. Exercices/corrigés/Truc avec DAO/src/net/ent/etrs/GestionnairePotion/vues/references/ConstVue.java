package net.ent.etrs.GestionnairePotion.vues.references;

import net.ent.etrs.GestionnairePotion.model.references.ConstMetier;

public final class ConstVue {
    public static final String NOM_PROGRAMME = "Gestionnaire de potions";
    public static final String ERROR_GRILLE_NULL = "ERREUR, la grille donné est null";
    public static final String ERROR_TABLEAU_NULL = "ERREUR, le tableau donné est null";
    public static final String INGREDIENT_LIST_NULL = "ERREUR, la liste d'ingrédient ne doit pas être null";
    public static final String POTION_LIST_NULL = "ERREUR, la liste de potion ne doit pas être null";
    public static final int INGREDIENT_ATTRIBUTS = 4;
    public static final int POTION_ATTRIBUTS = 4;
    public static final String NOM_TROP_GRAND = String.format("le nom donné est trop grand, le maximum est %d caractères", ConstMetier.NOM_MAX_SIZE);
    public static final String INGREDIENT_LIST_VIDE = "la liste d'ingrédient est vide, il n'y a rien à afficher";
    public static final String POTION_LIST_VIDE = "la liste de potion est vide, il n'y a rien à afficher";
    public static final String CHOIX_INGREDIENT_POUR_POTION_MESSAGE = "choisissez un ingrédient à ajouter dans la potion :";


    private ConstVue() {
    }
}
