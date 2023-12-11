package net.ent.etrs.GestionnairePotion.model.facades.impl;

import net.ent.etrs.GestionnairePotion.model.facades.FacadeMetier;

public final class FacadeMetierFactory {
    private FacadeMetierFactory() {

    }

     public static FacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetierImpl();
     }
}
