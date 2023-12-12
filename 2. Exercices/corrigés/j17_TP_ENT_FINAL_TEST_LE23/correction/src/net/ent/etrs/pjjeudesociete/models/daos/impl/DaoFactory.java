package net.ent.etrs.pjjeudesociete.models.daos.impl;

import net.ent.etrs.pjjeudesociete.models.daos.DaoAuteur;
import net.ent.etrs.pjjeudesociete.models.daos.DaoJeuSociete;
import net.ent.etrs.pjjeudesociete.models.daos.DaoMaisonEdition;

public final class DaoFactory {

    private DaoFactory() {
    }


    public static DaoJeuSociete fabriquerDaoJeuSociete() {
        return new DaoJeuSocieteImpl();
    }

    public static DaoAuteur fabriquerDaoAuteur() {
        return new DaoAuteurImpl();
    }


    public static DaoMaisonEdition fabriquerDaoMaisonEdition() {
        return new DaoMaisonEditionImpl();
    }
}
