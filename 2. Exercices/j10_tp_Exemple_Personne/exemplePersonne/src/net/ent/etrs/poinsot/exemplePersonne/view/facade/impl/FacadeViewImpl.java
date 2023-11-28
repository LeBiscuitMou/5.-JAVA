package net.ent.etrs.poinsot.exemplePersonne.view.facade.impl;

import net.ent.etrs.poinsot.exemplePersonne.model.entities.EntitiesFactory;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.Personne;
import net.ent.etrs.poinsot.exemplePersonne.model.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.poinsot.exemplePersonne.view.commons.utils.AffichageConsole;
import net.ent.etrs.poinsot.exemplePersonne.view.commons.utils.LectureConsole;
import net.ent.etrs.poinsot.exemplePersonne.view.facade.FacadeView;

import java.time.LocalDate;

public class FacadeViewImpl implements FacadeView {
    @Override
    public Personne creerPersonne() {
        try {
            String leNom = LectureConsole.lectureChaineCaracteres("Saisir le nom de la personne");
            String lePrenom = LectureConsole.lectureChaineCaracteres("Saisir le prénom de la personne");
            LocalDate dateNaissance = LectureConsole.lectureLocalDate("Saisir la date de naissance");

            return EntitiesFactory.fabriquerPersonne(leNom, lePrenom, dateNaissance);
        } catch (EntitiesFactoryException e) {
            AffichageConsole.afficherErreur(e.getMessage());
        }
    }
}
