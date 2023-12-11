package net.ent.etrs.GestionnairePotion.vues.references;

public enum ListeOptions {
    /**
     * À ranger dans l'ordre de l'index le plus petit au plus grand,
     * l'index le plus petit doit être en haut de la liste.
     */
    QUITTER(0, "quitter"),
    OPTION_1(1, "afficher toutes les potions"),
    OPTION_2(2, "afficher tous les ingrédients"),
    OPTION_3(3, "créer une potion"),
    OPTION_4(4, "créer un ingrédient"),
    OPTION_5(5, "supprimer une potion");

    private final int index;
    private final String option;

    ListeOptions(int index, String option) {
        this.option = option;
        this.index = index;
    }

    public String getOption() {
        return option;
    }

    public int getIndex() {
        return index;
    }
}
