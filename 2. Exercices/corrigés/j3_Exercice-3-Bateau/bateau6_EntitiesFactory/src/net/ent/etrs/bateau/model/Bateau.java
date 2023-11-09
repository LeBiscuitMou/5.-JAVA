package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;
import net.ent.etrs.bateau.model.utils.VerificationUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * Classe Bateau.
 */
public abstract class Bateau {

    private String nom;
    private int nbEquipage;
    private float tonnage;
    private boolean estPret;
    private final Armement[] armements;

    private String moyenPropulsion;


    public Bateau(String nom, int nbEquipage, float tonnage,String moyenPropulsion) throws BateauException {
        this.setNom(nom);
        this.setNbEquipage(nbEquipage);
        this.setTonnage(tonnage);
        this.armements = new Armement[4];
        this.setMoyenPropulsion(moyenPropulsion);
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws BateauException {
        // Test de base
        // si c'est null
        if (Objects.isNull(nom)){
            throw new BateauException(ConstantesMetier.BATEAU_NOM_ERROR_NULL);
        }
        // si c'est vide
        if (nom.isBlank()){
            throw new BateauException(ConstantesMetier.BATEAU_NOM_ERROR_EMPTY);
        }

        // Règles métiers
        // limiter la taille
        if (nom.length() > ConstantesMetier.BATEAU_NOM_LONGUEUR_MAX){
            throw new BateauException(ConstantesMetier.BATEAU_NOM_ERROR_SIZE);
        }
        // pas de chiffre
        if(VerificationUtils.verificationStringContain(nom)){
            throw new BateauException(ConstantesMetier.BATEAU_NOM_ERROR_NUMBER);
        }
        this.nom = nom;
    }


    public int getNbEquipage() {
        return nbEquipage;
    }

    public void setNbEquipage(int nbEquipage) throws BateauException {
        if (nbEquipage < ConstantesMetier.BATEAU_NB_EQUIPAGE_MIN){
            throw new BateauException(ConstantesMetier.BATEAU_NB_EQUIPAGE_ERROR_SIZE );
        }

        if (nbEquipage > ConstantesMetier.BATEAU_NB_EQUIPAGE_MAX){
            throw new BateauException(ConstantesMetier.BATEAU_NB_EQUIPAGE_ERROR_SIZE );
        }
        this.nbEquipage = nbEquipage;
    }

    public float getTonnage() {
        return tonnage;
    }

    public void setTonnage(float tonnage) throws BateauException {
        if (tonnage < ConstantesMetier.BATEAU_TONNAGE_MIN){
            throw new BateauException(ConstantesMetier.BATEAU_TONNAGE_ERROR_SIZE + " " + tonnage);
        }

//        if (tonnage > this.classe.getTonnageMax()){
//            throw new BateauException(ConstantesMetier.BATEAU_TONNAGE_ERROR_SIZE + " " + tonnage);
//        }
        this.tonnage = tonnage;
    }

    public boolean getEstPret() {
        return estPret;
    }

    public void setEstPret(boolean estPret) {
        this.estPret = estPret;
    }

    public Armement[] getArmement() {
        return Arrays.copyOf(armements, armements.length) ;
    }

    public String getAllArmement() {
        StringBuilder listeArmement = new StringBuilder();
        for (Armement arme: armements) {
            listeArmement.append(arme.toString());
            listeArmement.append("\n");
        }
        return listeArmement.toString();
    }

    public String getMoyenPropulsion() {
        return moyenPropulsion;
    }

    public abstract void setMoyenPropulsion(String moyenPropulsion);

    public void ajouterArmements(Armement armement) throws BateauException {
        if (Objects.isNull(armement)){
            throw new BateauException(ConstantesMetier.BATEAU_ARMEMENT_ERROR_NULL);
        }
        for (int i = 0; i < armements.length; i++) {
            if (this.armements[i] == null){
                this.armements[i] = armement;
                // j'ai pu ajouter mon armement, alors je quitte la fonction.
                return;
            }
        }
        System.out.println("plus de place pour cette armement: " + armement.toString());
    }

    public void changerArmements(Armement armement, int place) throws BateauException {
        if (Objects.isNull(armement)){
            throw new BateauException(ConstantesMetier.BATEAU_ARMEMENT_ERROR_NULL);
        }
        if (place < this.armements.length && place >= 0){
            this.armements[place] = armement;
        }
        else {
            System.out.println("emplacement invalide");
        }
    }

    public void enleverArmements(int place) {
        if (place < this.armements.length && place >= 0){
            this.armements[place] = null;
        }
        else {
            System.out.println("emplacement invalide");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bateau bateau = (Bateau) o;
        return Objects.equals(nom, bateau.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Bateau{" +
                "nom='" + nom + '\'' +
                ", nbEquipage=" + nbEquipage +
                ", tonnage=" + tonnage +
                ", estPret=" + estPret +
                '}';
    }
}
