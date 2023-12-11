package net.ent.etrs.GestionnairePotion.model.references;

public final class ConstMetier {
    public static final int INGREDIENT_POIDS_MAX = 1000;
    public static final int POTION_VIE_MAX_INGREDIENT = 3;
    public static final int POTION_DEGAT_MAX_INGREDIENT = 4;
    public static final int POTION_AMELIORATION_MAX_INGREDIENT = 5;
    public static final int DEGAT_MAX_INGREDIENT_MEME_NATURE = 2;
    public static final int AMELIORATION_MAX_INGREDIENT_MEME_NATURE = 3;
    public static final int VIE_EFFET_BAS = 50;
    public static final int VIE_EFFET_HAUT = 100;
    public static final int DEGAT_EFFET_BAS = 50;
    public static final int DEGAT_EFFET_HAUT = 100;
    public static final int AMELIORATION_EFFET_BAS = 50;
    public static final int AMELIORATION_EFFET_HAUT = 100;
    public static final String AMELIORATION_1 = "vitesse";
    public static final String AMELIORATION_2 = "force";
    public static final String DEGAT_1 = "feu";
    public static final String DEGAT_2 = "glace";
    public static final String DEGAT_3 = "physique";
    public static final int NOM_MAX_SIZE = 30;
    public static final String POTION_NOT_READY = "la potion n'est pas terminé, pas d'effet";


    private ConstMetier() {
    }
}
