package net.ent.etrs.gestionJeuxVideo.models.dao.impl;

import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoConsole;
import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoFabriquant;
import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoJeuVideo;

public final class DaoFactory {
    private DaoFactory() {
    }
    public static IDaoJeuVideo fabriquerDaoJeuVideo() {
        return new DaoJeuVideoImplMem();
    }

    public static IDaoConsole fabriquerDaoConsole() {
        return new DaoConsoleImplMem();
    }

    public static IDaoFabriquant fabriquerDaoFabriquant() {
        return new DaoFabriquantImplMem();
    }
}