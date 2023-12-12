package net.ent.etrs.pjjeudesociete.models.entities;

import net.ent.etrs.pjjeudesociete.models.entities.exceptions.JeuSocieteException;
import net.ent.etrs.pjjeudesociete.models.entities.references.ConstantesMetier;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class JeuSociete extends AbstractEntity implements Comparable<JeuSociete> {

    private List<Mecanisme> mecanismes = new ArrayList<>();
    private String nom;
    private int nbJoueurMin;

    private int nbJoueurMax;
    private float prixHT;
    private Auteur auteur;

    private MaisonEdition maisonEdition;

    public JeuSociete(String nom, int nbJoueurMin, int nbJoueurMax, float prixHT, MaisonEdition maisonEdition, Auteur auteur, List<Mecanisme> lesMecanismes) throws JeuSocieteException {
        this.setNom(nom);
        this.setAuteur(auteur);
        this.setNbJoueurMin(nbJoueurMin);
        this.setNbJoueurMax(nbJoueurMax);
        this.setPrixHT(prixHT);
        this.setMecanismes(lesMecanismes);
        this.setMaisonEdition(maisonEdition);
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws JeuSocieteException {
        if (null == nom || nom.isBlank()) {
            throw new JeuSocieteException(ConstantesMetier.JDS_NOM_INCORRECT);
        }
        this.nom = nom;
    }

    public int getNbJoueurMin() {
        return nbJoueurMin;
    }

    private void setNbJoueurMin(int nbJoueur) throws JeuSocieteException {
        if (nbJoueur < ConstantesMetier.NB_JOUEUR_MIN) {
            throw new JeuSocieteException(ConstantesMetier.JDS_NB_JOUEUR_INCORRECT);
        }
        this.nbJoueurMin = nbJoueur;
    }

    public int getNbJoueurMax() {
        return nbJoueurMax;
    }

    private void setNbJoueurMax(int nbJoueur) throws JeuSocieteException {
        if (nbJoueur < ConstantesMetier.NB_JOUEUR_MIN) {
            throw new JeuSocieteException(ConstantesMetier.JDS_NB_JOUEUR_INCORRECT);
        }
        if (nbJoueur < this.nbJoueurMin) {
            throw new JeuSocieteException(ConstantesMetier.JDS_NB_JOUEUR_INCOHERENCE);
        }
        this.nbJoueurMax = nbJoueur;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) throws JeuSocieteException {
        if (prixHT < ConstantesMetier.PRIX_HT_MIN) {
            throw new JeuSocieteException(ConstantesMetier.JDS_PRIX_INCORRECT);
        }
        this.prixHT = prixHT;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) throws JeuSocieteException {
        if (Objects.isNull(auteur)) {
            throw new JeuSocieteException(ConstantesMetier.JDS_AUTEUR_INCORRECT);
        }
        this.auteur = auteur;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) throws JeuSocieteException {
        if (Objects.isNull(maisonEdition)) {
            throw new JeuSocieteException(ConstantesMetier.JDS_MAISON_EDITION_INCORRECT);
        }
        this.maisonEdition = maisonEdition;
    }

    public List<Mecanisme> getMecanismes() {
        return Collections.unmodifiableList(this.mecanismes);
    }

    private void setMecanismes(List<Mecanisme> categories) throws JeuSocieteException {
        if (Objects.isNull(categories)) {
            throw new JeuSocieteException(ConstantesMetier.JDS_CATEGORIES_INCORRECT);
        }
        this.mecanismes = categories;
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
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "JeuSociete{" +
                "nom='" + nom + '\'' +
                ", nbJoueurMin=" + nbJoueurMin +
                ", nbJoueurMax=" + nbJoueurMax +
                ", prixHT=" + prixHT +
                ", auteur=" + auteur +
                "} " + super.toString();
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(JeuSociete o) {
        return this.nom.compareTo(o.nom);
    }
}
