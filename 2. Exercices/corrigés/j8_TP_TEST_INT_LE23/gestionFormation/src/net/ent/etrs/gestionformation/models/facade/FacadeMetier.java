package net.ent.etrs.gestionformation.models.facade;

import net.ent.etrs.gestionformation.models.entities.Cours;
import net.ent.etrs.gestionformation.models.entities.Journee;
import net.ent.etrs.gestionformation.models.entities.Matiere;
import net.ent.etrs.gestionformation.models.entities.UniteValeur;
import net.ent.etrs.gestionformation.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionformation.models.entities.exceptions.JourneeException;
import net.ent.etrs.gestionformation.models.facade.exceptions.BusinessException;

import java.util.List;

public interface FacadeMetier {


    /**
     * Permet de créé une matière
     * @param matiere matière à sauvegarder
     */
    void creerMatiere(Matiere matiere) throws BusinessException;

    /**
     * Permet d'ajouter un cours à une matière
     * @param matiere la matière qui a un nouveau cours
     * @param cours le cours à ajouter, il doit être valide
     */
    void ajouterUnCoursAUneMatiere(Matiere matiere, Cours cours) throws BusinessException;

    /**
     * Permet de lister toutes les matière
     * @return la liste de toutes les matière
     */
    List<Matiere> ListerTouteslesMatiere();

    /**
     * Permet de lister les cours d'une Matière
     * @param matiere la matière dont on veut connaitre les cours
     * @return la liste des cours de la matière
     */
    List<Cours> ListerTouslesCoursDuneMatiere(Matiere matiere);

    /**
     * Permet de créé une UV
     * @param uv l'UV à sauvegarder
     */
    void creerUV(UniteValeur uv) throws BusinessException;

    /**
     * Permet d'ajouter une matière à une UV
     * @param uv UV impactée
     * @param matiere matière à ajouter, elle doit être valide
     */
    void ajouterUneMatiereAUneUV(UniteValeur uv, Matiere matiere) throws BusinessException;

    /**
     * Permet de lister toutes les matières d'une UV
     * @param uv UV dont on veut connaitre les matières
     * @return la liste des matières de l'UV
     */
    List<Matiere> ListerToutesLesMatiereDuneUV(UniteValeur uv);

    /**
     * Permet de lister tous les UV
     * @return les UV
     */
    List<UniteValeur> ListerToutesLesUV();

    /**
     * Permet de généré une semaine pour un UV
     * @param uv l'UV passer pour la génération
     * @return la semaine générée
     */
    List<Journee> genererSemaine(UniteValeur uv) throws  EntitiesFactoryException;

    /**
     * Permet de vérifier si une journée est complete
     * @param jour la journée saisie
     * @return si elle est complete
     */
    boolean journeeComplete(Journee jour);
}
