package net.ent.etrs.CatalogueJeuVideo.model.entities;

import net.ent.etrs.CatalogueJeuVideo.model.exceptions.FabriquantException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.JeuVideoException;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstErrMsg;
import net.ent.etrs.CatalogueJeuVideo.model.references.Pays;
import net.ent.etrs.CatalogueJeuVideo.model.utils.StringVerif;
import net.ent.etrs.CatalogueJeuVideo.model.utils.exceptions.StringVerifException;

import java.time.LocalDate;
import java.util.Objects;

public class Fabriquant extends AbstractEntity implements Comparable<Fabriquant> {
    /* ******************************** VARIABLES ******************************** */
    private String nom;
    private LocalDate dateCreation;
    private Pays pays;
    /* ******************************* CONSTRUCTOR ******************************* */

    protected Fabriquant(String nom, LocalDate dateCreation, Pays pays) throws FabriquantException {
        this.setNom(nom);
        this.setDateCreation(dateCreation);
        this.setPays(pays);
    }

    /* ********************************* GETTERS ********************************* */
    public String getNom() {
        return nom;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public Pays getPays() {
        return pays;
    }
    /* ********************************* SETTERS ********************************* */
    private void setNom(String nom) throws FabriquantException {
        try {
            StringVerif.verifierString(nom);
        } catch (StringVerifException e) {
            throw new FabriquantException(ConstErrMsg.NOM_INCORRECT, e);
        }
        this.nom = nom;
    }

    public void setDateCreation(LocalDate dateCreation) throws FabriquantException {
        if(Objects.isNull(dateCreation)){
            throw new FabriquantException(ConstErrMsg.DATE_CREATION_NULL);
        }
        if(dateCreation.isAfter(LocalDate.now())){
            throw new FabriquantException(ConstErrMsg.DATE_CREATION_FUTUR);
        }
        this.dateCreation = dateCreation;
    }

    public void setPays(Pays pays) throws FabriquantException {
        if(Objects.isNull(pays)){
            throw new FabriquantException(ConstErrMsg.PAYS_NULL);
        }
        this.pays = pays;
    }
    /* ******************************** FONCTIONS ******************************** */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fabriquant that)) return false;
        return Objects.equals(getNom(), that.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom());
    }

    @Override
    public String toString() {
        return "Fabriquant{" +
                "nom='" + nom + '\'' +
                ", dateCreation=" + dateCreation +
                ", pays=" + pays +
                '}';
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
    public int compareTo(Fabriquant o) {
        return this.getNom().compareTo(o.getNom());
    }

    /* **************************** PRIVATE FUNCTIONS **************************** */


}
