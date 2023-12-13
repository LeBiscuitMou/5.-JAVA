package net.ent.etrs.gestionLeague.models.entities;

import net.ent.etrs.gestionLeague.models.entities.exceptions.LeagueException;
import net.ent.etrs.gestionLeague.models.entities.references.ConstantesMetier;

import java.time.LocalDate;
import java.util.*;

public class League extends AbstractEntity implements Comparable<League> {
    private Map<Personnage, Integer> classement = new HashMap<>();
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Set<Challenge> lesChallenges = new HashSet<>();
    private String nom;

    public League(LocalDate dateDebut, LocalDate dateFin, String nom) throws LeagueException {
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
        this.setNom(nom);
    }

    public Map<Personnage, Integer> getClassement() {
        return Collections.unmodifiableMap(classement);
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) throws LeagueException {
        if (Objects.isNull(dateDebut)) {
            throw new LeagueException(ConstantesMetier.LEAGUE_DATEDEBUT_NULL);
        }
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) throws LeagueException {
        if (Objects.isNull(dateFin)) {
            dateFin = LocalDate.MAX;
        }
        if (dateFin.isBefore(this.dateDebut)) {
            throw new LeagueException(ConstantesMetier.LEAGUE_DATEDEBUT_INVALIDE);
        }
        this.dateFin = dateFin;
    }

    public Set<Challenge> getLesChallenges() {
        return Collections.unmodifiableSet(lesChallenges);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws LeagueException {
        if (Objects.isNull(nom) || nom.isBlank()) {
            throw new LeagueException(ConstantesMetier.LEAGUE_NOM_INCORRECT);
        }
        if (nom.length() < ConstantesMetier.NB_CARACTERES_MIN) {
            throw new LeagueException(ConstantesMetier.LEAGUE_NOM_TROP_COURT);
        }
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return Objects.equals(nom, league.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "League{" +
                "dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", nom='" + nom + '\'' +
                '}';
    }

    public void ajouterChallenge(Challenge challenge) throws LeagueException {
        if (Objects.isNull(challenge)) {
            throw new LeagueException(ConstantesMetier.LEAGUE_CHALLENGE_NULL);
        }
        this.lesChallenges.add(challenge);
    }

    public boolean estValide() {
        if (this.lesChallenges.isEmpty() || this.lesChallenges.size() < ConstantesMetier.NB_MIN_CHALLENGE) {
            return false;
        }
        return ContientMinRewardPoints();
    }

    public void ajouterPersonnage(Personnage personnage, Integer numClassement) throws LeagueException {
        if (Objects.isNull(personnage)) {
            throw new LeagueException(ConstantesMetier.LEAGUE_PERS_INVALID);
        }
        this.classement.put(personnage, numClassement);
    }

    private boolean ContientMinRewardPoints() {
        Integer pointTotal = 0;
        for (Challenge c : lesChallenges) {
            pointTotal += c.getRewardPoints();
        }

        return pointTotal >= ConstantesMetier.NB_MIN_REWARD_PTS;
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
    public int compareTo(League o) {
        return this.nom.compareTo(o.nom);
    }
}