package net.ent.etrs.bateau.model.references;

public final class ConstanteMetier {
    public static final int BATEAU_NOM_LONGUEUR_MAX = 15;
    public static final String BATEAU_NOM_ERROR_CHIFFRE = "Le nom comporte un chiffre";
    public static final String BATEAU_NOM_IS_NULL = "Le nom du Bateau est null";
    public static final String BATEAU_NOM_IS_BLANK = "Le nom est vide et ne contient pas d'espace";
    public static final String BATEAU_NOM_TROP_GRAND = "Le nom est trop grand";
    public final static String[] VALEUR_INTERDITE = new String[]{"0","1","2","3","4","5","6","7","8","9"};

    private ConstanteMetier() {
    }
}