package net.ent.etrs.projet.vues.facades.impl;

import net.ent.etrs.projet.vues.facades.FacadeVue;

public final class FacadeVueFactory {
    private FacadeVueFactory() {

    }

    public static FacadeVue fabriquerFacadeVue(){
        return new FacadeVueImpl();
    }
}
