package net.ent.etrs.demostring.start;

import net.ent.etrs.demostring.start.exceptions.PersonneException;

import java.time.LocalDate;

public class Demo {

    public static void main(String[] args) {
        String str = "fdsfdsggdsdgds";
        String strSplit = "dkufshdslfhdlh;lshfdsohfdsh;";
       String StringPersonne = "POTACZALA;Vincent;05/01/1988";
       String pot = "POT";
        String str2 = new String("dlkgndflmgdf");

        System.out.println(strSplit.split(";")[1]);

        String[] tabString = StringPersonne.split(";");
        String[] tabDate = tabString[2].split("/");


        Personne Adc = null;
        try {
            Adc = new Personne(tabString[0],tabString[1], LocalDate.of(Integer.parseInt(tabDate[2]),Integer.parseInt(tabDate[1]),Integer.parseInt(tabDate[0])));
        } catch (PersonneException e) {
            e.printStackTrace();
        }
        System.out.println(Adc);
        System.out.println("-".repeat(50));
        System.out.println(tabString[0].substring(1,1));
        System.out.println("+".repeat(10));

        System.out.println(StringPersonne.contains(pot));

        System.out.println(StringPersonne.startsWith(pot));


    }
}
