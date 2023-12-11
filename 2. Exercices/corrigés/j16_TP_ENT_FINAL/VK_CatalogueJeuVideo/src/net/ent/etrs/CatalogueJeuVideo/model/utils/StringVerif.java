package net.ent.etrs.CatalogueJeuVideo.model.utils;

import net.ent.etrs.CatalogueJeuVideo.model.utils.exceptions.StringVerifException;

import java.util.Objects;

public final class StringVerif {
    /* ******************************** VARIABLES ******************************** */
    public static final String ERROR_STRING_NULL = "ERREUR, la chaine de caractère ne doit pas être null";
    public static final String ERROR_STRING_EMPTY = "ERREUR, la chaine de caractère ne doit pas être vide";;
    public static final String ERROR_STRING_MIN_SIZE = "ERREUR, la chaine de caractère est trop petite";
    public static final String ERROR_STRING_MAX_SIZE = "ERREUR, la chaine de caractère et trop grande";
    public static final String ERROR_STRING_CONTAIN_NON_ALPHANUMERIC = "ERREUR, la chaine de caractère ne contient pas que du alphanumérique";
    public static final String ERROR_STRING_CONTAIN_NON_ALPHABETIC = "ERREUR, la chaine de caractère ne contient pas que de l'alphabétique";
    public static final String ERROR_STRING_CONTAIN_NON_NUMERIC = "ERREUR, la chaine de caractère ne contient pas que du numérique";

    /* ******************************* CONSTRUCTOR ******************************* */
    private StringVerif() {    }

    /* ******************************** FONCTIONS ******************************** */
    /**
     * Vérifie que le string n'est pas null ou vide.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierString(String string) throws StringVerifException {
        if (Objects.isNull(string)){
            throw new StringVerifException( ERROR_STRING_NULL);
        }
        if( string.isBlank()){
            throw new StringVerifException( ERROR_STRING_EMPTY);
        }
    }

    /**
     * Vérifie que le string n'est pas null ou vide et qu'il ne soit pas trop petit.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierStringAvecMinimum(String string, int minimumLength) throws StringVerifException {
        verifierString(string);
        verifierSizeMin(string, minimumLength);

    }

    /**
     * Vérifie que le string n'est pas null ou vide et qu'il ne soit pas trop grand.
     * @param string le string à vérifier
     * @param maximumLength la taille maximum autorisée
     * @throws StringVerifException l'exception
     */
    public static void verifierStringAvecMaximum(String string, int maximumLength) throws StringVerifException {
        verifierString(string);
        verifierSizeMax(string, maximumLength);
    }

    /**
     * Vérifie que le string n'est pas null ou vide, et qu'il ne soit pas ni trop grand, ni trop petit.
     * @param string le string à vérifier
     * @param minimumLength la taille minimum autorisée
     * @param maximumLength la taille maximum autorisée
     * @throws StringVerifException l'exception
     */
    public static void verifierString(String string, int minimumLength, int maximumLength) throws StringVerifException {
        verifierString(string);
        verifierSizeMin(string, minimumLength);
        verifierSizeMax(string, maximumLength);
    }

    /**
     * Vérifie qu'un string donné soit entièrement constitué de nombre ou de lettres.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierStringAlphanum(String string) throws StringVerifException {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetterOrDigit(string.charAt(i))){
                throw new StringVerifException(ERROR_STRING_CONTAIN_NON_ALPHANUMERIC);
            }
        }
    }
    /**
     * Vérifie qu'un string donné soit entièrement constitué de lettres.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierStringAlpha(String string) throws StringVerifException {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i))){
                throw new StringVerifException(ERROR_STRING_CONTAIN_NON_ALPHABETIC);
            }
        }
    }
    /**
     * Vérifie qu'un string donné soit entièrement constitué de nombre.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierStringNumeric(String string) throws StringVerifException {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))){
                throw new StringVerifException(ERROR_STRING_CONTAIN_NON_NUMERIC);
            }
        }
    }

    /* **************************** PRIVATE FUNCTIONS **************************** */

    /**
     * Vérifie qu'un string donné ne soit pas plus petit qu'une certaine taille.
     * @param string le string à vérifier
     * @param minimumLength la taille minimum autorisée
     * @throws StringVerifException l'exception
     */
    private static void verifierSizeMin(String string, int minimumLength) throws StringVerifException {
        if (string.length() < minimumLength){
            throw new StringVerifException(ERROR_STRING_MIN_SIZE);
        }
    }

    /**
     * Vérifie qu'un string donné ne dépasse pas une certaine taille.
     * @param string le string à vérifier
     * @param maximumLength la taille maximum autorisée
     * @throws StringVerifException l'exception
     */
    private static void verifierSizeMax(String string, int maximumLength) throws StringVerifException {
        if (string.length() > maximumLength) {
            throw new StringVerifException(ERROR_STRING_MAX_SIZE);
        }
    }
}
