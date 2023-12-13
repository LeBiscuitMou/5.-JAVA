package net.ent.etrs.poeleague.model.entities;

import net.ent.etrs.poeleague.model.entities.comparator.ChallengeRewardPointsComparator;
import net.ent.etrs.poeleague.model.entities.exceptions.LeagueException;
import net.ent.etrs.poeleague.model.entities.references.ConstantMetier;

import java.time.LocalDate;
import java.util.*;

public class League extends AbstractEntity {

    private Map<Personnage, Integer> classement = new HashMap<>();
    private Set<Challenge> lesChallenges = new TreeSet<>(new ChallengeRewardPointsComparator());
    private String nom;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public League(String nom, LocalDate dateDebut, LocalDate dateFin) throws LeagueException {
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
        this.setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws LeagueException {
        if (null == nom || nom.isBlank()) {
            throw new LeagueException(ConstantMetier.LEAGUE_NOM_INCORRECT);
        }
        if (nom.length() < ConstantMetier.LEAGUE_NOM_MINIMUM_CARACTERE) {
            throw new LeagueException(ConstantMetier.LEAGUE_NOM_TAILLE_INCORRECT);
        }
        this.nom = nom;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) throws LeagueException {
        if (Objects.isNull(dateDebut)) {
            throw new LeagueException(ConstantMetier.LEAGUE_DATEDEBUT_NULL);
        }
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void ajouterChallenge(Challenge challenge) throws LeagueException {
        if (Objects.isNull(challenge)) {
            throw new LeagueException(ConstantMetier.LEAGUE_CHALLENGE_NULL);
        }
        this.lesChallenges.add(challenge);
    }

    public Set<Challenge> getLesChallenges() {
        return Collections.unmodifiableSet(this.lesChallenges);
    }

    /**
     * Permet de savoir si une League est valide
     *
     * @return si la league est valide
     */
    public boolean estValide() {
        return !getLesChallenges().isEmpty()
                && getLesChallenges().size() >= ConstantMetier.NB_MIN_CHALLENGE
                && ContientMinRewardPoints();
    }

    private boolean ContientMinRewardPoints() {
        return getLesChallenges().stream().mapToInt(Challenge::getRewardPoints).sum() >= ConstantMetier.NB_MIN_REWARD_PTS;
    }

    public void ajouterPersonnage(Personnage personnage, Integer classement) throws LeagueException {
        if (Objects.isNull(personnage) || Objects.isNull(classement)) {
            throw new LeagueException(ConstantMetier.LEAGUE_PERS_INVALID);
        }
        this.classement.put(personnage, classement);
    }

    public Map<Personnage, Integer> getClassement() {
        return Collections.unmodifiableMap(this.classement);
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
        return Objects.hash(super.hashCode(), nom);
    }

    @Override
    public String toString() {
        return "League{" +
                "nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                "} " + super.toString();
    }
}
