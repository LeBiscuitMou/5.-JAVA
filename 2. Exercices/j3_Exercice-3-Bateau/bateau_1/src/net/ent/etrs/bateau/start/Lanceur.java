package net.ent.etrs.bateau.start;

import net.ent.etrs.bateau.model.Bateau;
import net.ent.etrs.bateau.model.TypeBateau;

public class Lanceur {

    public static void main(String[] args) {


        TypeBateau classeTonnerre = new TypeBateau("Tonnerre",60,60000f);
        TypeBateau classePA = new TypeBateau("PA",400,100000f);

        Bateau b1 = new Bateau("BPC",2000,50000f,false,classeTonnerre);
        Bateau b2 = new Bateau("PANG",2000,80000f,false,classePA);
        Bateau b3 = new Bateau("PANG",2000,80000f,false,classePA);



        System.out.println(b1);
        System.out.println(b2);

        System.out.println(b2 == b3);
    }
}
