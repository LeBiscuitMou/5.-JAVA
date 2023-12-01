package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;

public class PotionAmelioration extends Potion {
    public PotionAmelioration(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }
}