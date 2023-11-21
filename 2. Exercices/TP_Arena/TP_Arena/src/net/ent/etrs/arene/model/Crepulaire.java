package net.ent.etrs.arene.model;

import net.ent.etrs.arene.model.exceptions.GladiateurException;

public class Crepulaire extends Gladiateur {
    public Crepulaire(String nom, int experience) throws GladiateurException {
        super(nom, experience);
    }

    @Override
    public void combattre() {

    }
}
