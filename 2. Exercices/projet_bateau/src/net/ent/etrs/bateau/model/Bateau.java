package net.ent.etrs.bateau.model;

public class Bateau {
    private String nom;
    private int nbEquipage;
    private float tonnage;
    private boolean estPret;
    private TypeBateau classe;
    private Armement[] armements;
    public Bateau(String nom, int nbEquipage, float tonnage, boolean estPret, TypeBateau classe, Armement[] armements) {
        this.setNom(nom);
        this.setNbEquipage(nbEquipage);
        this.setTonnage(tonnage);
        this.setEstPret(estPret);
        this.setClasse(classe);
        this.setArmements(armements);
    }

    public Bateau(String nom, int nbEquipage, float tonnage, boolean estPret, TypeBateau classe) {
        this.setNom(nom);
        this.setNbEquipage(nbEquipage);
        this.setTonnage(tonnage);
        this.setEstPret(estPret);
        this.setClasse(classe);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbEquipage() {
        return nbEquipage;
    }

    public void setNbEquipage(int nbEquipage) {
        this.nbEquipage = nbEquipage;
    }

    public float getTonnage() {
        return tonnage;
    }

    public void setTonnage(float tonnage) {
        this.tonnage = tonnage;
    }

    public boolean isEstPret() {
        return estPret;
    }

    public void setEstPret(boolean estPret) {
        this.estPret = estPret;
    }

    public TypeBateau getClasse() {
        return classe;
    }

    public void setClasse(TypeBateau classe) {
        this.classe = classe;
    }

    public Armement[] getArmements() {
        return armements;
    }

    public void setArmements(Armement[] armements) {
        this.armements = armements;
    }

    @Override
    public String toString() {
        return "Bateau{" +
                "nom='" + nom + '\'' +
                ", nbEquipage=" + nbEquipage +
                ", tonnage=" + tonnage +
                ", estPret=" + estPret +
                ", classe=" + classe +
                '}';
    }
}