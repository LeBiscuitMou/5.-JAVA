package net.ent.etrs.GestionnairePotion.model.facades.impl;

import net.ent.etrs.GestionnairePotion.model.dao.IDaoIngredient;
import net.ent.etrs.GestionnairePotion.model.dao.IDaoPotion;
import net.ent.etrs.GestionnairePotion.model.dao.exceptions.DaoException;
import net.ent.etrs.GestionnairePotion.model.dao.impl.DaoFactory;
import net.ent.etrs.GestionnairePotion.model.entities.Ingredient;
import net.ent.etrs.GestionnairePotion.model.entities.Potion;
import net.ent.etrs.GestionnairePotion.model.exceptions.FacadeMetierImplException;
import net.ent.etrs.GestionnairePotion.model.facades.FacadeMetier;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;

import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {
    /* ******************************** VARIABLES ******************************** */
    IDaoIngredient daoIngredient = DaoFactory.fabriquerDaoIngredient();
    IDaoPotion daoPotion = DaoFactory.fabriquerDaoPotion();
    /* ******************************* CONSTRUCTOR ******************************* */
    protected FacadeMetierImpl() {

    }
    /* ******************************** FONCTIONS ******************************** */
    @Override
    public void supprimerIngredient(Ingredient ingredientASupprimer) throws FacadeMetierImplException {
        try {
            if (Objects.isNull(ingredientASupprimer)) {
                throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_INGREDIENT_NULL);
            }
            daoIngredient.delete(ingredientASupprimer.getId());
        } catch (FacadeMetierImplException | DaoException e) {
            throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_INGREDIENT_SUPPRESSION);
        }
    }

    @Override
    public void supprimerPotion(Potion potionASupprimer) throws FacadeMetierImplException {
        try {
            if (Objects.isNull(potionASupprimer)){
                throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_POTION_NULL);
            }
            daoPotion.delete(potionASupprimer.getId());
        } catch (FacadeMetierImplException | DaoException e) {
            throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_POTION_SUPPRESSION);
        }
    }

    @Override
    public void supprimerToutesLesPotions() throws FacadeMetierImplException {
        try {
            daoPotion.deleteAll();
        } catch (DaoException e) {
            throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_POTION_SUPPRESSION);
        }
    }

    @Override
    public void creerIngredient(Ingredient ingredientAAjouter) throws FacadeMetierImplException {
        try {
            if (Objects.isNull(ingredientAAjouter)){
                throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_INGREDIENT_NULL);
            }
            daoIngredient.save(ingredientAAjouter);
        } catch (FacadeMetierImplException | DaoException e) {
            throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_INGREDIENT_SAUVEGARDE,e);
        }
    }

    @Override
    public List<Ingredient> selectionnerTousLesIngredient() throws FacadeMetierImplException {
        try {
            List<Ingredient> list = new ArrayList<>();
            daoIngredient.findAll().iterator().forEachRemaining(list::add);
            return Collections.unmodifiableList(list);
        } catch (DaoException e) {
            throw new FacadeMetierImplException(ConstErrMsg.INGREDIENTS_RECUPERATION,e);
        }
    }

    @Override
    public List<Potion> selectionnerTousLesPotion() throws FacadeMetierImplException {
        try {
            List<Potion> list = new ArrayList<>();
            daoPotion.findAll().iterator().forEachRemaining(list::add);
            return Collections.unmodifiableList(list);
        } catch (DaoException e) {
            throw new FacadeMetierImplException(ConstErrMsg.POTION_RECUPERATION,e);
        }
    }

    @Override
    public void creerPotion(Potion potionAAjouter) throws FacadeMetierImplException {
        try {
            if (Objects.isNull(potionAAjouter)){
                throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_POTION_NULL);
            }
            daoPotion.save(potionAAjouter);
        } catch (FacadeMetierImplException | DaoException e) {
            throw new FacadeMetierImplException(ConstErrMsg.FACADE_ERROR_POTION_SAUVEGARDE,e);
        }
    }
}
