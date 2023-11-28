package net.ent.etrs.projet.model.facades.impl;

import net.ent.etrs.projet.model.facades.FacadeMetier;

public final class FacadeFactory {
    private FacadeFactory() {

    }

     public static FacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetierImpl();
     }
}
