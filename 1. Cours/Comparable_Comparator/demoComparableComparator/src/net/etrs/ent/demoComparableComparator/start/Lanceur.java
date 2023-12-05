package net.etrs.ent.demoComparableComparator.start;

import net.etrs.ent.demoComparableComparator.model.entities.Militaire;
import net.etrs.ent.demoComparableComparator.model.entities.comparator.ComparatorMilitaireNomEtPrenom;
import net.etrs.ent.demoComparableComparator.model.entities.references.GradeOtan;

import java.util.ArrayList;
import java.util.List;

public class Lanceur {
    public static void main(String[] args) {

        Militaire m1 = new Militaire("2002220202", GradeOtan.OR2,"MB","NOAM");
        Militaire m2 = new Militaire("1797230441", GradeOtan.OR5,"BOSQUI","JEREMY");
        Militaire m3 = new Militaire("1613020284", GradeOtan.OR5,"VARIN","KEVIN");
        Militaire m4 = new Militaire("2277011836", GradeOtan.OR5,"DIOUY","CHARLY");
        Militaire m5 = new Militaire("1629030002", GradeOtan.OR6,"BERNARD","EDGAR");

        List<Militaire> lm = new ArrayList<>();
        lm.add(m1);
        lm.add(m2);
        lm.add(m3);
        lm.add(m4);
        lm.add(m5);

        for (Militaire m:lm ) {
            System.out.println(m);
        }
        System.out.println("-".repeat(50));

        lm.sort(new ComparatorMilitaireNomEtPrenom());

        for (Militaire m:lm ) {
            System.out.println(m);
        }

        System.out.println("-".repeat(50));

    }
}
