package net.ent.etrs.bateau.model.utils;

import net.ent.etrs.bateau.model.references.ConstanteMetier;

public final class VerificationUtils {
    private VerificationUtils() {
    }
    public static boolean aUnChiffre(String pNom) {
        for (String s : ConstanteMetier.VALEUR_INTERDITE) {
            if (pNom.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
