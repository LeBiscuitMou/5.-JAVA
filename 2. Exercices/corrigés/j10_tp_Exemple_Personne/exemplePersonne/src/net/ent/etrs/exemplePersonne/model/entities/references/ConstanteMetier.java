package net.ent.etrs.exemplePersonne.model.entities.references;

public final class ConstanteMetier {
    public static final String PERSONNE_NOM_VIDE = "Le nom de la personne ne doit pas être vide";
    public static final String PERSONNE_PRENOM_NULL = "Le prénom ne doit pas être null";
    public static final String PERSONNE_PRENOM_VIDE = "Le prénom de la personne ne doit pas être vide";
    public static final String PERSONNE_DATE_NULL = "La date de naissance ne doit pas être null";
    public static final String PERSONNE_DATE_FUTUR = "La date de naissance ne doit pas être dans le futur";
    public static final String PERSONNE_VOITURE_NULL = "La voiture ne peut pas être null";
    public static final String PERSONNE_VOITURE_NOT_EXIST = "La voiture n'est pas présente dans la liste";
    public static final String PERSONNE_VOITURE_ALREADY_EXIST = "La voiture est déjà présente dans la liste";
    public static final String CONSTRUCTION_PERSONNE_ERROR = "Impossible de construire la personne";
    public static final String FACADE_SVG_PERSONNE_NULL = "La personne a sauvegardé ne doit pas être null";
    public static final String FACADE_SVG_PERSONNE_ALREADY_EXIST = "La personne est déjà présente dans la base de donnée";

    private ConstanteMetier() {
    }
    
    public static String PERSONNE_NOM_NULL = "Le nom ne doit pas être null";
}
