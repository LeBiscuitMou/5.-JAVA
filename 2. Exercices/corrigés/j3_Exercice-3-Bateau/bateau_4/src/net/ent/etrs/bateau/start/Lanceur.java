package net.ent.etrs.bateau.start;

import net.ent.etrs.bateau.model.Armement;
import net.ent.etrs.bateau.model.Bateau;
import net.ent.etrs.bateau.model.TypeBateau;
import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.references.ConstanteMetier;

public class Lanceur {

    public static void main(String[] args)  {


        TypeBateau classeTonnerre = new TypeBateau("Tonnerre",60,60000f);
        TypeBateau classePA = new TypeBateau("PA",400,100000f);

        try {
           Bateau b1 = new Bateau("BPC",2000,50000f,false,classeTonnerre);
            Bateau b2 = new Bateau("PANG",2000,80000f,false,classePA);
            Bateau b3 = new Bateau("PANG",2000,80000f,false,classePA);

            System.out.println(b1);
            System.out.println(b2);

            System.out.println(b2.equals(b3));
            System.out.println(b2==b3);


//        b3.ajouterArmement(new Armement("toto",1.5f,500));
//        System.out.println(b3.getArmesBateau()[0]);
//        b3.getArmesBateau()[0] = new Armement("tata",1.8f,600);
//        System.out.println(b3.getArmesBateau()[0]);

        } catch (BateauException e) {
            System.out.println("Error technique contacter votre administrateur");
        }




    }
}
