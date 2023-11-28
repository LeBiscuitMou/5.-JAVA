package net.ent.etrs.poinsot.exemplePersonne.model.entities.references;

public final class ConstanteMetier {
    public static final String PERSONNE_NOM_NULL = "ERREUR : Le nom ne peut pas être NULL";
    public static final String PERSONNE_NOM_VIDE = "ERREUR : Le nom ne peut pas être vide";
    public static final String PERSONNE_PRENOM_NULL = "ERREUR : Le prenom ne peut pas être NULL";
    public static final String PERSONNE_PRENOM_VIDE = "ERREUR : Le prenom ne peut pas être vide";
    public static final String PERSONNE_DATE_NAISSANCE_NULL = "ERREUR : La date de naissance ne peut pas être NULL";
    public static final String PERSONNE_DATE_NAISSANCE_FUTUR = "ERREUR : La date de naissance ne peut pas être dans le futur";
    public static final String PERSONNE_VOITURE_NULL = "ERREUR : La voiture ne peut pas être NULL";
    public static final String PERSONNE_VOITURE_DEJA_PRESENT = "ERREUR : La voiture est déjà présente dans la liste de voitures";
    public static final String PERSONNE_VOITURE_PAS_PRESENT = "ERREUR : La voiture n'existe pas dans la liste";
    public static final String CONSTRUCTION_PERSONNE_ERROR = "ERREUR : Impossible de créer une Personne";
    public static final String VOITURE_IMMAT_NULL = "ERREUR : L'immatriculation de la voiture ne peut pas être NULL";
    public static final String VOITURE_IMMAT_VIDE = "ERREUR : L'immatriculation de la voiture ne peut pas être vide";
    public static final String FACADE_SVG_PERSONNE = "ERREUR : Impossible de sauvegarder une personne";
    public static final String FACADE_PERSONNE_EXISTE_DEJA = "ERREUR : La personne est déjà présente dans la liste";

    private ConstanteMetier() {
    }
}
