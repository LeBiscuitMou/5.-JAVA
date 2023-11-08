package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.TypeBateauException;
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
    private Armement[] armesBateau;

    public void ajouterArmement(Armement arme){
        this.armesBateau[0] = arme;
    }

    public void retirerArmement(Armement arme){

    }
    public Bateau(String leNom, int leNbEquipage, float leTonnage, boolean estPret, TypeBateau leTypeBateau) throws BateauException, TypeBateauException {
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

    public void setNom(String nom) throws BateauException {
        //Test de base
        //SI c'est null
        if(Objects.isNull(nom)){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_IS_NULL);
        }
        //Si c'est vide
        if(nom.isBlank()){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_IS_BLANK);
        }

        //Règles Métier
        //Limiter la taille du nom
        if (nom.length() > ConstanteMetier.BATEAU_NOM_LONGUEUR_MAX){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_TROP_GRAND);
        }

        //Pas de chiffre
        //TODO coder la methode.
        if(VerificationUtils.aUnChiffre(nom)){
            throw new BateauException(ConstanteMetier.BATEAU_NOM_ERROR_CHIFFRE);
        }

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

    public void setClasse(TypeBateau classe) throws BateauException {
        if(Objects.isNull(classe)){
            throw new BateauException("la classe du bateau est null");
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
