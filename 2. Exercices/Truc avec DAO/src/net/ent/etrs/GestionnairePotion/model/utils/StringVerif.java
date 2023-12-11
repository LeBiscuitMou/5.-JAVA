package net.ent.etrs.GestionnairePotion.model.utils;



import net.ent.etrs.GestionnairePotion.model.utils.exceptions.StringVerifException;
import net.ent.etrs.GestionnairePotion.model.utils.references.ConstUtils;

import java.util.Objects;

public final class StringVerif {
    private StringVerif() {    }

    /**
     * Vérifie que le string n'est pas null ou vide.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierString(String string) throws StringVerifException {
        if (Objects.isNull(string)){
            throw new StringVerifException(ConstUtils.ERROR_STRING_NULL);
        }
        if( string.isBlank()){
            throw new StringVerifException(ConstUtils.ERROR_STRING_EMPTY);
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
     * @throws StringVerifException l'exception
     */
    public static void verifierStringAvecMaximum(String string, int maximumLength) throws StringVerifException {
        verifierString(string);
        verifierSizeMax(string, maximumLength);
    }

    /**
     * Vérifie que le string n'est pas null ou vide, et qu'il ne soit pas ni trop grand, ni trop petit.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierString(String string, int minimumLength, int maximumLength) throws StringVerifException {
        verifierString(string);
        verifierSizeMin(string, minimumLength);
        verifierSizeMax(string, maximumLength);
    }

    public static void verifierStringAlphanum(String string) throws StringVerifException {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetterOrDigit(string.charAt(i))){
                throw new StringVerifException(ConstUtils.ERROR_STRING_CONTAIN_NON_ALPHANUMERIC);
            }
        }
    }

    public static void verifierStringAlpha(String string) throws StringVerifException {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i))){
                throw new StringVerifException(ConstUtils.ERROR_STRING_CONTAIN_NON_ALPHABETIC);
            }
        }
    }

    public static void verifierStringNumeric(String string) throws StringVerifException {
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))){
                throw new StringVerifException(ConstUtils.ERROR_STRING_CONTAIN_NON_NUMERIC);
            }
        }
    }

    /* **************************** PRIVATE FUNCTIONS **************************** */
    private static void verifierSizeMin(String string, int minimumLength) throws StringVerifException {
        if (string.length() < minimumLength){
            throw new StringVerifException(ConstUtils.ERROR_STRING_MIN_SIZE);
        }
    }

    private static void verifierSizeMax(String string, int maximumLength) throws StringVerifException {
        if (string.length() > maximumLength) {
            throw new StringVerifException(ConstUtils.ERROR_STRING_MAX_SIZE);
        }
    }
}
