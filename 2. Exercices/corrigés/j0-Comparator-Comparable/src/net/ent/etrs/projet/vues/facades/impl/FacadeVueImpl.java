package net.ent.etrs.projet.vues.facades.impl;
import net.ent.etrs.projet.model.references.ConstMetier;
import net.ent.etrs.projet.vues.commons.utils.*;
import net.ent.etrs.projet.vues.facades.FacadeVue;
import net.ent.etrs.projet.vues.references.ListeOptions;

import java.util.*;

public class FacadeVueImpl implements FacadeVue {
    protected FacadeVueImpl() {

    }

    /**
     * Affiche un menu de choix en utilisant l'énumération ListeOptions.
     * L'affichage en fonction de l'énumération est dynamique, il n'est pas nécessaire de modifier cette fonction
     * si vous voulez ajouter ou supprimer des options.
     * @return le choix
     */
    @Override
    public int afficherMenuPrincipal() {
        List<String> options = new ArrayList<>();
        for (int i = 0; i < ListeOptions.values().length; i++) {
            options.add(ListeOptions.values()[i].getOption());
        }
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(options, ConstMetier.NOM_PROGRAMME);
        return LectureConsole.lectureChoixInt(0, ListeOptions.values().length);
    }



}
