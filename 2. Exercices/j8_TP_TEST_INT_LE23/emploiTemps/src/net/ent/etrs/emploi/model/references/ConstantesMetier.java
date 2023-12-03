package net.ent.etrs.emploi.model.references;

public final class ConstantesMetier {
    public static final String UNITE_VALEUR_NOM_IS_NULL = "Le nom du cours ne peut pas être null";
    public static final String UNITE_VALEUR_NOM_IS_BLANK = "Le nom ne peut pas être vide";
    public static final String UNITE_VALEUR_DATE_DEBUT_IS_NULL = "La date de début d'UV ne peut pas être null";
    public static final String UNITE_VALEUR_DATE_DEBUT_IS_BEFORE_NOW = "La date de début d'UV ne peut pas être avant la date du jour";
    public static final int NOMBRE_MATIERES_MINIMUM = 3;
    public static final String UNITE_VALEUR_EST_VALIDE_ERROR = "Il faut que l'UV possède au minimum 3 matières";
    public static final String UNITE_VALEUR_LISTE_MATIERES_IS_NULL = "La liste des matières est null";
    public static final String MATIERE_NOM_IS_NULL = "Le nom de la matière ne peut pas être null";
    public static final String MATIERE_NOM_IS_BLANK = "Le nom de la matière ne peut pas être vide";
    public static final String FACTORY_UNITE_VALEUR_ERROR = "Impossible de créer un UV";
    public static final String FACTORY_MATIERE_ERROR = "Impossible de créer la matière";
    public static final String UNITE_VALEUR_OBJECT_NULL = "L'uv est un objet NULL";
    public static final String UNITE_VALEUR_OBJECT_EXIST = "L'uv existe déjà dans la liste des UV";
    public static final String MATIERE_OBJECT_NULL = "La matière est un objet null";
    public static final String TYPE_MATIERE_OBJECT_NULL = "Le type de matière est un objet NULL";
    public static final String COURS_OBJECT_NULL = "Le cours est un objet NULL";
    public static final String ID_COURS_OBJECT_NULL = "L'id cours est NULL";
    public static final String ID_COURS_OBJECT_IS_BLANK = "L'id cours ne peut pas être vide";
    public static final String COURS_DUREE_NEGATIF_0 = "La durée du cours ne peut ni être négative, ni à 0";
    public static final int DUREE_MAX_COURS = 4;
    public static final String COURS_DUREE_TROP_LONGUE = "La durée du cours dépasse la durée maximum de " + DUREE_MAX_COURS + " heures";
    public static final String COURS_HEURE_DEBUT_IS_NULL = "Le début de l'heure de cours ne peut pas être null";
    public static final int HEURE_DEBUT_JOURNEE = 8;
    public static final String COURS_HEURE_DEBUT_AVANT_DEBUT_JOURNEE = "Le début de l'heure de cours ne peut pas être avant " + HEURE_DEBUT_JOURNEE + " h";
    public static final int HEURE_FIN_JOURNEE = 17;
    public static final String COURS_HEURE_FIN_APRES_FIN_JOURNEE = "La fin de l'heure de cours ne peut pas être après 17h";
    public static final int HEURE_PAUSE_MIDI = 12;
    public static final int MINUTE_PAUSE_MIDI = 0;
    public static final String COURS_HEURE_PAUSE_DE_MIDI_FAIM = "Il est impossible d'avoir un début de cours pendant la pause de midi. Parce qu'il y a des frites !";
    public static final String FACTORY_COURS_ERROR = "Impossible de créer le cours";
    public static final String MATIERE_CODE_MATIERE_NEGATIF = "Le code de la matière ne peut pas être négatif";
    public static final String MATIERE_NOMBRE_HEURES_MATIERE_NEGATIF = "Le nombre d'heures de matières ne peut pas être négatif";
    public static final int NOMBRE_HEURES_MATIERE_MINIMUM = 10;
    public static final String MATIERE_NOMBRE_HEURES_INSUFFISANT = "Le nombre d'heures de cours de cette matière est insuffisant, il faut minimum " + NOMBRE_HEURES_MATIERE_MINIMUM + " heures";
    public static final int NOMBRE_HEURES_MATIERE_MAXIMUM = 100;
    public static final String MATIERE_NOMBRE_HEURES_EXCESSIF = "Le nombre d'heures de cours est beaucoup trop élevé pour de simple stagiaires. Il faut réduire à " + NOMBRE_HEURES_MATIERE_MAXIMUM + " heures";
    public static final String MATIERE_CODE_MATIERE_IS_NULL = "Le code de la matière ne peut pas être NULL";
    public static final String MATIERE_CODE_MATIERE_IS_BLANK = "Le code de la matière ne peut pas être vide";
    public static final String JOURNEE_JOUR_SEMAINE_IS_NULL = "Le jour de la semaine ne peut pas être NULL";

    private ConstantesMetier() {
    }
}
