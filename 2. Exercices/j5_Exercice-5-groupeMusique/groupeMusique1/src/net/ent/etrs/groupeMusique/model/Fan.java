package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.PersonneException;
import net.ent.etrs.groupeMusique.model.references.Sexe;

import java.time.LocalDate;

public class Fan extends Personne{

    private Musicien musicienFavoris;
    protected Fan(String nom, String prenom, Sexe sexe, Musicien musicienFavoris, LocalDate laDateNaissance) throws PersonneException {
        super(nom, prenom, sexe, laDateNaissance);
        this.setMusicienFavoris(musicienFavoris);
    }

    private void setMusicienFavoris(Musicien musicienFavoris) {
    }

    public Musicien getMusicienFavoris() {
        return musicienFavoris;
    }
}
