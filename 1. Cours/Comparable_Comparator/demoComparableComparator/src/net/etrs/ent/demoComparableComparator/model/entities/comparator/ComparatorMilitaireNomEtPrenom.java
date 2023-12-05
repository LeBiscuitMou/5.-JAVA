package net.etrs.ent.demoComparableComparator.model.entities.comparator;

import net.etrs.ent.demoComparableComparator.model.entities.Militaire;

import java.util.Comparator;

public class ComparatorMilitaireNomEtPrenom implements Comparator<Militaire> {
    @Override
    public int compare(Militaire o1, Militaire o2) {
        int compareNom = o1.getNom().compareTo(o2.getNom());
        if(compareNom == 0){
            return o1.getPrenom().compareTo(o2.getPrenom());
        }
        return compareNom;
    }
}
