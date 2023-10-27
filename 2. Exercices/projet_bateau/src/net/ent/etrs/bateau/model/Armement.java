package net.ent.etrs.bateau.model;

public class Armement {
    private String nom;
    private float calibre;
    private int portee;

    public Armement(String nom, float calibre, int portee) {
        this.setNom(nom);
        this.setCalibre(calibre);
        this.setPortee(portee);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getCalibre() {
        return calibre;
    }

    public void setCalibre(float calibre) {
        this.calibre = calibre;
    }

    public int getPortee() {
        return portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    @Override
    public String toString() {
        return "Armement{" +
                "nom='" + nom + '\'' +
                ", calibre=" + calibre +
                ", portee=" + portee +
                '}';
    }
}