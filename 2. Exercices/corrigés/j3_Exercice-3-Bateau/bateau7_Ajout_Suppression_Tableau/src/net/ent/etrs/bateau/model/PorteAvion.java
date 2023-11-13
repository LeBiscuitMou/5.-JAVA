package net.ent.etrs.bateau.model;

import net.ent.etrs.bateau.model.exceptions.BateauException;
import net.ent.etrs.bateau.model.exceptions.PorteAvionException;
import net.ent.etrs.bateau.model.references.ConstantesMetier;

import java.util.Arrays;
import java.util.Objects;

public class PorteAvion extends Bateau{

    private Avion[] avionsEmbarques;
    public PorteAvion(String nom, int nbEquipage, float tonnage, String moyenpropulsion) throws BateauException {
        super(nom, nbEquipage, tonnage, moyenpropulsion);
        avionsEmbarques = new Avion[ConstantesMetier.PORTE_AVION_NB_AVIONS_EMBARQUE];
    }

    @Override
    public void setMoyenPropulsion(String moyenPropulsion) {

    }

    public Avion[] getAvionsEmbarques() {
        return Arrays.copyOf(avionsEmbarques,avionsEmbarques.length);
    }

    public void ajouterUnAvion(Avion avionAAjouter) throws PorteAvionException {
        //Avion ajouter non null
        if(Objects.isNull(avionAAjouter)){
            throw new PorteAvionException(ConstantesMetier.PORTE_AVION_AVION_AJOUTER_NULL);
        }
        //Verifier qu'il est ajoutable (vérification de la place)
        if(PossedePlacePorteAvion()){
            //Ajouter l'avion
            this.avionsEmbarques[placeDisponiblePorteAvion()] = avionAAjouter;
        }else {
            throw new PorteAvionException(ConstantesMetier.PORTE_AVION_AVION_FULL);
        }
    }

    private int placeDisponiblePorteAvion() {
        boolean retour = false;
        int cpt = 0;
        do{
            if(this.avionsEmbarques[cpt] == null){
                retour = true;
            }else{
                cpt++;
            }
        }while (!retour);

        return cpt;
    }

    private boolean PossedePlacePorteAvion() {
//        boolean retour = false;
//        int cpt = 0;
//        do{
//            if(this.avionsEmbarques[cpt] == null){
//                retour = true;
//            }else{
//                cpt++;
//            }
//        }while (!retour || cpt == this.avionsEmbarques.length-1);
//
//        return retour;

        // v2
        for (Avion a : this.avionsEmbarques) {
            if (null == a){
                return true;
            }
        }
        return false;


    }


    public void retirerUnAvion(Avion avionAAjouter) throws PorteAvionException {
        //Verifier avionAAjouter n'est pas null
        if(Objects.isNull(avionAAjouter)){
            throw new PorteAvionException(ConstantesMetier.PORTE_AVION_AVION_RETIRER_NULL);
        }
        //Verifier que l'avion est dans le table
        if(avionEstSurPorteAvion(avionAAjouter)){
            //Si oui le retirer
            this.avionsEmbarques[positionAvionRetirer(avionAAjouter)] = null;
        }else{
            throw new PorteAvionException(ConstantesMetier.PORTE_AVION_AVION_NOT_EXIST);
        }
    }

    private int positionAvionRetirer(Avion avion) {
        boolean retour = false;
        int cpt = 0;
        do{
            if(this.avionsEmbarques[cpt].equals(avion)){
                retour = true;
            }else{
                cpt++;
            }
        }while (!retour);
        return cpt;
    }

    private boolean avionEstSurPorteAvion(Avion avion) {
        for (Avion a : this.avionsEmbarques) {
            if (a.equals(avion)){
                return true;
            }
        }
        return false;
    }

}
