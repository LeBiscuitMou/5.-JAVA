package net.ent.etrs.simugladiateur.modeles.entities;

import net.ent.etrs.simugladiateur.modeles.entities.references.ConstanteMetier;

import java.util.Objects;

public abstract class Gladiateur {

    private int nbVictoires = 0;
    private String nom;
    private int experience;

    public Gladiateur(String nom, int experience) {
        this.setNom(nom);
        this.setExperience(experience);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (Objects.nonNull(nom)) {
            this.nom = nom;
        } else {
            System.out.println("le nom ne doit pas être null");
        }
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if (experience > 0) {
            this.experience = experience;
        } else {
            System.out.println("l'expérience doit être positive'");
        }

    }

    public int getNbVictoires() {
        return nbVictoires;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gladiateur that = (Gladiateur) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    /**
     * Permet de recupérer le pourcentage en fonction de la race
     *
     * @param g2 gladiateur ENI
     * @return la chance de le vaincre
     */
    public abstract int chanceVaincre(Gladiateur g2);


    public void gagneUneVictoire() {
        this.nbVictoires++;
    }

    public void gagneExperience(Gladiateur gladiateur) {
        int deltaExp = this.getExperience() - gladiateur.getExperience();
        if (deltaExp < 0) {
            this.setExperience(this.experience + ConstanteMetier.EXP_VICTOIRE_FORT);
        } else {
            this.setExperience(this.experience + ConstanteMetier.EXP_VICTOIRE_FAIBLE);
        }
    }

    @Override
    public String toString() {
        return "Gladiateur{" +
                "nbVictoires=" + nbVictoires +
                ", nom='" + nom + '\'' +
                ", experience=" + experience +
                '}';
    }
}
