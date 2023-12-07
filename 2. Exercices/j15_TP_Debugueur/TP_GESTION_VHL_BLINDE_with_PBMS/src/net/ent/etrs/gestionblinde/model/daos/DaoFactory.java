package net.ent.etrs.gestionblinde.model.daos;

public final class DaoFactory {
    private static DaoMetierObus daoMetierObus;
    private static DaoMetierVehiculeBlinde daoMetierVehiculeBlinde;

    private DaoFactory() {
    }

    public static DaoMetierObus fabriquerDaoMetierObusImpl() {
        if (null == daoMetierObus) {
            daoMetierObus = new DaoMetierObusImpl();
        }
        return daoMetierObus;
    }

    public static DaoMetierVehiculeBlinde fabriquerDaoMetierVehiculeBlindeImpl() {
        if (null == daoMetierVehiculeBlinde) {
            daoMetierVehiculeBlinde = new DaoMetierVehiculeBlindeImpl();
        }
        return daoMetierVehiculeBlinde;
    }
}
