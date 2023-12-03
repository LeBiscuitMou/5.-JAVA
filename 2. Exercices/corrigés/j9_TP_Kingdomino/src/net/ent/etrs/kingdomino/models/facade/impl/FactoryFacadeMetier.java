package net.ent.etrs.kingdomino.models.facade.impl;

import net.ent.etrs.kingdomino.models.facade.FacadeMetier;

public final class FactoryFacadeMetier {

    private FactoryFacadeMetier(){}

    public static FacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetierImpl();
    }
}
