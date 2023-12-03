package net.ent.etrs.exemplePersonne.presenteur;

import net.ent.etrs.exemplePersonne.model.entities.exceptions.EntitiesFactoryExceptions;
import net.ent.etrs.exemplePersonne.model.facade.FacadeMetier;
import net.ent.etrs.exemplePersonne.model.facade.impl.FacadeFactory;
import net.ent.etrs.exemplePersonne.model.facade.impl.FacadeMetierImpl;
import net.ent.etrs.exemplePersonne.model.facade.impl.exception.FacadeException;
import net.ent.etrs.exemplePersonne.view.commons.utils.AffichageConsole;
import net.ent.etrs.exemplePersonne.view.facade.FacadeView;
import net.ent.etrs.exemplePersonne.view.facade.impl.FacadeViewFactory;

public class Presenteur {

    FacadeMetier fm;

    FacadeView fv;

    public Presenteur() {
        this.fm = FacadeFactory.fabriquerFacadeMetier();
        this.fv = FacadeViewFactory.fabriquerFacadeView();
    }

    public void start(){
        try {
            fm.sauvegarderPersonne(fv.creerPersonne());
        } catch (FacadeException | EntitiesFactoryExceptions e) {
            AffichageConsole.afficherErreur(e.getMessage());
        }
    }


}
