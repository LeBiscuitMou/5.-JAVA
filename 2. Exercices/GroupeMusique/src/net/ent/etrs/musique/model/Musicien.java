package net.ent.etrs.musique.model;

import net.ent.etrs.musique.model.exceptions.PersonneException;

public class Musicien extends Personne {
    private String unArtiste;

    public Musicien(String nom, String prenom, Sexe sexe) throws PersonneException {
        super(nom, prenom, sexe);
    }
}