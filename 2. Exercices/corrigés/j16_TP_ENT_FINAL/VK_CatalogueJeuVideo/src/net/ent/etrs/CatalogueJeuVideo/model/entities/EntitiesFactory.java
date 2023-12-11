package net.ent.etrs.CatalogueJeuVideo.model.entities;

import net.ent.etrs.CatalogueJeuVideo.model.exceptions.ConsoleException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.EntitiesException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.FabriquantException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.JeuVideoException;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstErrMsg;
import net.ent.etrs.CatalogueJeuVideo.model.references.Genre;
import net.ent.etrs.CatalogueJeuVideo.model.references.Pays;

import java.time.LocalDate;
import java.util.Map;

public final class EntitiesFactory {
    private EntitiesFactory() {  }

    public static JeuVideo fabriquerJeuVideo(String nom, LocalDate dateSortie, Genre genre, Fabriquant studioDev) throws EntitiesException {
        try {
            return new JeuVideo(nom, dateSortie, genre, studioDev);
        } catch (JeuVideoException e) {
            throw new EntitiesException(ConstErrMsg.JEU_VIDEO_CREATION, e);
        }
    }

    public static Fabriquant fabriquerFabriquant(String nom, LocalDate dateCreation, Pays pays) throws EntitiesException {
        try {
            return new Fabriquant(nom, dateCreation, pays);
        } catch (FabriquantException e) {
            throw new EntitiesException(ConstErrMsg.FABRIQUANT_CREATION, e);
        }
    }

    public static Console fabriquerConsole(String nom, Fabriquant fabriquant) throws EntitiesException {
        try {
            return new Console(nom, fabriquant);
        } catch (ConsoleException e) {
            throw new EntitiesException(ConstErrMsg.CONSOLE_CREATION, e);
        }
    }

    public static Console fabriquerConsole(String nom, Fabriquant fabriquant, Map<Pays, LocalDate> sorties) throws EntitiesException {
        try {
            return new Console(nom, fabriquant, sorties);
        } catch (ConsoleException e) {
            throw new EntitiesException(ConstErrMsg.CONSOLE_CREATION, e);
        }
    }
}
