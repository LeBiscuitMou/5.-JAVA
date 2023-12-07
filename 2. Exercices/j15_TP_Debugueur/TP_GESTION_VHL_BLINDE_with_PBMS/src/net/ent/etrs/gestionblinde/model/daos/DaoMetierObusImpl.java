package net.ent.etrs.gestionblinde.model.daos;

import net.ent.etrs.gestionblinde.model.daos.exceptions.DaoMetierObusException;
import net.ent.etrs.gestionblinde.model.entities.Obus;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;

import java.util.*;

public class DaoMetierObusImpl implements DaoMetierObus{

    private Set<Obus> persistance;

    @Override
    public Obus create(Obus lObus) throws DaoMetierObusException {
        if (!Objects.isNull(lObus) && persistance.add(lObus)){
            return lObus;
        }
        else {
            throw new DaoMetierObusException(ConstantesMetier.DAO_OBUS_IMPOSSIBLE_CREATE);
        }
    }

    @Override
    public Set<Obus> readAll() {
        return Collections.unmodifiableSet(persistance);
    }

    @Override
    public Obus update(Obus lObus) throws DaoMetierObusException {
        if(!Objects.isNull(lObus) && persistance.contains(lObus)){

            persistance.add(lObus);
            return lObus;
        }
        throw new DaoMetierObusException(ConstantesMetier.DAO_OBUS_IMPOSSIBLE_UPDATE);
    }

    @Override
    public void delete(String nom) {
        Set<Obus> obusSetTemporaire = new HashSet<>(persistance);
        if (!Objects.isNull(nom)){
            for (Obus o: obusSetTemporaire) {
                if (o.getNom().equals(nom)){
                    persistance.remove(o);
                }
            }
        }
    }
}
