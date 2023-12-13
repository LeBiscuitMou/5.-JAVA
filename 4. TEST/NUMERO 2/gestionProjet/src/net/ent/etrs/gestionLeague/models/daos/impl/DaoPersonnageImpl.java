package net.ent.etrs.gestionLeague.models.daos.impl;

import net.ent.etrs.gestionLeague.models.daos.IDaoPersonnage;
import net.ent.etrs.gestionLeague.models.daos.MemBaseDao;
import net.ent.etrs.gestionLeague.models.entities.Personnage;

public class DaoPersonnageImpl extends MemBaseDao<Personnage> implements IDaoPersonnage {
    protected DaoPersonnageImpl() {
    }
}