package net.ent.etrs.pjjeudesociete.models.entities;

import net.ent.etrs.pjjeudesociete.models.entities.exceptions.JeuSocieteException;
import net.ent.etrs.pjjeudesociete.models.references.ConstanteMetier;
import net.ent.etrs.pjjeudesociete.models.references.Mecanisme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class JeuSociete extends AbstractEntity {
    private int nbJoueurMax;
    private List<Mecanisme> mecanismes = new ArrayList<>();
    private int nbJoueurMin;
    private float prixHT;
    private MaisonEdition maisonEdition;
    private String nom;
    private Auteur auteur;

    protected JeuSociete(int nbJoueurMax, List<Mecanisme> mecanismes, int nbJoueurMin, float prixHT, MaisonEdition maisonEdition, String nom, Auteur auteur) throws JeuSocieteException {
        this.setNbJoueurMax(nbJoueurMax);
        this.setMecanismes(mecanismes);
        this.setNbJoueurMin(nbJoueurMin);
        this.setPrixHT(prixHT);
        this.setMaisonEdition(maisonEdition);
        this.setNom(nom);
        this.setAuteur(auteur);
    }

    public int getNbJoueurMax() {
        return nbJoueurMax;
    }

    private void setNbJoueurMax(int nbJoueurMax) throws JeuSocieteException {
        if (nbJoueurMax <= 0) {
            throw new JeuSocieteException(ConstanteMetier.JDS_NB_JOUEUR_INCORRECT);
        }
        if (nbJoueurMax < this.nbJoueurMin) {
            throw new JeuSocieteException(ConstanteMetier.JDS_NB_JOUEUR_INCOHERENCE);
        }
        this.nbJoueurMax = nbJoueurMax;
    }

    public List<Mecanisme> getMecanismes() {
        return Collections.unmodifiableList(mecanismes);
    }

    private void setMecanismes(List<Mecanisme> mecanismes) {
        this.mecanismes = mecanismes;
    }

    public int getNbJoueurMin() {
        return nbJoueurMin;
    }

    private void setNbJoueurMin(int nbJoueurMin) throws JeuSocieteException {
        if (nbJoueurMin <= ConstanteMetier.NB_JOUEUR_MIN) {
            throw new JeuSocieteException(ConstanteMetier.JDS_NB_JOUEUR_INCORRECT);
        }
        if (nbJoueurMin > this.nbJoueurMax) {
            throw new JeuSocieteException(ConstanteMetier.JDS_NB_JOUEUR_INCOHERENCE);
        }
        this.nbJoueurMin = nbJoueurMin;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) throws JeuSocieteException {
        if (prixHT < ConstanteMetier.PRIX_MINIMUM) {
            throw new JeuSocieteException(ConstanteMetier.JDS_PRIX_INCORRECT);
        }
        this.prixHT = prixHT;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) throws JeuSocieteException {
        if (Objects.isNull(maisonEdition)) {
            throw new JeuSocieteException(ConstanteMetier.JDS_MAISON_EDITION_INCORRECT);
        }
        this.maisonEdition = maisonEdition;
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws JeuSocieteException {
        if (Objects.isNull(nom) || nom.isBlank()) {
            throw new JeuSocieteException(ConstanteMetier.JDS_NOM_INCORRECT);
        }
        this.nom = nom;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) throws JeuSocieteException {
        if (Objects.isNull(auteur)) {
            throw new JeuSocieteException(ConstanteMetier.JDS_AUTEUR_INCORRECT);
        }
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JeuSociete that = (JeuSociete) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nom);
    }

    @Override
    public String toString() {
        return "JeuSociete{" +
                "nbJoueurMax=" + nbJoueurMax +
                ", nbJoueurMin=" + nbJoueurMin +
                ", prixHT=" + prixHT +
                ", maisonEdition=" + maisonEdition +
                ", nom='" + nom + '\'' +
                ", auteur=" + auteur +
                '}';
    }
}