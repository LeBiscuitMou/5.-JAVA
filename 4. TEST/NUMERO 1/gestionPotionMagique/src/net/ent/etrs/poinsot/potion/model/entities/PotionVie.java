package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;

public class PotionVie extends Potion {
    public PotionVie(String nom, int volume, Contenant contenant) throws PotionException {
        super(nom, volume, contenant);
    }
}