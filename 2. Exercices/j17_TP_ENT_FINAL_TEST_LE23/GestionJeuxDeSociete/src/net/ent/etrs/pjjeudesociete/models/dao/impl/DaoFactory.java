package net.ent.etrs.pjjeudesociete.models.dao.impl;

import net.ent.etrs.pjjeudesociete.models.dao.IDaoAuteur;
import net.ent.etrs.pjjeudesociete.models.dao.IDaoJeuSociete;
import net.ent.etrs.pjjeudesociete.models.dao.IDaoMaisonEdition;

import java.util.Objects;

public final class DaoFactory {
    private static IDaoAuteur iDaoAuteur;
    private static IDaoMaisonEdition iDaoMaisonEdition;
    private static IDaoJeuSociete iDaoJeuSociete;

    private DaoFactory() {  }

    public static IDaoAuteur fabriquerAuteurDao() {
        if (Objects.isNull(iDaoAuteur)) {
            iDaoAuteur = new AuteurDaoImpl();
        }
        return iDaoAuteur;
    }

    public static IDaoMaisonEdition fabriquerMaisonEditionDao() {
        if (Objects.isNull(iDaoMaisonEdition)) {
            iDaoMaisonEdition = new MaisonEditionDaoImpl();
        }
        return iDaoMaisonEdition;
    }

    public static IDaoJeuSociete fabriquerJeuSocieteDao() {
        if (Objects.isNull(iDaoJeuSociete)) {
            iDaoJeuSociete = new JeuSocieteDaoImpl();
        }
        return iDaoJeuSociete;
    }
}
