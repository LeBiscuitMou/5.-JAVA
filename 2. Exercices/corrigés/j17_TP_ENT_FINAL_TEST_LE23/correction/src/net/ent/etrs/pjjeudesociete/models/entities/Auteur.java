package net.ent.etrs.pjjeudesociete.models.entities;

import net.ent.etrs.pjjeudesociete.models.entities.exceptions.AuteurException;
import net.ent.etrs.pjjeudesociete.models.entities.references.ConstantesMetier;

import java.util.Objects;

public class Auteur extends AbstractEntity implements Comparable<Auteur> {

    private String nom;

    private String prenom;

    public Auteur(String nom, String prenom) throws AuteurException {
        setNom(nom);
        setPrenom(prenom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws AuteurException {
        if (null == nom || nom.isBlank()) {
            throw new AuteurException(ConstantesMetier.AUTEUR_NOM_INCORRECT);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws AuteurException {
        if (null == prenom || prenom.isBlank()) {
            throw new AuteurException(ConstantesMetier.AUTEUR_PRENOM_INCORRECT);
        }
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Objects.equals(nom, auteur.nom) && Objects.equals(prenom, auteur.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
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
    public int compareTo(Auteur o) {
        int result = this.nom.compareTo(o.nom);
        return result == 0 ? this.prenom.compareTo(o.prenom) : result;
    }
}
