package net.ent.etrs.exemplePersonne.view.facade.impl;

import net.ent.etrs.exemplePersonne.model.entities.EntitiesFactory;
import net.ent.etrs.exemplePersonne.model.entities.Personne;
import net.ent.etrs.exemplePersonne.model.entities.exceptions.EntitiesFactoryExceptions;
import net.ent.etrs.exemplePersonne.view.commons.utils.AffichageConsole;
import net.ent.etrs.exemplePersonne.view.commons.utils.LectureConsole;
import net.ent.etrs.exemplePersonne.view.facade.FacadeView;

import java.time.LocalDate;

public class FacadeViewImpl implements FacadeView {
    @Override
    public Personne creerPersonne() throws EntitiesFactoryExceptions {
            String leNom =  LectureConsole.lectureChaineCaracteres("Saisir le nom de la Personne");
            String lePrenom =  LectureConsole.lectureChaineCaracteres("Saisir le prénom de la personne");
            LocalDate dateNaissance =  LectureConsole.lectureLocalDate("Saisir la date de naissance", AffichageConsole.PATTERN_DATE_PAR_DEFAUT);

            return EntitiesFactory.fabriquerPersonne(leNom,lePrenom,dateNaissance);

    }
}
