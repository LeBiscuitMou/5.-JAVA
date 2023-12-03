package net.ent.etrs.gestionformation.models.entities.references;

public final class ConstanteMetier {
    public static final String COURS_ID_VIDE = "L'Id du cours est vide";
    public static final int COURS_DUREE_MIN = 1;
    public static final int COURS_DUREE_MAX = 4;
    public static final String COURS_DUREE_INCORRECTE = "La durée du cours doit être compris entre "+COURS_DUREE_MIN +" et "+COURS_DUREE_MAX;
    public static final String COURS_DEBUT_COURS_NULL = "le debut du cours ne doit pas être null";
    public static final String MATIERE_NOM_NULL = "Le nom de la matière ne doit pas être null";
    public static final String MATIERE_NOM_VIDE = "Le nom de la matière ne doit pas être vide";
    public static final String MATIERE_CODE_NULL = "le code de la matière ne doit pas être null";
    public static final String MATIERE_CODE_VIDE = "le code de la matière ne doit pas être vide";
    public static final int MATIERE_NB_HEURE_MIN = 10;
    public static final int MATIERE_NB_HEURE_MAX = 100;
    public static final String MATIERE_NB_HEURE_ERROR =  "Le nombre d'heure de la matière doit être compris entre "+MATIERE_NB_HEURE_MIN +" et "+MATIERE_NB_HEURE_MAX;
    public static final String UV_NOM_NULL = "Le nom de l'UV ne doit pas être null";
    public static final String UV_NOM_VIDE = "Le nom de l'UV ne doit pas être vide";
    public static final String UV_DATE_DEBUT_NULL = "La date de début de l'UV ne doit pas être null";
    public static final int UV_NB_MATIERE_MIN = 3;
    public static final String UV_MATIERE_NULL = "La matière ne doit pas être null";
    public static final String UV_MATIERE_ALREADY_EXIST = "La matière existe déjà dans l'UV";
    public static final String UV_MATIERE_UNKNOW = "La matière n'existe pas dans l'UV";
    public static final String JOURNEE_DATE_NULL = "La date de la journée ne doit pas être null";
    public static final String JOURNEE_COURS_NULL = "Le cours d'une journée ne doit pas être null";
    public static final int JOURNEE_NB_HEURE_MAX = 8;
    public static final String JOURNEE_NB_HEURE_ERROR = "Il y a trop d'heure de cours dans la journée";
    public static final String JOURNEE_COURS_ALREADY_EXIST = "Ce cours est déjà dans la journée";
    public static final String JOURNEE_COURS_PRESENT_A_CETTE_HEURE = "Il y a déjà un cours à ce moment la";
    public static final String FACADE_COURS_NULL = "Le cours est NULL";
    public static final String FACADE_COURS_ALREADY_EXIST = "Le cours existe déjà";
    public static final String FACADE_MATIERE_ALREADY_EXIST = "la matière existe déjà";
    public static final String FACADE_MATIERE_NULL = "la matière est null";
    public static final String MATIERE_COURS_NULL = "Le cours est NULL";
    public static final String FACADE_MATIERE_COURS_ERROR = "Impossible d'ajouter le cours à la matière";
    public static final String MATIERE_COURS_ALREADY_EXIST = "Le cours est déjà dans la matière";
    public static final String FACADE_UV_ALREADY_EXIST = "L'UV existe déjà";
    public static final String FACADE_UV_NULL = "L'UV est NULL";
    public static final String FACADE_UV_MATIERE_ERROR = "Impossible d'ajouter la matière à l'UV";
    public static final String UV_MATIERE_INVALID = "la matière est invalide";
    public static final String CONSTRUCTION_COURS_ERROR = "Impossible de créé le cours";
    public static final String CONSTRUCTION_MATIERE_ERROR = "Impossible de créé la matière";
    public static final String CONSTRUCTION_UNITE_VALEUR_ERROR = "Impossible de créé l'unite de valeur";
    public static final String CONSTRUCTION_JOURNEE_ERROR = "Impossible de créé la journée";
    public static final int NB_JOUR_SEMAINE = 5;
    public static final String MATIERE_TYPEMATIERE_NULL = "Le type de la Matière ne doit pas être null";
    public static final String UV_DATE_DEBUT_DIFF_LUNDI = "La date Début n'est pas un Lundi";

    private ConstanteMetier(){}

    public static final String COURS_ID_NULL = "L'Id du cours est null";


}
