package net.ent.etrs.poinsot.note.model.entities.comparator;

import net.ent.etrs.poinsot.note.model.references.Matiere;

import java.util.Comparator;

public class MatiereComparator implements Comparator<Matiere> {
    @Override
    public int compare(Matiere o1, Matiere o2) {
        return o1.name().compareTo(o2.name());
    }
}