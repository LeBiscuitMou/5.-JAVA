package net.ent.etrs.kingdomino.models.entities.references;

public final class ConstanteMetier {

    public static final int NB_MAX_COURONNE = 3;
    public static final String TUILE_NB_COURONNE_ERROR = "Le nombre de couronne doit être compris entre 0 et "+NB_MAX_COURONNE;
    public static final String CONSTRUCTION_ERROR = "Impossible de créer la Tuile";
    public static final int NB_DOMINO_BY_JOUEUR = 24;
    public static final int NB_TUILE_BLE_SANS_CR = 21;
    public static final int NB_TUILE_BLE_1_CR = 5;
    public static final int NB_TUILE_EAU_SANS_CR = 12;
    public static final int NB_TUILE_EAU_1_CR = 6;
    public static final int NB_TUILE_FORET_SANS_CR = 16;
    public static final int NB_TUILE_FORET_1_CR = 6;
    public static final int NB_TUILE_PRAIRIE_SANS_CR = 10;
    public static final int NB_TUILE_PRAIRIE_1_CR = 2;
    public static final int NB_TUILE_PRAIRIE_2_CR = 2;
    public static final int NB_TUILE_MARAIS_SANS_CR = 6;
    public static final int NB_TUILE_MARAIS_1_CR = 2;
    public static final int NB_TUILE_MARAIS_2_CR = 2;
    public static final int NB_TUILE_MINE_SANS_CR = 1;
    public static final int NB_TUILE_MINE_1_CR = 1;
    public static final int NB_TUILE_MINE_2_CR = 3;
    public static final int NB_TUILE_MINES_3_CR = 1;
    public static final String JOUEUR_COULEUR_NULL = "La couleur du joueur ne doit pas être null";
    public static final String JOUEUR_NOM_NULL = "Le nom du joueur ne doit pas être null";
    public static final String JOUEUR_NOM_VIDE = "Le nom du joueur ne doit pas être null";
    public static final int NB_MAX_JOUEUR = 4;
    public static final String JOUEUR_POSITION_INCORRECT = "La posiotion du joueur est incorrect";
    public static final String CONSTRUCTION_JOUEUR_ERROR = "Impossible de créer le joueur";
    public static final String JOUEUR_IMPOSSIBLE_CHATEAU = "Impossible de poser le chateau";
    public static final String FACADE_JOUEUR_NULL = "Le Joueur est null";
    public static final String FACADE_JOUEUR_ALREADY_EXIST = "Le joueur existe déjà";
    public static final String SVG_TUILES_PARTIE_ERROR = "Impossible de sauvegarder la liste des Tuiles";

    private ConstanteMetier(){}
}
