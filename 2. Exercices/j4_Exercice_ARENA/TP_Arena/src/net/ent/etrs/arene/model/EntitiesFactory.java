package net.ent.etrs.arene.model;

import net.ent.etrs.arene.model.exceptions.*;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Gladiateur entrainerMirmillon(String nom, int experience) throws FactoryException {
        try {
            return new Mirmillon(nom, experience);
        } catch (GladiateurException e) {
            throw new FactoryException("Impossible d'entrainer le Mirmillon");
        }
    }

    public static Gladiateur entrainerThrace(String nom, int experience) throws FactoryException {
        try {
            return new Thrace(nom, experience);
        } catch (GladiateurException e) {
            throw new FactoryException("Impossible d'entrainer le Thrace");
        }
    }

    public static Gladiateur entrainerCrepulaire(String nom, int experience) throws FactoryException {
        try {
            return new Crepulaire(nom, experience);
        } catch (GladiateurException e) {

            throw new FactoryException("Impossible d'entrainer le Crepulaire");
        }
    }
}