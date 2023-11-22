package net.ent.etrs.rafale.model.references;

public final class ConstantesMetier {

    public static final String RAFALE_METIER_IDENTIFICATION_EXCEPTION = "L'identifiant est Incorrect";
    public static final short NOMBRE_PILOTE_MAX = 2;
    public static final String RAFALE_METIER_CARBURANT_MINI = "Le carburant saisie doit être positif";
    public static final String RAFALE_METIER_CARBURANT_MAX_INTERNE = "Le carburant dépasse la capacité max interne";
    public static final String RAFALE_METIER_BOMBE_NULL = "La bombe ne peut pas être null";
    public static final String RAFALE_METIER_BOMBE_LOURD = "La bombe est trop lourd pour l'emporte sur ce Rafale";
    public static final String RAFALE_METIER_MISSILE_NULL = "Le missile ne peut pas être null";
    public static final String RAFALE_METIER_MISSILE_LOURD = "Le missile est trop lourd pour être embarqué sur ce Rafale";
    public static final String RAFALE_DAO_RAFALE_NULL = "Le Rafale ne peut être null";
    public static final String RAFALE_DAO_RAFALE_EXIST = "Le Rafale existe déjà dans la base de donnée";
    public static final String RAFALE_DAO_RAFALE_NOT_EXIST = "Le Rafale n'existe pas dans la base de donnée";
    public static final String RAFALE_DAO_AJOUT_MISSILE = "Impossible d'ajouter le Missile";
    public static final String RAFALE_DAO_AJOUT_BOMBE = "Impossible d'ajouter la Bombe";
    public static final String RAFALE_DAO_IDENTIFICATION_NULL = "L'identification du Rafal est null";
    public static final String NOM_MENU_PRINCIPAL = "Gestion RAFALE";
    public static final String RAFALE_METIER_NOT_CREATE = "Impossible de créer le Rafale";
    public static final String RAFALE_METIER_MISSILE_NUC = "Un Rafale avec Arme nucléaire ne peut pas possèder d'armement supplémentaire";
    public static final int POIDS_MAXIMUM_RAFALE = 9500;
    public static final int NOMBRE_MAXIMUM_DE_MISSILES_AA = 9;
    public static final int CARBURANT_POIDS_MAXIMUM = 4500;
    public static short NOMBRE_PILOTE_MINI = 1;
    public static final int NOMBRE_MAXIMUM_DE_BOMBES = 5;
    public static final String RAFALE_METIER_NOMBRE_PILOTE = String.format("Nombre de pilote saisie n'est pas compris entre %s et %s.", NOMBRE_PILOTE_MINI, NOMBRE_PILOTE_MAX);

    private ConstantesMetier() {
    }

}
