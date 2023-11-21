package net.ent.etrs.arene.model;

import net.ent.etrs.arene.model.exceptions.GladiateurException;

public class Mirmillon extends Gladiateur {
    public Mirmillon(String nom, int experience) throws GladiateurException {
        super(nom, experience);
    }

    @Override
    public void combattre() {

    }
}