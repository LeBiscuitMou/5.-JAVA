package net.ent.etrs.groupeMusique.model.references;

public final class ConstantesMetier {
    public static final String LIEU_NOM_NULL = "Le nom du Lieu ne doit pas être null";
    public static final String LIEU_NOM_VIDE = "Le nom du lieu ne doit pas être vide";
    public static final String SEXE_IS_NULL = "Le sexe ne peut pas être null";
    public static final String PRENOM_IS_NULL = "le Prénom ne doit pas être null";
    public static final String PRENOM_IS_BLANK = "Le prénom ne doit pas être vide";
    public static final int PRENOM_LONGUEUR_MAX = 15;
    public static final String PRENOM_ERROR_LONGUEUR = "La longueur du prénom doit être inférieur à "+PRENOM_LONGUEUR_MAX;
    public static final String PRENOM_ERROR_CHIFFRE = "Le prénom ne doit pas contenir de chiffre";
    public static final String FACADE_ERROR_SAVE_MUSICIEN = "Impossible de sauvegarder le musicien";

    public final static String[] VALEUR_INTERDITE = new String[]{"0","1","2","3","4","5","6","7","8","9"};
    public static final String NOM_IS_NULL = "ERR: Le nom est null.";
    public static final String NOM_IS_BLANK = "ERR: Le nom est vide.";
    public static final int NOM_LONGUEUR_MAX = 15;
    public static final String NOM_ERROR_LONGUEUR = "ERR: Le nom dépasse la longueur maximum.";
    public static final String NOM_ERROR_CHIFFRE = "ERR: Le nom comporte des chiffres.";
    public static final String MATERIEL_ERROR_NULL = "ERR: Le materiel est null.";
    public static final String MUSICIEN_FAN_ERROR_NULL = "ERR: Le fan est null.";
    public static final String LIEU_NB_PLACE_ERROR_NEGATIF = "ERR: Le nombre de place est négatif.";
    public static final String REFERENCE_IS_NULL = "ERR: La référence est null.";
    public static final String REFERENCE_IS_BLANK = "ERR: La référence est vide.";
    public static final int REFERENCE_LONGUEUR_MAX = 20;
    public static final String REFERENCE_ERROR_LONGUEUR = "ERR: La référence dépasse la longueur maximum.";
    public static final String FACTORY_MUSICIEN_ERROR = "ERR: Musicien non crée.";
    public static final String FACTORY_FAN_ERROR =  "ERR: Fan non crée.";
    public static final String FACTORY_SON_LUMIERE_ERROR = "ERR: Son et lumière non crée.";
    public static final String FACTORY_INSTRUMENT_ERROR = "ERR: Instrument non crée.";
    public static final String FACTORY_LIEU_ERROR = "ERR: Lieu non crée.";
    public static final String FACTORY_CONCERT_ERROR = "ERR: Concert non crée.";
    public static final String FACADE_ERROR_DELETE_MUSICIEN = "ERR: Impossible de supprimer le musicien";
    public static final String FACADE_ERROR_UPDATE_MUSICIEN = "ERR: Impossible de modifier le musicien";
    public static final String FACADE_ERROR_CREATE_CONCERT = "ERR: Impossible de créer un concert";
    public static final String FACADE_ERROR_DELETE_CONCERT = "ERR: Impossible d'annuler le concert";
    public static final String FACADE_ERROR_UPDATE_CONCERT = "ERR: Impossible de modifier un concert";

    private ConstantesMetier() {
    }
}