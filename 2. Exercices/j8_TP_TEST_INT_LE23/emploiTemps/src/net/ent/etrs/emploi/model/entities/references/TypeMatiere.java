package net.ent.etrs.emploi.model.entities.references;

public enum TypeMatiere {
    PROGRAMMATION("JAVA"),
    ANALYSE("ANASI"),
    CONCEPTION("COO"),
    ETUDIER("AD-CDSF"),
    BOUGER("Sport");

    private String nomMatiere;

    TypeMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }
}