package net.ent.etrs.GestionnairePotion.vues.facades.impl;

import net.ent.etrs.GestionnairePotion.vues.facades.FacadeVue;

public final class FacadeVueFactory {
    private FacadeVueFactory() {

    }

    public static FacadeVue fabriquerFacadeVue(){
        return new FacadeVueImpl();
    }
}
