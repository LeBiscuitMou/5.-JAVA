package net.ent.etrs.potionmagique.models.entities.references;

public final class ConstanteMetier {
    public static final String INGREDIENT_NOM_NULL = "le nom de l'ingrédient est null";
    public static final String INGREDIENT_NOM_VIDE = "le nom de l'ingrédient est vide";
    public static final String INGREDIENT_POIDS_NULL = "Le poids de l'ingredient est null";
    public static final String INGREDIENT_POIDS_NEGATIF_OR_ZERO = "Le poids de l'ingrédient doit être positif";
    public static final String INGREDIENT_NATURE_NULL = "la nature de l'ingrédient est null";
    public static final String INGREDIENT_CONSTRUCTION = "Impossible de créé l'ingrédient";
    public static final String FACADE_POTION_NULL = "La potion est Null";
    public static final String FACADE_POTION_NOT_EXIST = "La potion n'existe pas dans la liste";
    public static final String FACADE_POTION_EXIST = "La potion existe déjà dans la liste";
    public static final String FACADE_INGREDIENT_NULL = "L'ingredient est Null";
    public static final String FACADE_INGREDIENT_NOT_EXIST = "L'ingrédient n'existe pas dans la liste";
    public static final String FACADE_INGREDIENT_EXIST = "L'ingredient existe déjà";
    public static final String POTION_NOM_NULL = "Le nom de la potion est null";
    public static final String POTION_NOM_VIDE = "Le nom de la potion est vide";
    public static final String POTION_VOLUME_POSITIF = "Le volume de la potion doit être positif";
    public static final String POTION_VOLUME_NULL = "Le volume de la potion ne peut pas être null";
    public static final String POTION_CONTENANT_NULL = "Le contenant de la potion est null";
    public static final String POTION_CONTENANT_VOLUME_INCORRECT = "Le volume du contenant doit pouvoir contenir le volume de la potion";
    public static final String POTION_NON_FINIE = "Les effets de la potion ne sont pas connus tant que celle-ci n'est pas finie";
    public static final int POTION_VIE_MAX_NB_INGREDIENT = 3;
    public static final String POTION_VIE_MAX_NB_INGREDIENT_ERROR = "Il y a déjà " + POTION_VIE_MAX_NB_INGREDIENT + " ingrédients dans la potion";
    public static final String POTION_VIE_TYPE_INGREDIENT_ERROR = "La nature de l'ingrédient est incompatible avec la potion";
    public static final String POTION_VIE_TYPE_INGREDIENT_ALREADY_PRESENT_ERROR = "un ingrédient de cette Nature est déjà dans la potion";
    public static final int POTION_DEGAT_MAX_NB_INGREDIENT = 4;
    public static final int POTION_AMELIO_MAX_NB_INGREDIENT = 5;
    public static final String POTION_DEGAT_MAX_NB_INGREDIENT_ERROR = "Il y a déjà " + POTION_DEGAT_MAX_NB_INGREDIENT + " ingrédients dans la potion";
    public static final String POTION_AMELIO_MAX_NB_INGREDIENT_ERROR = "Il y a déjà " + POTION_AMELIO_MAX_NB_INGREDIENT + " ingrédients dans la potion";
    public static final String POTION_VIE_CONSTRUCTION = "Impossible de créer une potion de vie";
    public static final String POTION_DEGAT_MAX_INGREDIENT_ANIMAL = "Impossible d'ajouter un ingrédient de nature Animal";
    public static final String POTION_DEGAT_INGREDIENT_ERROR = "Impossible d'inserer un ingrédient de cette nature";
    public static final String POTION_VOLUME_CONTENANT_UNSUPPORTED = "Le volume de la potion est trop grand pour son contenant";
    public static final String POTION_AMELIO_MAX_TYPE_INGREDIENT_ERROR = "Il y a deja le nombre maximal de ce type d'ingrédient";
    public static final String POTION_DEGAT_TYPE_INGREDIENT_ERROR = "Impossible d'ajouter cette nature d'ingrédient";

    private ConstanteMetier() {
    }
}
