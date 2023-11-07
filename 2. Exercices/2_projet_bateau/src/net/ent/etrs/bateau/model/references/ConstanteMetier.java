package net.ent.etrs.bateau.model.references;

public final class ConstanteMetier {
    public static final int BATEAU_NOM_LONGUEUR_MAX = 15;
    public static final String BATEAU_NOM_ERROR_CHIFFRE = "Le nom comporte un chiffre";
    public final static String[] VALEUR_INTERDITE = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static final String BATEAU_ERROR_NULL = "Le nom est null";

    private ConstanteMetier() {
    }
}