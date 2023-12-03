package net.ent.etrs.kingdomino.references;

public final class ConstanteMetier {
    public static final int TAILLE_GRILLE = 5;
    public static final String TUILE_TYPE_TUILE_IS_NULL = "Le type de tuile ne peut pas être NULL";
    public static final String TUILE_NB_COURONNE_NEGATIF = "Le nombre de couronnes ne peut pas être négatif";
    public static final int NB_COURONNES_MAX = 3;
    public static final String TUILE_NB_COURONNE_TROP_ELEVE = "Le nombre de couronnes ne peut pas être supérieur à " + NB_COURONNES_MAX;
    public static final String JOUEUR_NOM_IS_NULL = "Le nom du joueur ne peut pas être NULL";
    public static final String JOUEUR_NOM_IS_BLANK = "Le nom du joueur ne peut pas être vide";
    public static final String JOUEUR_COULEUR_IS_NULL = "La couleur du joueur ne peut pas être NULL";
    public static final String JOUEUR_COULEUR_IS_BLANK = "La couleur du Joueur ne peut pas être vide";
    public static final String JOUEUR_TUILE_IS_NULL = "La tuile ne peut pas être un objet NULL";
    public static final String JOUEUR_SON_CHATEAU_IS_NULL = "Le chateau du joueur ne peut pas être NULL";

    private ConstanteMetier() {
    }
}