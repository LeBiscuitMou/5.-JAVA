package net.ent.etrs.poinsot.potion.model.references;

public final class ConstanteMetier {
    public static final String INGREDIENT_NOM_IS_NULL = "ERREUR : Le nom de l'ingrédient ne peut pas être NULL";
    public static final String INGREDIENT_NOM_IS_BLANK = "ERREUR : LE nom de l'ingrédient ne peut pas être vide";
    public static final String INGREDIENT_POIDS_IS_NEGATIVE = "ERREUR : Le poids ne peut pas être négatif";
    public static final String INGREDIENT_NATURE_IS_NULL = "ERREUR : La nature ne peut pas être NULL";
    public static final String CONTENANT_VOLUME_IS_NEGATIVE = "ERREUR : Le volume du contenant ne peut être ni négatif, ni à 0";
    public static final String POTION_NOM_IS_NULL = "ERREUR : Le nom de la potion ne peut pas être NULL";
    public static final String POTION_NOM_IS_BLANK = "ERREUR : Le nom de la potion ne peut pas être vide";
    public static final String POTION_VOLUME_IS_NEGATIVE = "ERREUR : Le volume de la potion ne peut pas être négatif";
    public static final String POTION_CONTENANT_IS_NULL = "ERREUR : Le contenant de la potion ne peut pas être NULL";
    public static final String CONTENANT_NOM_IS_NULL = "ERREUR : Le nom du contenant ne peut pas être NULL";
    public static final String CONTENANT_NOM_IS_BLANK = "ERREUR : Le nom du contenant ne peut pas être vide";
    public static final String INGREDIENT_IS_NULL = "ERREUR : L'ingredient ne peut pas être NULL";
    public static final String POTION_IS_NULL = "ERREUR : La potion ne peut pas être NULL";
    public static final String LISTE_POTIONS_VIDE = "ERREUR : La liste de potions est vide";
    public static final String INGREDIENT_NOT_EXIST = "ERREUR : L'ingredient à supprimer n'existe pas";
    public static final String POTION_NOT_EXIST = "ERREUR : La potion à supprimer n'existe pas";
    public static final String INGREDIENT_EXISTE_DEJA = "ERREUR : L'ingrédient que vous voulez ajouter existe déjà";
    public static final String POTION_EXISTE_DEJA = "ERREUR : La potion que vous voulez créer existe déjà";
    public static final String POTION_NON_TERMINEE = "ERREUR : Impossible d'afficher les effets tant que la potion n'est pas finie";

    private ConstanteMetier() {
    }
}