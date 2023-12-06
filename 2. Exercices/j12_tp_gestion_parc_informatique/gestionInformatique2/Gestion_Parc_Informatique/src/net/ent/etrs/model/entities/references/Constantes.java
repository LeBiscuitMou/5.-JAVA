package net.ent.etrs.model.entities.references;

public final class Constantes {

    private Constantes() {
    }

    public static final String[] MENU = {
            "Créer un matériel informatique",
            "Suppimer un matériel informatique",
            "Lister tous les matériels informatique",
            "Affecter un matériel informatique dans une pièce",
            "Lister les matériels informatique d'un bâtiment"
    };

    public static final String[] TYPE_MATERIEL_INFORMATIQUE = {"Ordinateur","Ecran"};

    public static final String DAO_BATIMENT_MODIFICATION_EXCEPTION = "Une erreure est survenue lors de la mise à jour des données du bâtiment.";
    public static final String DAO_BATIMENT_EXIST_EXCEPTION = "Le bâtiment existe déjà.";
    public static final String DAO_BATIMENT_CREATION_EXCEPTION = "Une erreure est survenue lors de l'enregistrement du bâtiment.";
    public static final String DAO_BATIMENT_SUPPRESSION_EXCEPTION = "Une erreure est survenue lors de la suppression du bâtiment.";
    public static final String DAO_BATIMENT_EXIST_PAS_EXCEPTION = "Le bâtiment n'existe pas.";
    public static final String DAO_BATIMENT_EXIST_NULL_EXCEPTION = "Une erreure est survenue lors de la recherche du bâtiment.";
    public static final String DAO_MATERIEL_INFORMATIQUE_MODIFICATION_EXCEPTION = "Une erreure est survenue lors de la mise à jour des données du matériel informatique.";
    public static final String DAO_MATERIEL_INFORMATIQUE_EXIST_NULL_EXCEPTION = "Une erreure est survenue lors de la recherche du matériel informatique.";
    public static final String DAO_MATERIEL_INFORMATIQUE_EXIST_PAS_EXCEPTION = "Le matériel n'existe pas.";
    public static final String DAO_MATERIEL_INFORMATIQUE_SUPPRESSION_EXCEPTION = "Une erreure est survenue lors de la suppression du matériel informatique.";
    public static final String DAO_MATERIEL_INFORMATIQUE_EXIST_EXCEPTION = "Le matériel existe.";
    public static final String DAO_MATERIEL_INFORMATIQUE_CREATION_EXCEPTION = "Une erreure est survenue lors de l'enregistrement des données du matériel informatique.";


    public static final String SAISIR_NUM_SERIE = "Veuillez saisir le numéro de série du matériel (sous 8 caractères):";
    public static final String PATTERN_DATE = "dd/MM/yyyy";
    public static final String SAISIR_DATE_GARANTIE = String.format("Veuillez saisir la date de garantie du matériel (au format : %s):",Constantes.PATTERN_DATE);
    public static final String MSG_ERREUR_SAISIE_MATERIEL = "Une erreure est survenue lors de la création du matériel.";
    public static final String MSG_CREATION_MATERIEL_REUSSITE = "Le matériel a bien été créé.";
    public static final String MSG_LISTE_MATERIEL_BATIMENT_VIDE = "Aucun matériel informatique dans ce bâtiment.";
    public static final String MSG_LISTE_MATERIEL_NON_AFFECTE_VIDE = "Aucun matériel informatique disponible.";
    public static final String MSG_NUM_SERIE_NULL_EXCEPTION = "Le numéro de série doit être renseigné.";
    public static final String MSG_TAILLE_ECRAN_ECXEPTION = "La taille de l'écran doit être renseignée.";
    public static final String MSG_NUM_SERIE_LENGTH_EXCEPTION = String.format("Le numéro de série doit contenir %d caractères.", Constantes.LONGUEUR_NUM_SERIE);
    public static final String MSG_DATE_GARANTIE_NULL_EXCEPTION = "La date de garantie doit être renseignée.";
    public static final String MSG_DATE_GARANTIE_PAST_EXCEPTION = "La date de garantie ne peut être dans le passé.";
    public static final int LONGUEUR_NUM_SERIE = 8;
    public static final String MSG_SUPPRESSION_MATERIEL_INFORMATIQUE_SUCCES = "Le matériel a bien été supprimé.";
    public static final String MSG_LISTE_BATIMENT_VIDE = "Auncun bâtiment existant.";
    public static final String MSG_SELECTION_BATIMENT = "Veuillez sélectionner un bâtiment :";
    public static final String MSG_LISTE_PIECE_VIDE = "Aucune pièce existante.";
    public static final String MSG_SELECTION_PIECE = "Veuillez sélectionner une pièce :";
}
