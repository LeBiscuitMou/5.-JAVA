package net.ent.etrs.CatalogueJeuVideo.views.references;

public final class ConstView {
    public static final String NOM_PROGRAMME = "Gestionnaire de jeux vidéos et consoles";
    public static final String MESSAGE_SORTIE_PROGRAMME = "sortie du gestionnaire";
    public static final String BLANC = "     ";
    public static final String[] MENU = {
            "Créer une Console",
            "Créer un Fabriquant",
            "Créer un Jeu Video",
            "Ajouter une console a un jeu video",
            "Afficher les jeux video par un Genre",
            "Afficher les jeux video par Console",
            "Afficher toutes les Consoles avec leurs jeux video",
            "Quitter le programme"
    };
    public static final String OUI_NON = "OUI ou NON ?";
    public static final String SAISIR_CONSOLE = BLANC.repeat(2) + "saisie d'une console : ";
    public static final String SAISIR_JEU_VIDEO = BLANC.repeat(2) + "saisie d'un jeu vidéo : ";
    public static final String SAISIR_FABRIQUANT = BLANC.repeat(2) + "saisie d'un fabriquant : ";
    public static final String CHOISIR_CONSOLE = "choisissez la console :";
    public static final String CHOISIR_GENRE = "choisissez le genre :";
    public static final String CHOISIR_FABRIQUANT = "choisissez le fabriquant :";
    public static final String SAISIE_NOM = "saisissez le nom :";
    public static final String CHOISIR_PAYS = "choisissez le pays :";
    public static final String CHOISIR_JEU_VIDEO = "choisissez le jeu vidéo :";

    private ConstView() {

    }
}
