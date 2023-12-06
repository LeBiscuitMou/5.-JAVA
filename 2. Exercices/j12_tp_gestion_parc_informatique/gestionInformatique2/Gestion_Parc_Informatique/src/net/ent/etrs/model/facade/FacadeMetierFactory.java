package net.ent.etrs.model.facade;

public final class FacadeMetierFactory {

    public FacadeMetierFactory() {
    }

    public static FacadeMetier fabriquerFacadeMetier(){
        return new FacadeMetierImpl();
    }
}
