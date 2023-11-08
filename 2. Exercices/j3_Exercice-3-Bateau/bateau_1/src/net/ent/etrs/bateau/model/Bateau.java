package net.ent.etrs.bateau.model;

public class Bateau {
    private String nom;
    private int nbEquipage;
    private float tonnage;
    private boolean estPret;
    private TypeBateau classe;

    public Bateau(String leNom, int leNbEquipage, float leTonnage, boolean estPret, TypeBateau leTypeBateau) {
        this.setNom(leNom);
        this.setNbEquipage(leNbEquipage);
        this.setTonnage(leTonnage);
        this.setEstPret(estPret);
        this.setClasse(leTypeBateau);
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
