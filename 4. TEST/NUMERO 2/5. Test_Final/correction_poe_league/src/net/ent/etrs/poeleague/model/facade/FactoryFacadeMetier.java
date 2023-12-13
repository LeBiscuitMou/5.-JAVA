package net.ent.etrs.poeleague.model.facade;

public final class FactoryFacadeMetier {

    private FactoryFacadeMetier() {
    }

    public static FacadeMetier fabriquerFacadeMetier() {
        return new FacadeMetierImpl();
    }
}
