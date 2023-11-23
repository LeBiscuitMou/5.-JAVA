package net.ent.etrs.emploi.model.facades.impl;

import net.ent.etrs.emploi.model.facades.FacadeMetierEmploiTemps;

public class FacadeFactory {
    private FacadeFactory() {
    }

    public static FacadeMetierEmploiTemps fabriquerFacadeMetierEmploiTemps() {
        return new FacadeMetierEmploiTempsImpl();
    }
}
