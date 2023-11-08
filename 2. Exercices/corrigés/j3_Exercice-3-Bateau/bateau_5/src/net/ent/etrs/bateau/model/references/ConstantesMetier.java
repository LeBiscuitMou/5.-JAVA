package net.ent.etrs.bateau.model.references;

public final class ConstantesMetier {

    public final static String[] forbiddenSymbol = new String[]{"0","1","2","3","4","5","6","7","8","9"};
    /* ************** CONSTANTES BATEAU ************/
    public static final int BATEAU_NOM_LONGUEUR_MAX = 15;
    public static final int BATEAU_NB_EQUIPAGE_MAX = 10000;
    public static final String BATEAU_NOM_ERROR_NULL = "ERREUR Bateau: le nom est null";
    public static final String BATEAU_NOM_ERROR_EMPTY = "ERREUR Bateau: le nom est vide";
    public static final String BATEAU_NOM_ERROR_SIZE = "ERREUR Bateau: le nom est trop grand";
    public static final String BATEAU_NOM_ERROR_NUMBER = "ERREUR Bateau: le nom contient du numérique";
    public static final String BATEAU_CLASSE_ERROR_NULL = "ERREUR Bateau: la classe est null";
    public static final String BATEAU_NB_EQUIPAGE_ERROR_SIZE = "ERREUR Bateau: nombre d'équipage invalide";
    public static final String BATEAU_TONNAGE_ERROR_SIZE = "ERREUR Bateau: tonnage invalide";
    public static final String BATEAU_ARMEMENT_ERROR_NULL = "ERREUR Bateau: l'armement ajouté est null";
    /* ************** CONSTANTES TYPEBATEAU ************/
    public static final int TYPEBATEAU_NOM_LONGUEUR_MAX = 20;
    public static final int TYPEBATEAU_LONGUEUR_MIN = 500;
    public static final int TYPEBATEAU_LONGUEUR_MAX = 2000;
    public static final int TYPEBATEAU_TONNAGE_MIN = 5000;
    public static final int TYPEBATEAU_TONNAGE_MAX = 50000;
    public static final String TYPEBATEAU_NOM_ERROR_NULL = "ERREUR TYPEBATEAU: le nom est null";
    public static final String TYPEBATEAU_NOM_ERROR_SIZE = "ERREUR TYPEBATEAU: le nom est trop grand";
    public static final String TYPEBATEAU_LONGUEUR_ERROR = "ERREUR TYPEBATEAU: la longueur donnée est invalide";
    public static final String TYPEBATEAU_TONNAGE_ERROR = "ERREUR TYPEBATEAU: le tonnage maximum donné est invalide";
    /* ************** CONSTANTES ARMEMENT ************/
    public static final int ARMEMENT_NOM_LONGUEUR_MAX = 20;
    public static final float ARMEMENT_CALIBRE_MIN = 1F;
    public static final float ARMEMENT_CALIBRE_MAX = 200F;
    public static final int ARMEMENT_PORTEE_MIN = 500;
    public static final int ARMEMENT_PORTEE_MAX = 100000;
    public static final String ARMEMENT_NOM_ERROR_NULL = "";
    public static final String ARMEMENT_NOM_ERROR_SIZE = "";
    public static final String ARMEMENT_CALIBRE_ERROR = "";
    public static final String ARMEMENT_PORTEE_ERROR = "";
    public static final int BATEAU_NB_EQUIPAGE_MIN = 1;
    public static final float BATEAU_TONNAGE_MIN = 0f;
    public static final String TYPEBATEAU_NOM_ERROR_EMPTY = "le nom type bateau est vide";
    public static final String ARMEMENT_NOM_ERROR_EMPTY = "le nom de l'armement est vide";


    private ConstantesMetier(){}


}
