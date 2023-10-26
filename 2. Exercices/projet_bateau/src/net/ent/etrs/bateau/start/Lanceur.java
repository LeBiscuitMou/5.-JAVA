package net.ent.etrs.bateau.start;

import net.ent.etrs.bateau.model.Bateau;
import net.ent.etrs.bateau.model.TypeBateau;

public class Lanceur {
    public static void main(String[] args) {
        TypeBateau fregate = new TypeBateau("fregate", 256, 2);
        Bateau alsace = new Bateau("Alsace", 500, 1, true, fregate);

        TypeBateau porteAvion = new TypeBateau("Porte avion", 1000, 5);
        Bateau cdg = new Bateau("Charle de Gaulle", 10_000, 4, false, porteAvion);
    }
}