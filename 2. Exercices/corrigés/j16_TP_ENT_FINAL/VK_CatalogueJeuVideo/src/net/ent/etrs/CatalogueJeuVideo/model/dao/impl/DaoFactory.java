package net.ent.etrs.CatalogueJeuVideo.model.dao.impl;

import net.ent.etrs.CatalogueJeuVideo.model.dao.IDaoConsole;
import net.ent.etrs.CatalogueJeuVideo.model.dao.IDaoFabriquant;
import net.ent.etrs.CatalogueJeuVideo.model.dao.IDaoJeuVideo;

import java.util.Objects;

public final class DaoFactory {
    private static IDaoJeuVideo iDaoJeuVideo;
    private static IDaoFabriquant iDaoFabriquant;
    private static IDaoConsole iDaoConsole;

    private DaoFactory() {  }

    public static IDaoJeuVideo fabriquerJeuVideoDao(){
        if(Objects.isNull(iDaoJeuVideo)){
            iDaoJeuVideo = new JeuVideoDaoImpl();
        }
        return iDaoJeuVideo;
    }

    public static IDaoFabriquant fabriquerFabriquantDao(){
        if(Objects.isNull(iDaoFabriquant)){
            iDaoFabriquant = new FabriquantDaoImpl();
        }
        return iDaoFabriquant;
    }

    public static IDaoConsole fabriquerConsoleDao(){
        if(Objects.isNull(iDaoConsole)){
            iDaoConsole = new ConsoleDaoImpl();
        }
        return iDaoConsole;
    }


}
