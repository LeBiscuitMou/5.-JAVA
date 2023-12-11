package net.ent.etrs.CatalogueJeuVideo.model.references;

public enum Couleur {

    /**
     * exemple enum complexe.
     */
    BLEU("Bleu"),
    ROUGE("Rouge"),
    ORANGE("Orange"),
    VERT("Vert"),
    VIOLET("Violet"),
    BLANC("Blanc"),
    NOIR("Noir"),
    MARRON("Marron"),
    CYAN("Cyan"),
    JAUNE("Jaune"),
    ROSE("Rose"),
    MAGENTA("Magenta");

    private final String libelle;

    Couleur(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
