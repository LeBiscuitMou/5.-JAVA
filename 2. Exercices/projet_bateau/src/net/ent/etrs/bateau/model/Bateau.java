package net.ent.etrs.bateau.model;

public class Bateau {
    private String nom;
    private int nbEquipage;
    private float tonnage;
    private boolean estPret;
    private TypeBateau classe;

    public Bateau(String nom, int nbEquipage, float tonnage, boolean estPret, TypeBateau classe) {
        this.nom = nom;
        this.nbEquipage = nbEquipage;
        this.tonnage = tonnage;
        this.estPret = estPret;
        this.classe = classe;
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

    public void afficherInfoBateau() {
        System.out.println("Nom du bâteau : " + nom);
        System.out.println("Nombre équipage : " + nbEquipage);
        System.out.println("Tonnage : " + tonnage);
        System.out.println("Prêt ? " + estPret);
    }
}