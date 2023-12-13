package net.ent.etrs.gestionLeague.models.entities.references;

import java.time.format.DateTimeFormatter;

public final class ConstantesMetier {
    public static final int NB_MIN_CHALLENGE = 10;
    public static final int NB_MIN_REWARD_PTS = 50;
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final String LEAGUE_CHALLENGE_NULL = "Le Challenge ne doit pas être null";
    public static final String LEAGUE_PERS_INVALID = "Le personnage est invalide";
    public static final String LEAGUE_NOM_INCORRECT = "Le nom ne doit pas être null ou vide";
    public static final String LEAGUE_DATEDEBUT_NULL = "La date de début ne doit pas être null";
    public static final String CHALLENGE_REWARDPTS_NULL = "Le nombre de points ne doit pas être null";
    public static final String CHALLENGE_REWARDPTS_NEGATIF = "Le nombre de points doit être positif";
    public static final String CHALLENGE_NOM_INCORRECT = "le nom ne doit pas être null ou vide";
    public static final String PERSONNAGE_NOM_INCORRECT = "le nom ne doit pas être null ou vide";
    public static final String PERSONNAGE_LEVEL_NULL = "Le level du personnage ne doit pas être null";
    public static final Integer PERSONNAGE_LEVEL_MIN = 1;
    public static final Integer PERSONNAGE_LEVEL_MAX = 100;
    public static final String PERSONNAGE_LEVEL_ERROR = "le level du personnage doit être entre : " + PERSONNAGE_LEVEL_MIN + " et " + PERSONNAGE_LEVEL_MAX;
    public static final String PERSONNAGE_BUILD_NULL = "le build ne doit pas être null";
    public static final String CONSTRUCTION_LEAGUE_ERROR = "La league ne peut pas être construite";
    public static final String CONSTRUCTION_CHALLENGE_ERROR = "Impossible de fabriquer le challenge";
    public static final String CONSTRUCTION_PERSONNAGE_ERROR = "Impossible de fabriquer le personnage";
    public static final int NB_CARACTERES_MIN = 5;
    public static final String LEAGUE_NOM_TROP_COURT = "Le nom doit faire minimum " + NB_CARACTERES_MIN + " caractères";
    public static final String LEAGUE_DATEDEBUT_INVALIDE = "La date de début ne peut pas être après la date de fin";
    public static final String FACADE_PERSONNAGE_ERROR_SAVE_DAO = "Impossible de créer le personnage";
    public static final String FACADE_CHALLENGE_ERROR_SAVE_DAO = "Impossible de créer le challenge";
    public static final String FACADE_LEAGUE_ERROR_SAVE_DAO = "Impossible de créer la league";
    public static final String FACADE_PERSONNAGE_ERROR_FIND_ALL_DAO = "Impossible de trouver tous les personnages";
    public static final String FACADE_CHALLENGE_ERROR_FIND_ALL_DAO = "Impossible de trouver tous les challenges";
    public static final String FACADE_LEAGUE_ERROR_FIND_ALL_DAO = "Impossible de trouver toutes les leagues";
    public static final String FACADE_PERSONNAGE_NULL = "Personnage est null";
    public static final String FACADE_CHALLENGE_NULL = "Challenge est null";
    public static final String FACADE_LEAGUE_NULL = "League est null";
    public static final String INIT_ERROR = "Impossible d'initialiser";

    private ConstantesMetier() {
    }
}