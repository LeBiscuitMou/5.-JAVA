package net.ent.etrs.bateau.model;

import java.util.Arrays;
import java.util.Objects;

public class Bateau {
    private String nom;
    private int nbEquipage;
    private float tonnage;
    private boolean estPret;
    private TypeBateau classe;
    private Armement[] armesBateau;

    public void ajouterArmement(Armement arme){
        this.armesBateau[0] = arme;

    }

    public void retirerArmement(Armement arme){

    }
    public Bateau(String leNom, int leNbEquipage, float leTonnage, boolean estPret, TypeBateau leTypeBateau) {
        this.setNom(leNom);
        this.setNbEquipage(leNbEquipage);
        this.setTonnage(leTonnage);
        this.setEstPret(estPret);
        this.setClasse(leTypeBateau);
        this.armesBateau = new Armement[4];
    }

    public Armement[] getArmesBateau() {
        return Arrays.copyOf(this.armesBateau,armesBateau.length);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        //Test de base
        //SI c'est null
        if(Objects.isNull(nom)){
            System.out.println("Le nom est null");
        }
        if(null == nom){
            System.out.println("Le nom est null");
        }
        //Si c'est vide
        if(nom.isBlank()){
            System.out.println("Le nom est vide et ne contient pas d'espace");
        }

        //Règles Métier
        //Limiter la taille du nom
        if (nom.length() > 15){
            System.out.println("Le nom est trop grand");
        }

        //Pas de chiffre
        //TODO coder la methode.

        this.nom = nom;
    }

    public int getNbEquipage() {
        return nbEquipage;
    }

    public void setNbEquipage(int nbEquipage) {
        //Test de base
        if(nbEquipage < 0){

        }

        //Tester la max
        if(nbEquipage > 4000){

        }

        this.nbEquipage = nbEquipage;
    }

    public float getTonnage() {
        return tonnage;
    }

    public void setTonnage(float tonnage) {
        //Test de base
        if(tonnage < 0){

        }

        //Tester la max
        if(tonnage > this.classe.getTonnageMax()){

        }
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
        if(Objects.isNull(classe)){
            System.out.println("la classe du bateau est null");
        }


        this.classe = classe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bateau bateau = (Bateau) o;
        return Objects.equals(nom, bateau.nom) && Objects.equals(classe, bateau.classe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, classe);
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
