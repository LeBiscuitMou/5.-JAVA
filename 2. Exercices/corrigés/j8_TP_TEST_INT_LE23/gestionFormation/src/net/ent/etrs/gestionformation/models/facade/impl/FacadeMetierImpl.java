package net.ent.etrs.gestionformation.models.facade.impl;

import net.ent.etrs.gestionformation.models.entities.*;
import net.ent.etrs.gestionformation.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionformation.models.entities.exceptions.JourneeException;
import net.ent.etrs.gestionformation.models.entities.exceptions.MatiereException;
import net.ent.etrs.gestionformation.models.entities.exceptions.UniteValeurException;
import net.ent.etrs.gestionformation.models.entities.references.ConstanteMetier;
import net.ent.etrs.gestionformation.models.facade.FacadeMetier;
import net.ent.etrs.gestionformation.models.facade.exceptions.BusinessException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements FacadeMetier {


    private final List<Matiere> lesMatiere = new ArrayList<Matiere>();
    private final List<UniteValeur> lesUV = new ArrayList<UniteValeur>();


    /**
     * Permet de créé une matière
     *
     * @param matiere matière à sauvegarder
     */
    @Override
    public void creerMatiere(Matiere matiere) throws BusinessException {
        if (Objects.isNull(matiere)){
            throw new BusinessException(ConstanteMetier.FACADE_MATIERE_NULL);
        }
        if (this.lesMatiere.contains(matiere)){
            throw new BusinessException(ConstanteMetier.FACADE_MATIERE_ALREADY_EXIST);
        }
        this.lesMatiere.add(matiere);
    }

    /**
     * Permet d'ajouter un cours à une matière
     *
     * @param matiere la matière qui a un nouveau cours
     * @param cours   le cours à ajouter, il doit être valide
     */
    @Override
    public void ajouterUnCoursAUneMatiere(Matiere matiere, Cours cours) throws BusinessException {
        if (Objects.isNull(matiere)){
            throw new BusinessException(ConstanteMetier.FACADE_MATIERE_NULL);
        }
        if (Objects.isNull(cours)){
            throw new BusinessException(ConstanteMetier.FACADE_COURS_NULL);
        }
        try {
            matiere.ajouterCours(cours);
        } catch (MatiereException e) {
            throw new BusinessException(ConstanteMetier.FACADE_MATIERE_COURS_ERROR);
        }
    }

    /**
     * Permet de lister toutes les matière
     *
     * @return la liste de toutes les matière
     */
    @Override
    public List<Matiere> ListerTouteslesMatiere() {
        return Collections.unmodifiableList(this.lesMatiere);
    }

    /**
     * Permet de lister les cours d'une Matière
     *
     * @param matiere la matière dont on veut connaitre les cours
     * @return la liste des cours de la matière
     */
    @Override
    public List<Cours> ListerTouslesCoursDuneMatiere(Matiere matiere) {
        return Collections.unmodifiableList(matiere.getLesCours());
    }

    /**
     * Permet de créé une UV
     *
     * @param uv l'UV à sauvegarder
     */
    @Override
    public void creerUV(UniteValeur uv) throws BusinessException {
        if (Objects.isNull(uv)){
            throw new BusinessException(ConstanteMetier.FACADE_UV_NULL);
        }
        if(this.lesUV.contains(uv)){
            throw new BusinessException(ConstanteMetier.FACADE_UV_ALREADY_EXIST);
        }
        this.lesUV.add(uv);

    }

    /**
     * Permet d'ajouter une matière à une UV
     *
     * @param uv      UV impactée
     * @param matiere matière à ajouter, elle doit être valide
     */
    @Override
    public void ajouterUneMatiereAUneUV(UniteValeur uv, Matiere matiere) throws BusinessException {
        if (Objects.isNull(uv)){
            throw new BusinessException(ConstanteMetier.FACADE_UV_NULL);
        }
        if (Objects.isNull(matiere)){
            throw new BusinessException(ConstanteMetier.FACADE_MATIERE_NULL);
        }
        try {
            uv.ajouterMatiere(matiere);
        } catch (UniteValeurException e) {
            throw new BusinessException(ConstanteMetier.FACADE_UV_MATIERE_ERROR);
        }

    }

    /**
     * Permet de lister toutes les matières d'une UV
     *
     * @param uv UV dont on veut connaitre les matières
     * @return la liste des matières de l'UV
     */
    @Override
    public List<Matiere> ListerToutesLesMatiereDuneUV(UniteValeur uv) {
        return Collections.unmodifiableList(uv.getLesMatieres());
    }

    /**
     * Permet de lister tous les UV
     *
     * @return les UV
     */
    @Override
    public List<UniteValeur> ListerToutesLesUV() {
        return Collections.unmodifiableList(this.lesUV);
    }

    /**
     * Permet de généré une semaine pour un UV
     *
     * @param uv l'UV passer pour la génération
     * @return la semaine générée
     */
    @Override
    public List<Journee> genererSemaine(UniteValeur uv) throws EntitiesFactoryException {

        List<Journee> retour = new ArrayList<>();
        List<Cours> listCoursUV = new ArrayList<>();

        //On initialise la list des cours pour pouvoir l'utiliser à la création de la semaine
        for (Matiere m: uv.getLesMatieres()) {
            for (Cours c : m.getLesCours()) {
                listCoursUV.add(c);
            }
        }

        int cpt = 0;

        do{
            Journee j = EntitiesFactory.fabriquerJournee(uv.getDateDebut().plusDays(cpt));
           j = gererAJoutCours(j,listCoursUV);
            retour.add(j);
            cpt++;
        }while (retour.size() != ConstanteMetier.NB_JOUR_SEMAINE);

        return retour;
    }

    private Journee gererAJoutCours(Journee j, List<Cours> listCoursUV) {

        return null;
    }

    /**
     * Permet de vérifier si une journée est complete
     *
     * @param jour la journée saisie
     * @return si elle est complete
     */
    @Override
    public boolean journeeComplete(Journee jour) {
        List<LocalDateTime> lesHoraires = initHoraire(jour);
        boolean retour = false;

        if (jour.getLesCours().size() > 0) {
            for (Cours c:jour.getLesCours()) {
               if (lesHoraires.contains(c.getDebutCours())){
                   retour = true;
               }
               else{
                   return false;
               }

                for (int i = 0; i < c.getDuree(); i++) {
                    if (lesHoraires.contains(c.getDebutCours().plusHours(i))){
                        retour = true;
                    } else{
                        return false;
                    }
                }
            }
        }
        return retour;
    }

    /**
     * Permet d'avoir les horaire possible du jour
     * @param jour le jour
     * @return la liste des créneau possible
     */
    private List<LocalDateTime> initHoraire(Journee jour) {
        List<LocalDateTime> retour = new ArrayList<>();
        retour.add(jour.getDate().atTime(8,0));
        retour.add(jour.getDate().atTime(9,0));
        retour.add(jour.getDate().atTime(10,0));
        retour.add(jour.getDate().atTime(11,0));
        retour.add(jour.getDate().atTime(13,0));
        retour.add(jour.getDate().atTime(14,0));
        retour.add(jour.getDate().atTime(15,0));
        retour.add(jour.getDate().atTime(16,0));

        return retour;
    }
}
