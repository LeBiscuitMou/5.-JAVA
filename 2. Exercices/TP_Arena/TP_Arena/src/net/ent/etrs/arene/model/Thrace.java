package net.ent.etrs.arene.model;

import net.ent.etrs.arene.model.exceptions.GladiateurException;

public class Thrace extends Gladiateur {
    public Thrace(String nom, int experience) throws GladiateurException {
        super(nom, experience);
    }

    @Override
    public void combattre() {

    }
}
