package net.ent.etrs.groupeMusique.model.utils;

import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;
import net.ent.etrs.groupeMusique.model.utils.exception.TableauUtilsException;
import net.ent.etrs.groupeMusique.model.utils.references.ConstanteUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 * Ici nous regroupons les methode utilitaire pour de la manipulation de tableau
 */
public final class TableauUtils {
    private TableauUtils() {
    }

    //agrandir un tableau de plusieurs cases

    /**
     * Permet d'agrandir un tableau de n cases
     * @param monTableau le tableau a agrandir
     * @param nbCase le nombre case supplémentaire
     * @return le tableau agrandit
     * @throws TableauUtilsException dans le cas ou le tableau est NULL ou s'il y est impossible d'ajouter un élément.
     */
    public static Object[] augmenterTailleTableau(Object[] monTableau, int nbCase) throws TableauUtilsException {
        if(null == monTableau){
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_OBJECT_NULL);
        }
        if(nbCase < 1){
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_NB_CASE_POSITIF);
        }
        return Arrays.copyOf(monTableau,monTableau.length+nbCase);
    }
    //réduire un tableau d'une case


    public static Object[] reduireTailleTableau(Object[] monTableau, int nbCase) throws TableauUtilsException {
        if(null == monTableau){
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_OBJECT_NULL);
        }
        if(nbCase >= 0 ){
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_NB_CASE_NEGATIF);
        }
        if(monTableau.length + nbCase < 0){
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_TABLEAU_OUT_OF_BAND);
        }
        return Arrays.copyOf(monTableau,monTableau.length+nbCase);
    }


    // ajouter un élément au tableau
    public static void put(Object objet, Object[] letableau, boolean agrandirTableau) throws TableauUtilsException {
        //verifier null
        if (Objects.isNull(objet) || Objects.isNull(letableau)) {
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_OBJECT_NULL);
        }

        if (possedePlaceTableau(letableau)){
            letableau[placeDisponibleTableau(letableau)] = objet;
        }
        else{
            if(agrandirTableau){
                letableau = augmenterTailleTableau(letableau,1);
                letableau[letableau.length - 1] = objet;
            }
            else{
                throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_IMPOSSIBLE_AJOUTER_AU_TABLEAU);
            }
        }

    }

    // rétirer un élément du tableau

    public static void retirerElementTableau(Object[] monTableau, Object objet ) throws TableauUtilsException {
        if(null==monTableau|| null== objet){
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_OBJECT_NULL);
        }

        if (rechercherObjet(monTableau, objet)){
            monTableau[recupererIndex(monTableau,objet)]=null;
        }
        else {
            throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_OBJECT_NOT_EXIST);
        }
    }

    private static int recupererIndex(Object[] monTableau, Object objet) throws TableauUtilsException {
        for (int i = 0; i < monTableau.length ; i++) {
            if (monTableau[i].equals(objet)){
                return i;
            }
        }
        throw new TableauUtilsException(ConstanteUtils.TABLEAU_UTILS_OBJECT_NOT_EXIST);
    }

    private static boolean rechercherObjet(Object[] monTableau, Object objet) {
        for (Object o: monTableau) {
            if(objet.equals(o)){
               return true;
            }
        }
        return false;
    }

    private static boolean possedePlaceTableau(Object[] monTableau) {
        for (Object obj : monTableau) {
            if (null == obj){
                return true;
            }
        }
        return false;
    }

    private static int placeDisponibleTableau(Object[] monTableau) {
        boolean retour = false;
        int cpt = 0;
        do{
            if(monTableau[cpt] == null){
                retour = true;
            }else{
                cpt++;
            }
        }while (!retour);

        return cpt;
    }


}
