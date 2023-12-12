package net.ent.etrs.pjjeudesociete.models.entities;

import net.ent.etrs.pjjeudesociete.models.entities.exceptions.AuteurException;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.JeuSocieteException;
import net.ent.etrs.pjjeudesociete.models.entities.exceptions.MaisonEditionException;
import net.ent.etrs.pjjeudesociete.models.references.ConstanteMetier;
import net.ent.etrs.pjjeudesociete.models.references.Mecanisme;
import net.ent.etrs.pjjeudesociete.models.references.Pays;

import java.time.LocalDate;
import java.util.List;

public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Auteur fabriquerAuteur(String nom, String prenom) throws EntitiesFactoryException {
        try {
            return new Auteur(nom, prenom);
        } catch (AuteurException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_AUTEUR_ERROR, e);
        }
    }

    public static MaisonEdition fabriquerMaisonEdition(String nom, LocalDate dateFondation, Pays pays) throws EntitiesFactoryException {
        try {
            return new MaisonEdition(nom, dateFondation, pays);
        } catch (MaisonEditionException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_MAISON_ERROR, e);
        }
    }

    public static JeuSociete fabriquerJeuSociete(int nbJoueurMax, List<Mecanisme> mecanismes, int nbJoueurMin, float prixHT, MaisonEdition maisonEdition, String nom, Auteur auteur) throws EntitiesFactoryException {
        try {
            return new JeuSociete(nbJoueurMax, mecanismes, nbJoueurMin, prixHT, maisonEdition, nom, auteur);
        } catch (JeuSocieteException e) {
            throw new EntitiesFactoryException(ConstanteMetier.CONSTRUCTION_JDS_ERROR, e);
        }
    }
}