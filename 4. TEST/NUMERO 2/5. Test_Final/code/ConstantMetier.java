package net.ent.etrs.poeleague.model.entities.references;

import java.time.format.DateTimeFormatter;


public final class ConstantMetier {
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

    private ConstantMetier() {
    }
}
