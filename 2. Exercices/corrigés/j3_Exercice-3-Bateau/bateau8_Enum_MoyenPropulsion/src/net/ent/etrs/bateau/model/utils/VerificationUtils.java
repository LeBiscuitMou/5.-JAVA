package net.ent.etrs.bateau.model.utils;

import net.ent.etrs.bateau.model.references.ConstantesMetier;

public class VerificationUtils {


    private VerificationUtils(){}

    public static boolean verificationStringContain(String nom){
        for (String symbol: ConstantesMetier.FORBIDDEN_SYMBOL) {
            if(nom.contains(symbol)) {
                return true;
            }
        }
        return false;
    }
}
