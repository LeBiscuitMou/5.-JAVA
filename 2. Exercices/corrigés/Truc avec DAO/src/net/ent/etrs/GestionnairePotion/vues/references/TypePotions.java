package net.ent.etrs.GestionnairePotion.vues.references;

public enum TypePotions {
    /**
     * À ranger dans l'ordre de l'index le plus petit au plus grand,
     * l'index le plus petit doit être en haut de la liste.
     */
    VIE("potion de vie"),
    DEGAT("potion de dégat"),
    AMELIORATION("potion d'amélioration");

    private final String option;

    TypePotions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
