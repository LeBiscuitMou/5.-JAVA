package net.ent.etrs.bateau.start;

import net.ent.etrs.bateau.model.Armement;
import net.ent.etrs.bateau.model.Bateau;
import net.ent.etrs.bateau.model.TypeBateau;
import net.ent.etrs.bateau.model.exceptions.ArmementException;
import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.TypeBateauException;

//import java.util.UUID;


/*
    4 armements max;

 */
public class Lanceur {
    public static void main(String[] args) {
        TypeBateau claBa1, claBa2;
        try {
            claBa1 = new TypeBateau("croiseur",1000,120000F);
            claBa2 = new TypeBateau("croiseur",1000,90000F);
        } catch (TypeBateauException e) {
            throw new RuntimeException(e);
        }


        Armement arme1, arme2, arme3, arme4, arme5, arme6, arme7;
        try {
            arme1 = new Armement("AA", 30.0F, 1000);
            arme2 = new Armement("lance-roquette", 100.0F, 1000);
            arme3 = new Armement("lance-torpille", 100.0F, 1000);
            arme4 = new Armement("lance-patate", 30.0F, 1000);
            arme5 = new Armement("lance-lance", 30.0F, 1000);
            arme6 = new Armement("lance-iceberg", 30.0F, 1000);
            arme7 = new Armement("lance-laitue", 30.0F, 1000);
        } catch (ArmementException e) {
            throw new RuntimeException(e);
        }


        Bateau b1, b2, b3;
        try {
            b1 = new Bateau("Invincible", claBa1, 2000, 40000F);
            b2 = new Bateau("Hildegarde", claBa2, 800, 20000F);
            b3 = new Bateau("Hildegarde", claBa2, 800, 20000F);
        } catch (BateauException e) {
            throw new RuntimeException(e);
        }

        try {
            b1.ajouterArmements(arme2);
            b1.ajouterArmements(arme5);
            b1.ajouterArmements(arme6);
            b1.ajouterArmements(arme7);

            b2.ajouterArmements(arme1);
            b2.ajouterArmements(arme2);

            b3.ajouterArmements(arme3);
        } catch (BateauException e) {
            throw new RuntimeException(e);
        }


        System.out.println(b1);
        System.out.println(b2);

        System.out.println(b2.equals(b3));

        System.out.println(b2.getArmement()[1]);

        try {
            b2.changerArmements(arme4, 1);
        } catch (BateauException e) {
            throw new RuntimeException(e);
        }

        System.out.println(b2.getArmement()[1]);

        System.out.println("toutes les armes du bateau " + b1.getNom() + ":\n" + b1.getAllArmement());
    }

}
