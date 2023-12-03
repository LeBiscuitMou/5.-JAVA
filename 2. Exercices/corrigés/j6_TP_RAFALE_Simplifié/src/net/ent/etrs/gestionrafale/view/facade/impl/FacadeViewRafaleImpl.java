package net.ent.etrs.gestionrafale.view.facade.impl;

import net.ent.etrs.gestionrafale.model.entities.EntitiesFactory;
import net.ent.etrs.gestionrafale.model.entities.Rafale;
import net.ent.etrs.gestionrafale.model.entities.RafaleAir;
import net.ent.etrs.gestionrafale.model.entities.exceptions.RafaleMetierException;
import net.ent.etrs.gestionrafale.model.entities.references.Bombe;
import net.ent.etrs.gestionrafale.model.entities.references.MissileAA;
import net.ent.etrs.gestionrafale.view.commons.utils.AffichageConsole;
import net.ent.etrs.gestionrafale.view.commons.utils.LectureConsole;
import net.ent.etrs.gestionrafale.view.facade.FacadeViewRafale;
import net.ent.etrs.gestionrafale.view.facade.exception.FacadeViewRafaleException;
import net.ent.etrs.gestionrafale.view.references.ConstanteView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FacadeViewRafaleImpl implements FacadeViewRafale {
    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    @Override
    public void afficherMenuPrincipal(List<String> menu) {
        AffichageConsole.afficherMenuSimple(menu);
    }

    @Override
    public void afficherTousLesRafales(List<Rafale> listRafales) {
        for (Rafale r : listRafales
        ) {
            System.out.println(r);
        }
    }

    @Override
    public Rafale creerRafale() throws FacadeViewRafaleException {
        String identificationRafale = LectureConsole.lectureChaineCaracteres("Saisir Immatriculation");
        int nombrePilote = LectureConsole.lectureEntier("Saisir nombre Pilote");
        int carburantInterne = LectureConsole.lectureEntier("Saisir carburant (Max : 4500)");
        boolean possedeMissileNucleaire = LectureConsole.lectureBoolean("Es ce qu'il possède un armement nucléaire");
        try {
            return EntitiesFactory.fabriquerRafale(identificationRafale, nombrePilote, carburantInterne, possedeMissileNucleaire);
        } catch (RafaleMetierException e) {
            throw new FacadeViewRafaleException(ConstanteView.FACADE_IMPOSSIBLE_CREER_RAFALE, e);
        }
    }

    @Override
    public MissileAA selectionnerMissile() {

        List<String> lstMissile = new ArrayList<String>();
        for (MissileAA missileAA : Arrays.asList(MissileAA.values())) {
            lstMissile.add(missileAA.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lstMissile);
        AffichageConsole.afficherMessageAvecSautLigne("Saisir le Missile");
        int choix = LectureConsole.lectureChoixInt(0, lstMissile.size());
        return MissileAA.values()[choix - 1];
    }

    @Override
    public Bombe selectionnerBombe() {
        List<String> lstBombe = new ArrayList<String>();
        for (Bombe b : Arrays.asList(Bombe.values())) {
            lstBombe.add(b.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lstBombe);
        AffichageConsole.afficherMessageAvecSautLigne("Saisir la Bombe");
        int choix = LectureConsole.lectureChoixInt(0, lstBombe.size());
        return Bombe.values()[choix - 1];
    }

    @Override
    public Rafale selectionnerRafale(List<Rafale> listRafales) throws FacadeViewRafaleException {
        if (listRafales.size() == 0) {
            throw new FacadeViewRafaleException(ConstanteView.FACADE_AUCUN_RAFALE);
        }
        List<String> lstRafale = new ArrayList<String>();
        for (Rafale r : listRafales) {
            lstRafale.add(r.toString());
        }
        AffichageConsole.afficherMenuSimple(lstRafale);
        AffichageConsole.afficherMessageAvecSautLigne("Selectionner le Rafale");
        int choix = LectureConsole.lectureChoixInt(0, lstRafale.size());
        return listRafales.get(choix - 1);
    }

    public void affichageDetailRafale(Rafale r) {
        AffichageConsole.afficherMessageAvecSautLigne("Rafale : " + r.getIdentificationRafale());

        if (r instanceof RafaleAir && ((RafaleAir) r).isPossedeBombeNucleaire()) {
            AffichageConsole.afficherMessageAvecSautLigne("Possède un missile Nucléaire");
        } else {
            if ((r.getLesBombesEmportees().size() > 0)) {
                AffichageConsole.afficherMenuSimpleSansChoix(Collections.singletonList(r.getLesBombesEmportees().toString()));
            } else {
                AffichageConsole.afficherMessageAvecSautLigne("Aucune Bombe");
            }
            if ((r.getLesMissilesEmportes().size() > 0)) {
                AffichageConsole.afficherMenuSimpleSansChoix(Collections.singletonList(r.getLesMissilesEmportes().toString()));
            } else {
                AffichageConsole.afficherMessageAvecSautLigne("Aucun Missile");
            }
        }
    }
}
