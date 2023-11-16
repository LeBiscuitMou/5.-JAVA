package net.ent.etrs.musique.model.utils;

import net.ent.etrs.musique.model.references.ConstanteMetier;

public class VerificationUtils {
    private VerificationUtils() {

    }

    public static boolean verificationStringContain(String nom){
        for (String symbol: ConstanteMetier.FORBIDDEN_SYMBOL) {
            if(nom.contains(symbol)) {
                return true;
            }
        }
        return false;
    }
}