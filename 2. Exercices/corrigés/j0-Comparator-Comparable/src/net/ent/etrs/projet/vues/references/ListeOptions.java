package net.ent.etrs.projet.vues.references;

public enum ListeOptions {
    OPTION_1("option"),
    OPTION_2("option"),
    OPTION_3("option"),
    OPTION_4("option");

    private final String option;

    ListeOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}
