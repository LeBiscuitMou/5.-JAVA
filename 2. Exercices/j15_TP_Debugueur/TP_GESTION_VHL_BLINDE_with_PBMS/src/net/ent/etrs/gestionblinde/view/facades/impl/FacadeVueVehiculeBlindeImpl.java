package net.ent.etrs.gestionblinde.view.facades.impl;

import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;
import net.ent.etrs.gestionblinde.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionblinde.view.facades.FacadeVueVehiculeBlinde;

import java.util.List;

public class FacadeVueVehiculeBlindeImpl implements FacadeVueVehiculeBlinde {
    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    @Override
    public void afficherMessageErreur(String message) {
AffichageConsole.afficherErreur(message);
    }

    @Override
    public void afficherLesVHL(List<VehiculeBlinde> vhls) {
        for (VehiculeBlinde v:vhls) {
            AffichageConsole.afficherMessageAvecSautLigne(v.toString());
        }
    }

    @Override
    public VehiculeBlinde creerVehiculeBlinde() {


        return null;
    }

    @Override
    public VehiculeBlinde supprimerVehiculeBlinde(List<VehiculeBlinde> vhls) {
        return null;
    }
}
