package net.ent.etrs.emploi.model.facades.impl;

import net.ent.etrs.emploi.model.entities.*;
import net.ent.etrs.emploi.model.entities.exceptions.FactoryException;
import net.ent.etrs.emploi.model.entities.references.TypeMatiere;
import net.ent.etrs.emploi.model.facades.FacadeMetierEmploiTemps;
import net.ent.etrs.emploi.model.facades.exceptions.FacadeMetierEmploiTempsException;
import net.ent.etrs.emploi.model.references.ConstantesMetier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierEmploiTempsImpl implements FacadeMetierEmploiTemps {

    private List<UniteValeur> lesUV = new ArrayList<>();
    private List<Cours> lesCours = new ArrayList<>();
    private List<Matiere> lesMatieres = new ArrayList<>();
    private List<Journee> lesJournees = new ArrayList<>();

    /**
     * @param nom
     * @param dateDebut
     * @return
     */
    @Override
    public UniteValeur creerUniteValeur(String nom, LocalDate dateDebut) throws FacadeMetierEmploiTempsException {
        UniteValeur uv = null;

        try {
            uv = EntitiesFactory.fabriquerUniteValeur(nom, dateDebut);
        } catch (FactoryException e) {
            throw new RuntimeException(e);
        }

        if (Objects.isNull(uv)) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.UNITE_VALEUR_OBJECT_NULL);
        }
        if (lesUV.contains(uv)) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.UNITE_VALEUR_OBJECT_EXIST);
        }
        this.lesUV.add(uv);
        return uv;
    }

    /**
     * @param nom
     * @param codeMatiere
     * @param typeMatiere
     * @return
     */
    @Override
    public Matiere creerMatiere(String nom, String codeMatiere, TypeMatiere typeMatiere, int leNombreHeureMatiere) throws FacadeMetierEmploiTempsException {
        Matiere matiere = null;

        try {
            matiere = EntitiesFactory.fabriquerMatiere(nom, codeMatiere, typeMatiere, leNombreHeureMatiere);
        } catch (FactoryException e) {
            throw new RuntimeException(e);
        }

        if (Objects.isNull(matiere)) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.MATIERE_OBJECT_NULL);
        }
        if (Objects.isNull(typeMatiere)) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.TYPE_MATIERE_OBJECT_NULL);
        }
        if (lesMatieres.contains(matiere)) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.UNITE_VALEUR_OBJECT_EXIST);
        }
        this.lesMatieres.add(matiere);
        return matiere;
    }

    /**
     *
     * @param nomMatiere
     * @param cours
     */
    @Override
    public void ajouterCoursMatiere(String nomMatiere, Cours cours) {

    }

    /**
     *
     * @param numCours
     * @param duree
     * @param heureDebutCours
     * @return
     * @throws FacadeMetierEmploiTempsException
     */
    @Override
    public Cours creerCours(int numCours, int duree, LocalDateTime heureDebutCours) throws FacadeMetierEmploiTempsException {
        Cours cours = null;

        try {
            cours = EntitiesFactory.fabriquerCours(numCours, duree, heureDebutCours);
        } catch (FactoryException e) {
            throw new RuntimeException(e);
        }

        if (Objects.isNull(cours)) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.COURS_OBJECT_NULL);
        }
        if (numCours < 0) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.ID_COURS_OBJECT_NULL);
        }
        if (lesCours.contains(cours)) {
            throw new FacadeMetierEmploiTempsException(ConstantesMetier.UNITE_VALEUR_OBJECT_EXIST);
        }
        this.lesCours.add(cours);
        return cours;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Cours> afficherTousLesCoursMatiere() {
        return Collections.unmodifiableList(this.lesCours);
    }

    /**
     * @return
     */
    @Override
    public List<Matiere> afficherToutesLesMatieresUV() {
        return Collections.unmodifiableList(this.lesMatieres);
    }

    /**
     * @return
     */
    @Override
    public Journee creerJourneeCours() {
        return null;
    }
}
