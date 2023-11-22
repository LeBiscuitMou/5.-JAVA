package net.ent.etrs.tresor.model;

import net.ent.etrs.tresor.model.entities.Carte;
import net.ent.etrs.tresor.model.entities.ChasseAuTresor;

public class FacadeMetier {
    private Ihm vue;
    private FacadeMetier metier;

    public FacadeMetier() {
        initialiser();
    }

    public Ihm getVue() {
        return vue;
    }

    public void setVue(Ihm vue) {
        this.vue = vue;
    }

    public FacadeMetier getMetier() {
        return metier;
    }

    public void setMetier(FacadeMetier metier) {
        this.metier = metier;
    }

    private void initialiser() {

    }

    public Carte selectionnerCarte() {

    }

    public char deplacerUnJoueur(int indice) {

    }
}