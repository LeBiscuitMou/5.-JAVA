package net.ent.etrs.bateau.start;

import net.ent.etrs.bateau.model.Bateau;
import net.ent.etrs.bateau.model.TypeBateau;

public class Lanceur {

    public static void main(String[] args) {



        TypeBateau classeTonnerre = new TypeBateau();
        classeTonnerre.nom = "Tonnerre";
        classeTonnerre.longueur = 60;
        classeTonnerre.tonnageMax = 60000f;

        TypeBateau classePA = new TypeBateau();
        classePA.nom = "PA";
        classePA.longueur = 400;
        classePA.tonnageMax = 100000f;


        Bateau b1 = new Bateau();
        b1.nom = "BPC";
        b1.nbEquipage = 2000;
        b1.tonnage = 50000f;
        b1.estPret = false;
        b1.classe = classeTonnerre;

        Bateau b2 = new Bateau();
        b2.nom = "PANG";
        b2.nbEquipage = 2000;
        b2.tonnage = 80000f;
        b2.estPret = false;
        b2.classe = classePA;


        System.out.println(b1.nom);
        System.out.println(b2.nom);
    }
}
