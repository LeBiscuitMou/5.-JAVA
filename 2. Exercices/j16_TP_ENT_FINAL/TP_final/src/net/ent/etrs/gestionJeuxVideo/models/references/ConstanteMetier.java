package net.ent.etrs.gestionJeuxVideo.models.references;

public final class ConstanteMetier {
    public static final String CONSOLE_NOM_ERROR = "le nom de la console est incorrecte";
    public static final String CONSOLE_PAYS_DATE_NULL = "Le pays oiu la date ne peuit pas être null";
    public static final String FABRIQUANT_NOM_ERROR = "Le nom du fabriquant ne peut pas être null";
    public static final String ENTITIES_CONSOLE_ERROR = "Impossible de fabriquer une console";
    public static final String ENTITIES_JEUVIDEO_ERROR = "Impossible de fabriquer le jeu video";
    public static final String ENTITIES_FABRIQUANT_ERROR = "Impossible de fabriquer le fabriquant";
    public static final String FACADEMETIER_JV_NULL = "Le jeu video est null";
    public static final String FACADEMETIER_FABRIQUANT_NULL = "Le fabriquant est null";
    public static final String FACADEMETIER_CONSOLE_NULL = "La console est null";
    public static final String FACADEMETIER_ERROR_DAO = "Impossible de se connecter à la base de donnée";
    public static final String CONSOLE_SORTIES_IS_NULL = "Les sorties ne peuvent pas être NULL";
    public static final String ABSTRACT_ENTITY_ID_IS_NEGATIVE = "L'id ne peut pas être négatif";
    public static final String JEU_VIDEO_GENRE_IS_NULL = "Le genre ne peut pas être NULL";
    public static final String JEU_VIDEO_DATE_PASSE = "La date de sortie ne peut pas être dans le passé";
    public static final String DAO_ENTITY_IS_NULL = "L'entité ne peut pas être NULL";
    public static final String DAO_ENTITY_EXIST = "L'entité existe déjà";

    private ConstanteMetier() {
    }

    public static final String JEUVIDEO_NOM_ERROR = "Le nom du jeu video est incorrect";
}
