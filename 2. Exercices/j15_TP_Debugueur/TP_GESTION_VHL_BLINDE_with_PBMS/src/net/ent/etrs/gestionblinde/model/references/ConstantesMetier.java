package net.ent.etrs.gestionblinde.model.references;

public final class ConstantesMetier {

    public static final Integer POIDS_MAX_CA = 60;
    public static final String POIDS_CA_INCORRECT = "Le poids du Char d'assault dépasse : "+POIDS_MAX_CA+" tonnes";
    public static final String POIDS_VHLB_INCORRECT = "Le poids du véhicule blindé est incorrect";
    public static final Integer NB_CARTOUCHE_CA_MAX = 500;
    public static final String NB_CARTOUCHE_INCORRECT = "Le nombre de cartouche de 12.7 dépasse : "+NB_CARTOUCHE_CA_MAX+" cartouches";
    public static final Integer POIDS_MAX_VTT = 25;
    public static final String POIDS_VTT_INCORRECT = "Le poids du véhicule transport de troupes dépasse : "+POIDS_MAX_VTT+" tonnes";
    public static final Integer NB_PERS_EMB_MAX = 15;
    public static final String NB_PERS_EMB_INCORRECT = "Le nombre de personne embarqué dépasse : "+NB_PERS_EMB_MAX;
    public static final String OBUS_CA_ADD_INCORRECT = "L'obus ajouter est incorrect";
    public static final int NB_OBUS_MAX_CA = 40;
    public static final String NB_OBUS_ADD_CA_INCORRECT = "Le nombre d'obus dépasse : "+NB_OBUS_MAX_CA+" obus";
    public static final String OBUS_RETIRER_NON_PRESENT = "Le véhicule blindé ne possède pas cet obus";
    public static final String OBUS_RETIRER_INCORRECT = "Obus incorrect";
    public static final String DAO_OBUS_IMPOSSIBLE_CREATE = "L'Obus existe déjà en base";
    public static final String DAO_OBUS_IMPOSSIBLE_UPDATE = "Mise à jour de l'obus impossible";
    public static final String DAO_VHLB_IMPOSSIBLE_CREATE = "Impossible de créer le véhicule blindé";
    public static final String DAO_VHLB_IMPOSSIBLE_UPDATE = "Impossible de mettre a jour le Véhicule Blindé";
    public static final String DAO_VHLB_IMPOSSIBLE_DELETE = "Impossible de supprimer le vehicule";
    public static final String VEHICULE_BLINDE_EMMAT_8_IS_NULL = "L'emmat ne peut pas être NULL";
    public static final String VEHICULE_BLINDE_EMMAT_8_IS_BLANK = "L'emmat ne peut pas être vide";

    private ConstantesMetier() {
    }
}
