package net.ent.etrs.CatalogueJeuVideo.model.entities;

import net.ent.etrs.CatalogueJeuVideo.model.exceptions.JeuVideoException;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstErrMsg;
import net.ent.etrs.CatalogueJeuVideo.model.references.Genre;
import net.ent.etrs.CatalogueJeuVideo.model.utils.StringVerif;
import net.ent.etrs.CatalogueJeuVideo.model.utils.exceptions.StringVerifException;

import java.time.LocalDate;
import java.util.*;

public class JeuVideo extends AbstractEntity implements Comparable<JeuVideo>{
    /* ******************************** VARIABLES ******************************** */
    private String nom;
    private LocalDate dateSortie;
    private Genre genre;
    private Fabriquant studioDev;
    private final Set<Console> plateformes = new HashSet<>();
    /* ******************************* CONSTRUCTOR ******************************* */
    protected JeuVideo(String nom, LocalDate dateSortie, Genre genre, Fabriquant studioDev) throws JeuVideoException {
        this.setNom(nom);
        this.setDateSortie(dateSortie);
        this.setGenre(genre);
        this.setStudioDev(studioDev);
    }

    /* ********************************* GETTERS ********************************* */
    public String getNom() {
        return nom;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public Genre getGenre() {
        return genre;
    }

    public Fabriquant getStudioDev() {
        return studioDev;
    }

    public Set<Console> getPlateformes() {
        return Collections.unmodifiableSet(plateformes);
    }
    /* ********************************* SETTERS ********************************* */

    private void setNom(String nom) throws JeuVideoException {
        try {
            StringVerif.verifierString(nom);
        } catch (StringVerifException e) {
            throw new JeuVideoException(ConstErrMsg.NOM_INCORRECT, e);
        }
        this.nom = nom;
    }


    private void setDateSortie(LocalDate dateSortie) throws JeuVideoException {
        if(Objects.isNull(dateSortie)){
            throw new JeuVideoException(ConstErrMsg.DATE_SORTIE_NULL);
        }
        // un jeu peut être prévu d'être sortie dans le futur.
        this.dateSortie = dateSortie;
    }

    public void setGenre(Genre genre) throws JeuVideoException {
        if(Objects.isNull(genre)){
            throw new JeuVideoException(ConstErrMsg.GENRE_NULL);
        }
        this.genre = genre;
    }

    private void setStudioDev(Fabriquant studioDev) throws JeuVideoException {
        if(Objects.isNull(studioDev)){
            throw new JeuVideoException(ConstErrMsg.STUDIO_DEV_NULL);
        }
        this.studioDev = studioDev;
    }
    /* ******************************** FONCTIONS ******************************** */

    public void addPlateforme(Console console) throws JeuVideoException {
        if(Objects.isNull(console)){
            throw new JeuVideoException(ConstErrMsg.CONSOLE_NULL);
        }
        if(!plateformes.add(console)){
            throw new JeuVideoException(ConstErrMsg.CONSOLE_EXIST);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JeuVideo jeuVideo)) return false;
        return Objects.equals(getNom(), jeuVideo.getNom()) && Objects.equals(getDateSortie(), jeuVideo.getDateSortie()) && Objects.equals(getStudioDev(), jeuVideo.getStudioDev());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getDateSortie(), getStudioDev());
    }

    @Override
    public String toString() {
        return "JeuVideo{" +
                "nom='" + nom + '\'' +
                ", dateSortie=" + dateSortie +
                ", genre=" + genre +
                ", studioDev=" + studioDev +
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
    public int compareTo(JeuVideo o) {
        int result = this.getNom().compareTo(o.getNom());
        if(result != 0){
            return result;
        }
        result = this.getDateSortie().compareTo(o.getDateSortie());
        if(result != 0){
            return result;
        }
        return this.getStudioDev().compareTo(o.getStudioDev());
    }

    /* **************************** PRIVATE FUNCTIONS **************************** */


}
