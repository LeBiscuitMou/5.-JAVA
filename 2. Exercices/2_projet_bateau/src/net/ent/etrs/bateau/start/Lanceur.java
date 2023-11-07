package net.ent.etrs.bateau.start;


import net.ent.etrs.bateau.model.Armement;
import net.ent.etrs.bateau.model.Bateau;
import net.ent.etrs.bateau.model.TypeBateau;
import net.ent.etrs.bateau.model.exception.BateauException;

public class Lanceur {
    public static void main(String[] args) {
        TypeBateau classeTonnerre = new TypeBateau("Tonnerre", 21, 12);

        try {
            Bateau b2 = new Bateau("Poulet", 12, 8f, true, classeTonnerre);
        } catch (BateauException e) {
            System.out.println("Erreur technique, veuillez contacter l'administrateur");
        }
        System.out.println();
    }
}