package net.ent.etrs.bateau.start;

import net.ent.etrs.bateau.model.EntitiesFactory;
import net.ent.etrs.bateau.model.Fregate;
import net.ent.etrs.bateau.model.MoyenPropulsion;
import net.ent.etrs.bateau.model.exceptions.BateauException;

public class Lanceur {
    public static void main(String[] args) {
        Fregate f = (Fregate) EntitiesFactory.fabriquerFregate();
    }
}