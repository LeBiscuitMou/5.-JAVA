package net.ent.etrs.pjjeudesociete.models.facade.impl;

import net.ent.etrs.pjjeudesociete.models.commons.Utils;
import net.ent.etrs.pjjeudesociete.models.daos.DaoAuteur;
import net.ent.etrs.pjjeudesociete.models.daos.DaoJeuSociete;
import net.ent.etrs.pjjeudesociete.models.daos.DaoMaisonEdition;
import net.ent.etrs.pjjeudesociete.models.daos.exceptions.DaoException;
import net.ent.etrs.pjjeudesociete.models.daos.impl.DaoFactory;
import net.ent.etrs.pjjeudesociete.models.entities.Auteur;
import net.ent.etrs.pjjeudesociete.models.entities.EntitiesFactory;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.pjjeudesociete.models.entities.references.ConstantesMetier;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.models.entities.references.Pays;
import net.ent.etrs.pjjeudesociete.models.facade.FacadeMetier;
import net.ent.etrs.pjjeudesociete.models.facade.exception.BusinessException;

import java.time.LocalDate;
import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {

    DaoJeuSociete daoJeuSociete;

    DaoMaisonEdition daoMaisonEdition;

    DaoAuteur daoAuteur;

    public FacadeMetierImpl() {
        this.daoJeuSociete = DaoFactory.fabriquerDaoJeuSociete();
        this.daoAuteur = DaoFactory.fabriquerDaoAuteur();
        this.daoMaisonEdition = DaoFactory.fabriquerDaoMaisonEdition();
    }

    /**
     * Permet d'initialiser les jeux de societe
     *
     * @param listJeuInit la liste des String d'intialisation
     */
    @Override
    public void initialisation(List<String> listJeuInit) throws BusinessException {
        for (String jeu : listJeuInit) {
            String[] decoupage = jeu.split(";");
            if (decoupage.length > 0) {

                try {
                    //Création Maison Edition
                    String nomMaisonEdition = decoupage[4];
                    LocalDate dateCreation = LocalDate.parse(decoupage[5], ConstantesMetier.DATE_FORMAT);
                    Pays pays = Pays.valueOf(decoupage[6].trim().toUpperCase());
                    MaisonEdition me = EntitiesFactory.fabriquerMaisonEdition(nomMaisonEdition, dateCreation, pays);
                    daoMaisonEdition.save(me);

                    //Creation Auteur
                    String nomAuteur = decoupage[7];
                    String prenomAuteur = decoupage[8];
                    Auteur a = EntitiesFactory.fabriquerAuteur(nomAuteur, prenomAuteur);
                    daoAuteur.save(a);

                    //Création du Jeu
                    String nomJds = decoupage[0];
                    int nbJoueurMin = Integer.parseInt(decoupage[1]);
                    int nbJoueurMax = Integer.parseInt(decoupage[2]);
                    float prix = Float.parseFloat(decoupage[3]);

                    List<Mecanisme> mecanismes = new ArrayList<>();
                    for (int i = 9; i < decoupage.length; i++) {
                        if (!decoupage[i].isBlank()) {
                            Mecanisme m = Mecanisme.valueOf(decoupage[i].trim().toUpperCase());
                            mecanismes.add(m);
                        }
                    }

                    JeuSociete jds = EntitiesFactory.fabriquerJeuSociete(nomJds, nbJoueurMin, nbJoueurMax, prix, a, me, mecanismes);
                    this.daoJeuSociete.save(jds);

                } catch (EntitiesFactoryException | DaoException e) {
                    throw new BusinessException(ConstantesMetier.INIT_ERROR, e);
                }
            }
        }

    }

    @Override
    public JeuSociete sauvegarderJeuSociete(JeuSociete jeuSociete) throws BusinessException {
        try {
            return this.daoJeuSociete.save(jeuSociete);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_JDS_ERROR_SAVE_DAO, e);
        }
    }

    @Override
    public Auteur creerAuteur(Auteur auteur) throws BusinessException {
        try {
            return this.daoAuteur.save(auteur);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_AUTEUR_ERROR_SAVE_DAO, e);
        }
    }

    @Override
    public MaisonEdition creerMaisonEdition(MaisonEdition maisonEdition) throws BusinessException {
        try {
            return this.daoMaisonEdition.save(maisonEdition);
        } catch (DaoException e) {
            throw new BusinessException(ConstantesMetier.FACADE_MAISON_EDITION_ERROR_SAVE_DAO, e);
        }
    }

    @Override
    public Map<MaisonEdition, List<JeuSociete>> getLesMaisonEditionAvecJeuSociete() throws BusinessException {
        Map<MaisonEdition, List<JeuSociete>> result = new HashMap<>();
        for (MaisonEdition me : this.getLesMaisonEdition()) {
            result.put(me, this.daoJeuSociete.getJeuSocieteByMaisonEdition(me));
        }
        return result;
    }

    @Override
    public List<JeuSociete> getLesJeuSocieteParMecanisme(Mecanisme mecanisme) {
        return Collections.unmodifiableList(this.daoJeuSociete.getJeuSocieteByMecanisme(mecanisme));
    }

    @Override
    public List<Auteur> getlesAuteurs() throws BusinessException {
        try {
            return Collections.unmodifiableList(Utils.iterableToList(this.daoAuteur.findAll()));
        } catch (DaoException ex) {
            throw new BusinessException(ConstantesMetier.FACADE_AUTEUR_ERROR_FIND_ALL, ex);
        }
    }

    @Override
    public List<MaisonEdition> getLesMaisonEdition() throws BusinessException {
        try {
            return Collections.unmodifiableList(Utils.iterableToList(this.daoMaisonEdition.findAll()));
        } catch (DaoException ex) {
            throw new BusinessException(ConstantesMetier.FACADE_MAISON_EDITION_ERROR_FIND_ALL, ex);
        }
    }

    @Override
    public List<JeuSociete> getlesJeuSociete() throws BusinessException {
        try {
            return Collections.unmodifiableList(Utils.iterableToList(this.daoJeuSociete.findAll()));
        } catch (DaoException ex) {
            throw new BusinessException(ConstantesMetier.FACADE_JDS_ERROR_FIND_ALL, ex);
        }
    }
}
