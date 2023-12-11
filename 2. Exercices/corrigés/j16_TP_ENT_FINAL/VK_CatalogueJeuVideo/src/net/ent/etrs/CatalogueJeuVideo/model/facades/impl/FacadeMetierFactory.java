package net.ent.etrs.CatalogueJeuVideo.model.facades.impl;

import net.ent.etrs.CatalogueJeuVideo.model.facades.FacadeMetier;

public final class FacadeMetierFactory {
    private FacadeMetierFactory() {

    }

     public static FacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetierImpl();
     }
}
