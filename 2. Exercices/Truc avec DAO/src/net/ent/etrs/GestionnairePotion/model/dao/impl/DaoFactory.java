package net.ent.etrs.GestionnairePotion.model.dao.impl;

import net.ent.etrs.GestionnairePotion.model.dao.IDaoIngredient;
import net.ent.etrs.GestionnairePotion.model.dao.IDaoPotion;

public final class DaoFactory {
    private DaoFactory() {  }

    public static IDaoIngredient fabriquerDaoIngredient(){
        return new DaoIngredientMemImpl();
    }

    public static IDaoPotion fabriquerDaoPotion(){
        return new DaoPotionMemImpl();

    }
}
