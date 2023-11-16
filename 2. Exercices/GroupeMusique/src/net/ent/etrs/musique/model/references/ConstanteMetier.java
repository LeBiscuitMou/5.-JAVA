package net.ent.etrs.musique.model.references;

public final class ConstanteMetier {
    public static final String[] FORBIDDEN_SYMBOL = new String[]{ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };;

    // EXCEPTION SUR PERSONNE nom
    public static final String PERSONNE_NOM_ERROR_NULL = "ERREUR Personne: le nom est null";
    public static final String PERSONNE_NOM_ERROR_EMPTY = "ERREUR personne: le nom est vide";
    public static final int PERSONNE_NOM_LONGUEUR_MAX = 30;
    public static final String PERSONNE_NOM_ERROR_SIZE = "ERREUR Personne: le nom est trop long et possède plus de 30 caractères";
    public static final String PERSONNE_NOM_ERROR_NUMBER = "ERREUR Personne: le nom possède des chiffres";

    // EXCEPTION SUR PERSONNE prenom
    public static final String PERSONNE_PRENOM_ERROR_NULL = "ERREUR Personne: le prénom est null";;
    public static final String PERSONNE_PRENOM_ERROR_EMPTY = "ERREUR Personne: le prénom est vide";
    public static final int PERSONNE_PRENOM_LONGUEUR_MAX = 30;
    public static final String PERSONNE_PRENOM_ERROR_SIZE = "ERREUR Personne: le prénom est trop long et possède plus de 30 caractères";;
    public static final String PERSONNE_PRENOM_ERROR_NUMBER = "ERREUR Personne: le prénom possède des chiffres";

    // EXCEPTION SUR PERSONNE sexe
    public static final String PERSONNE_SEXE_ERROR_NULL = "ERREUR Personne: le sexe est null";

    private ConstanteMetier() {
    }
}