package net.ent.etrs.poeleague.model.entities;

import net.ent.etrs.poeleague.model.entities.exceptions.ChallengeException;
import net.ent.etrs.poeleague.model.entities.references.ConstantMetier;

import java.util.Objects;

public class Challenge extends AbstractEntity implements Comparable<Challenge> {
    private String nom;

    private String desc;

    private Integer rewardPoints;

    public Challenge(String nom, String desc, Integer rewardPoints) throws ChallengeException {
        this.setNom(nom);
        this.setDesc(desc);
        this.setRewardPoints(rewardPoints);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ChallengeException {
        if (null == nom || nom.isBlank()) {
            throw new ChallengeException(ConstantMetier.CHALLENGE_NOM_INCORRECT);
        }
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) throws ChallengeException {
        if (Objects.isNull(rewardPoints)) {
            throw new ChallengeException(ConstantMetier.CHALLENGE_REWARDPTS_NULL);
        }
        if (rewardPoints < 0) {
            throw new ChallengeException(ConstantMetier.CHALLENGE_REWARDPTS_NEGATIF);
        }
        this.rewardPoints = rewardPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(nom, challenge.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nom);
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "nom='" + nom + '\'' +
                ", desc='" + desc + '\'' +
                ", rewardPoints=" + rewardPoints +
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
    public int compareTo(Challenge o) {
        return this.nom.compareTo(o.getNom());
    }
}
