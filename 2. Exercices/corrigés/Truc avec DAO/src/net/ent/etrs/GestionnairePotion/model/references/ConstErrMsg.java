package net.ent.etrs.GestionnairePotion.model.references;

public final class ConstErrMsg {
    public static final String INGREDIENT_NOM_INVALIDE = "le nom de l'ingrédient est invalide";
    public static final String INGREDIENT_POIDS_INVALIDE = "le poids de l'ingrédient est invalide";
    public static final String INGREDIENT_NATURE_NULL = "la nature de l'ingrédient ne peut pas être null";
    public static final String POTION_VOLUME_INVALIDE = "le volume de la potion est invalide";
    public static final String POTION_NOM_INVALIDE = "le nom de la potion est invalide";
    public static final String POTION_CONTENANT_NULL = "le contenant de la potion ne peut pas être null";
    public static final String POTION_INGREDIENT_NULL = "l'ingrédient ajouté ne peut pas être null";
    public static final String POTION_INGREDIENT_MAX_ATTEINT = "la limite d'ingrédient pour cette potion a était atteint";
    public static final String POTION_INGREDIENT_NATURE_INCONNU = "la nature de l'ingrédient n'est pas valide";
    public static final String VIE_INGREDIENT_GAZEUX = "la potion de vie ne peut pas avoir d'ingrédient gazeux";
    public static final String VIE_INGREDIENT_NATURE_EXIST = "la potion de vie ne peut avoir qu'un ingrédient de cette nature";
    public static final String DEGAT_ERR_TYPE = "le type de dégat de la potion n'a pas pu être déterminer";
    public static final String AMELIORATION_INGREDIENT_ANIMAL = "les potions d'amélioration ne possède pas d'ingrédient d'animaux";
    public static final String AMELIORATION_INGREDIENT_GAZEUX = "les potions d'amélioration ne possède pas d'ingrédient gazeux";
    public static final String POTION_INGREDIENT_MAX_MEME_NATURE_ATTEINT = "la potion a atteint le maximum d'ingrédient de cette nature d'ingrédient";
    public static final String EF_CREATION_INGREDIENT = "Impossible de crée l'ingrédient";
    public static final String EF_CREATION_POTION = "Impossible de crée la potion";
    public static final String FACADE_ERROR_INGREDIENT_NULL = "l'ingrédient ne doit pas être null";
    public static final String FACADE_ERROR_INGREDIENT_NOT_EXIST = "l'ingrédient n'existe pas";
    public static final String FACADE_ERROR_INGREDIENT_SUPPRESSION = "impossible de supprimer l'ingrédient";
    public static final String FACADE_ERROR_POTION_NULL = "la potion ne doit pas être null";
    public static final String FACADE_ERROR_POTION_NOT_EXIST = "la potion n'existe pas";
    public static final String FACADE_ERROR_POTION_SUPPRESSION = "impossible de supprimer la potion";
    public static final String FACADE_ERROR_INGREDIENT_EXIST = "l'ingrédient existe déjà";
    public static final String FACADE_ERROR_INGREDIENT_SAUVEGARDE = "impossible de sauvegarder l'ingrédient";
    public static final String FACADE_ERROR_POTION_EXIST = "la potion existe déjà";
    public static final String FACADE_ERROR_POTION_SAUVEGARDE = "impossible de sauvegarder la potion";
    public static final String POTION_INGREDIENT_IMPOSSIBLE_AJOUTER = "impossible d'ajouter cette nature ingrédient à cette potion de dégat";
    public static final String ENTITY_NULL = "l'entité doit être référencer";
    public static final String ENTITY_EXIST = "l'entité existe déjà";
    public static final String INGREDIENTS_RECUPERATION = "une érreur est survenu lors de la récupération des ingrédients.";
    public static final String POTION_RECUPERATION = "une érreur est survenu lors de la récupération des potions.";


    private ConstErrMsg() {
    }
}
