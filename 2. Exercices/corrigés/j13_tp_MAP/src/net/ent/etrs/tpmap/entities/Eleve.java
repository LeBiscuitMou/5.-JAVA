package net.ent.etrs.tpmap.entities;

import java.util.Objects;

//LBK

public class Eleve implements Comparable<Eleve> {

    //LBK

    private String nid;

    private String nom;

    private String prenom;

    public Eleve(String nid, String nom, String prenom) {
        this.setNid(nid);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleve eleve = (Eleve) o;
        return Objects.equals(nid, eleve.nid) && Objects.equals(nom, eleve.nom) && Objects.equals(prenom, eleve.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid, nom, prenom);
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "nid='" + nid + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    @Override
    public int compareTo(Eleve o) {
        int retour = this.getNom().compareTo(o.getNom());
        return retour == 0 ? this.getPrenom().compareTo(o.getPrenom()) : retour;
    }
}
