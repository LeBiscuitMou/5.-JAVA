package net.ent.etrs.projet.model.utils;



import net.ent.etrs.projet.model.utils.exceptions.StringVerifException;
import net.ent.etrs.projet.model.utils.references.ConstanteUtils;

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
            throw new StringVerifException(ConstanteUtils.ERROR_STRING_NULL);
        }
        if( string.isBlank()){
            throw new StringVerifException(ConstanteUtils.ERROR_STRING_EMPTY);
        }
    }

    /**
     * Vérifie que le string n'est pas null ou vide et qu'il ne soit pas trop petit.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierStringAvecMinimum(String string, int minimumLength) throws StringVerifException {
        verifierString(string);
        if (string.length() < minimumLength){
            throw new StringVerifException(ConstanteUtils.ERROR_STRING_MIN_SIZE);
        }

    }

    /**
     * Vérifie que le string n'est pas null ou vide et qu'il ne soit pas trop grand.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierStringAvecMaximum(String string, int maximumLength) throws StringVerifException {
        verifierString(string);
        if (string.length() > maximumLength) {
            throw new StringVerifException(ConstanteUtils.ERROR_STRING_MAX_SIZE);
        }
    }

    /**
     * Vérifie que le string n'est pas null ou vide, et qu'il ne soit pas ni trop grand, ni trop petit.
     * @param string le string à vérifier
     * @throws StringVerifException l'exception
     */
    public static void verifierString(String string, int minimumLength, int maximumLength) throws StringVerifException {
        verifierStringAvecMaximum(string, maximumLength);
        verifierStringAvecMinimum(string, minimumLength);
    }
}
