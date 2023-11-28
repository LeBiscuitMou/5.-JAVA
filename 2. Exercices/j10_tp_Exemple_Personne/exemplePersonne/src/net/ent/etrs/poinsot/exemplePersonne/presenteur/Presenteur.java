package net.ent.etrs.poinsot.exemplePersonne.presenteur;

import net.ent.etrs.poinsot.exemplePersonne.model.facade.FacadeMetier;
import net.ent.etrs.poinsot.exemplePersonne.model.facade.impl.FacadeFactory;
import net.ent.etrs.poinsot.exemplePersonne.model.facade.impl.exceptions.FacadeException;
import net.ent.etrs.poinsot.exemplePersonne.view.commons.utils.AffichageConsole;
import net.ent.etrs.poinsot.exemplePersonne.view.facade.FacadeView;
import net.ent.etrs.poinsot.exemplePersonne.view.facade.impl.FacadeViewFactory;

public class Presenteur {
    FacadeMetier fm;
    FacadeView fv;

    public Presenteur() {
        this.fm = FacadeFactory.fabriquerFacadeMetier();
        this.fv = FacadeViewFactory.fabriquerFacadeView();
    }

    public void start() {
        try {
            fm.sauvegarderPersonne(fv.creerPersonne());
        } catch (FacadeException e) {
            AffichageConsole.afficherErreur(e.getMessage());
        }
    }
}