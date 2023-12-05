package net.ent.etrs.model.facade;

import net.ent.etrs.model.entities.Batiment;
import net.ent.etrs.model.entities.MaterielInformatique;
import net.ent.etrs.model.facade.exceptions.BusinessException;

import java.util.List;

public interface FacadeMetier {

    /**
     * Lance l'initialisation des données de l'application afin de bénéficier d'un jeu de données de départ.
     */
    void initialierApplication();

    /**
     * Créer un matériel informatique dans l'application.
     * @param materielInformatique le matériel informatique envoyé par la vue.
     * @throws BusinessException si une erreure est survenue lors de la création du matériel informatique.
     */
    void creerMaterielInformatique(MaterielInformatique materielInformatique) throws BusinessException;

    /**
     * Supprime un matériel informatique dans l'application.
     * @param materielInformatique le matériel informatique envoyé par la vue.
     * @throws BusinessException si une erreure est survenue lors de la suppression du matériel informatique.
     */
    void supprimerMaterielInformatique(MaterielInformatique materielInformatique) throws BusinessException;

    /**
     * Renvoie la liste complète des matériels informatique.
     * @return la liste complète des matériels informatique.
     */
    List<MaterielInformatique> listerMaterielInformatique();

    /**
     * Renvoie la liste des matériels informatique affectés dans les pièces du bâtiment passé en paramètre.
     * @param batiment le bâtiment sélectionné.
     * @return la liste des matériels informatique affectés dans le bâtiment.
     */
    List<MaterielInformatique> listerMaterielInformatiqueBatiment(Batiment batiment);

    /**
     * Renvoie la liste des matériels informatique non affectés.
     * @return la liste des matériels informatique non affectés.
     */
    List<MaterielInformatique> listerMaterielInformatiqueNonAffecte();

    /**
     * Renvoie la liste des bâtiments.
     * @return la liste des bâtiments.
     */
    List<Batiment> listerBatiment();

    /**
     * Met à jour le bâtiment passé en paramètre avec ses pièces et matériels informatique affectés
     * @param batiment le bâtiment sélectionné.
     * @throws BusinessException si une erreure est survenue lors de la mise à jour du bâtiment et ses objets associés.
     */
    void affecterMaterielInformatiquePiece(Batiment batiment) throws BusinessException;
}
