package net.ent.etrs.kingdomino.facades;

import net.ent.etrs.kingdomino.facades.impl.FacadeMetierImpl;

public class FactoryFacadeMetier {
    private FactoryFacadeMetier() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
