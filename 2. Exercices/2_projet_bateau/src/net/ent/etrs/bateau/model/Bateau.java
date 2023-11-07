package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.references.ConstanteMetier;
import net.ent.etrs.bateau.model.utils.VerificationUtils;

import java.util.Arrays;
import java.util.Objects;

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
        this.armements = new Armement[4];
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        // Test de base
        // SI c'est null
        if (Objects.isNull(nom)) {
            System.out.println(ConstanteMetier.BATEAU_ERROR_NULL);
        }
        if (null == nom) {
            System.out.println(ConstanteMetier.BATEAU_ERROR_NULL);
        }
        // Si c'est vide
        if (nom.isBlank()) {
            System.out.println("Le nom est vide et ne contient pas d'espace");
        }
        // Règles Métier
        // Limiter la taille du nom
        if (nom.length() > ConstanteMetier.BATEAU_NOM_LONGUEUR_MAX) {
            System.out.println("Le nom est trop grand");
        }
        // Pas de chiffre
        if (VerificationUtils.aUnChiffre(nom)) {
            System.out.println(ConstanteMetier.BATEAU_NOM_ERROR_CHIFFRE);
        }

        this.nom = nom;
    }

    public int getNbEquipage() {
        return nbEquipage;
    }

    public void setNbEquipage(int nbEquipage) {
        // Test de base
        if (nbEquipage < 0) {

        }

        // Tester la max
        if (nbEquipage > 4000) {

        }

        this.nbEquipage = nbEquipage;
    }

    public float getTonnage() {
        return tonnage;
    }

    public void setTonnage(float tonnage) {
        // Test de base
        if (tonnage < 0) {

        }

        // Tester la max
        if (tonnage > this.classe.getTonnageMax()) {

        }

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
        if (Objects.isNull(classe)) {
            System.out.println("La classe est null");
        }
        if (null == classe) {
            System.out.println("La classe est null");
        }


        this.classe = classe;
    }

    public Armement[] getArmements() {
        return Arrays.copyOf(this.armements, armements.length);
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

    public void ajouterArmement(Armement arme) {

    }

    public void retirerArmement(Armement arme) {

    }
}