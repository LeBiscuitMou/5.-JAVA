package net.ent.etrs.gestionblinde.model.daos;

import net.ent.etrs.gestionblinde.model.daos.exceptions.DaoMetierObusException;
import net.ent.etrs.gestionblinde.model.daos.exceptions.DaoMetierVehiculeBlindeException;
import net.ent.etrs.gestionblinde.model.entities.Obus;
import net.ent.etrs.gestionblinde.model.entities.VehiculeBlinde;
import net.ent.etrs.gestionblinde.model.references.ConstantesMetier;

import java.util.*;

public class DaoMetierVehiculeBlindeImpl implements DaoMetierVehiculeBlinde{

    private List<VehiculeBlinde> persistance = new ArrayList<>();

    @Override
    public VehiculeBlinde create(VehiculeBlinde vhl) throws DaoMetierVehiculeBlindeException {
        if (!Objects.isNull(vhl)){

            return persistance.get(persistance.indexOf(vhl));
        }
        else {
            throw new DaoMetierVehiculeBlindeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_CREATE);
        }
    }

    @Override
    public List<VehiculeBlinde> readAll() {  return new ArrayList<VehiculeBlinde>();}

    @Override
    public VehiculeBlinde update(VehiculeBlinde vhl) throws DaoMetierVehiculeBlindeException {
        if(Objects.isNull(vhl) && !persistance.contains(vhl)){
           persistance.set(persistance.indexOf(vhl), vhl);
           return persistance.get(persistance.indexOf(vhl));
        }
        throw new DaoMetierVehiculeBlindeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_UPDATE);
    }

    @Override
    public void delete(String emmat8) throws DaoMetierVehiculeBlindeException {
        if(!Objects.isNull(emmat8))
        {
            for (VehiculeBlinde v : persistance){
                if (v.getEmmat8()  == emmat8){
                    persistance.remove(v);
                }
            }
        }else {
            throw new DaoMetierVehiculeBlindeException(ConstantesMetier.DAO_VHLB_IMPOSSIBLE_DELETE);
        }

    }
}
