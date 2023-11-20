package net.ent.etrs.groupeMusique.model.utils;

import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;

public final class VerificationUtils {

    private VerificationUtils() {
    }

    public static boolean aUnChiffre(String pNom){
        for (String s: ConstantesMetier.VALEUR_INTERDITE) {
            if(pNom.contains(s)){
                return true;
            }
        }
        return false;
    }
}
