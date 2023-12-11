package net.ent.etrs.gestionJeuxVideo.models.entities;

import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.ConsoleException;
import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.FabriquantException;
import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.JeuVideoException;
import net.ent.etrs.gestionJeuxVideo.models.references.ConstanteMetier;
import net.ent.etrs.gestionJeuxVideo.models.references.Genre;
import net.ent.etrs.gestionJeuxVideo.models.references.Pays;

import java.time.LocalDate;
import java.util.Map;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static JeuVideo fabriquerJeuVideo(Fabriquant studioDev, LocalDate dateSortie, String nom, Genre genre) throws EntitiesFactoryException {
        try {
            return new JeuVideo(studioDev, dateSortie, nom, genre);
        } catch (JeuVideoException e) {
            throw new EntitiesFactoryException(ConstanteMetier.ENTITIES_JEUVIDEO_ERROR, e);
        }
    }

    public static Fabriquant fabriquerFabriquant(LocalDate dateCreation, String nom, Pays pays) throws EntitiesFactoryException {
        try {
            return new Fabriquant(dateCreation, nom, pays);
        } catch (FabriquantException e) {
            throw new EntitiesFactoryException(ConstanteMetier.ENTITIES_FABRIQUANT_ERROR, e);
        }
    }

    public static Console fabriquerConsole(Fabriquant fabriquant, String nom) throws EntitiesFactoryException {
        try {
            return new Console(fabriquant, nom);
        } catch (ConsoleException e) {
            throw new EntitiesFactoryException(ConstanteMetier.ENTITIES_CONSOLE_ERROR, e);
        }
    }

    public static Console fabriquerConsole(Fabriquant fabriquant, String nom, Map<Pays, LocalDate> sorties) throws EntitiesFactoryException {
        try {
            Console c = new Console(fabriquant, nom);
            c.setSortiePays();
        } catch (ConsoleException e) {
            throw new EntitiesFactoryException(ConstanteMetier.ENTITIES_CONSOLE_ERROR, e);
        }
    }
}