package net.ent.etrs.CatalogueJeuVideo.views.facades.impl;

import net.ent.etrs.CatalogueJeuVideo.views.facades.FacadeView;

public final class FacadeVueFactory {
    private FacadeVueFactory() {

    }

    public static FacadeView fabriquerFacadeVue(){
        return new FacadeVueImpl();
    }
}
