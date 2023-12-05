package net.etrs.ent.demoComparableComparator.model.entities;

import net.etrs.ent.demoComparableComparator.model.entities.references.GradeOtan;

import java.util.Objects;

public class Militaire implements Comparable<Militaire>{

    private String nid;
    private GradeOtan grade;
    private String nom;
    private String prenom;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public GradeOtan getGrade() {
        return grade;
    }

    public void setGrade(GradeOtan grade) {
        this.grade = grade;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Militaire(String nid, GradeOtan grade, String nom, String prenom) {
        this.setNid(nid);
        this.setGrade(grade);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Militaire militaire = (Militaire) o;
        return Objects.equals(nid, militaire.nid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid);
    }

    @Override
    public String toString() {
        return "Militaire{" +
                "nid='" + nid + '\'' +
                ", grade=" + grade +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    @Override
    public int compareTo(Militaire o) {
        return this.nid.compareTo(o.getNid());
    }
}
