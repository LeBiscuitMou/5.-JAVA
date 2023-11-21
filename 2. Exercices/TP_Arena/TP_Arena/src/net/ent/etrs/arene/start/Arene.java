package net.ent.etrs.arene.start;

import net.ent.etrs.arene.model.*;
import net.ent.etrs.arene.model.exceptions.FactoryException;

public class Arene {
    public static void main(String[] args) {
        try {
            Thrace spartacus = (Thrace) EntitiesFactory.entrainerThrace("Spartacus", 3);
            Mirmillon crixus = (Mirmillon) EntitiesFactory.entrainerMirmillon("Crixus", 3);
            Crepulaire oenomaus = (Crepulaire) EntitiesFactory.entrainerCrepulaire("Oenomaus", 3);
            Thrace fulgurT = (Thrace) EntitiesFactory.entrainerThrace("Fulgur", 1);
            Mirmillon polydromos = (Mirmillon) EntitiesFactory.entrainerMirmillon("Polydromos", 1);
            Crepulaire fulgurC = (Crepulaire) EntitiesFactory.entrainerCrepulaire("Fulgur", 1);
            Thrace faustus = (Thrace) EntitiesFactory.entrainerThrace("Faustus", 1);
            Crepulaire heracles = (Crepulaire) EntitiesFactory.entrainerCrepulaire("Heraclès", 2);
            Mirmillon victor = (Mirmillon) EntitiesFactory.entrainerMirmillon("Victor", 1);
            Thrace gannicus = (Thrace) EntitiesFactory.entrainerThrace("Gannicus", 3);
            Mirmillon verus = (Mirmillon) EntitiesFactory.entrainerMirmillon("Verus", 2);
            Crepulaire priscus = (Crepulaire) EntitiesFactory.entrainerCrepulaire("Priscus", 2);

            Gladiateur[] gladiateurs = new Gladiateur[]{spartacus, crixus, oenomaus, fulgurT, polydromos, fulgurC, faustus, heracles, victor, gannicus, verus, priscus};

        } catch (FactoryException e) {
            System.out.println(e.getMessage());
        }
    }
}