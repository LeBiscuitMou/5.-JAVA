package net.ent.etrs.poinsot.projet.model.facade;

import net.ent.etrs.poinsot.projet.model.entities.Batiment;
import net.ent.etrs.poinsot.projet.model.entities.MaterielInformatique;
import net.ent.etrs.poinsot.projet.model.facade.exceptions.FacadeMetierException;

import java.util.List;

public interface FacadeMetier {
    void initialiserApplication();
    void creerMaterielInformatique(MaterielInformatique materielInformatique) throws FacadeMetierException;
    void supprimerMaterielInformatique(MaterielInformatique materielInformatique) throws FacadeMetierException;
    List<MaterielInformatique> listerMaterielInformatique();
    List<MaterielInformatique> listerMaterielInformatiqueBatiment(Batiment batiment);
    List<MaterielInformatique> listerMaterielInformatiqueNonAffecte();
    List<Batiment> listerBatiment();
    void affecterMaterielInformatiquePiece(Batiment batiment);
}
