package net.ent.etrs.start;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.ent.etrs.commons.utils.AffichageConsole;
import net.ent.etrs.commons.utils.LectureConsole;
import net.ent.etrs.model.entities.*;
import net.ent.etrs.model.entities.exceptions.MaterielInformatiqueConstructionException;
import net.ent.etrs.model.entities.references.Constantes;
import net.ent.etrs.model.entities.references.TailleEcran;
import net.ent.etrs.model.entities.references.TypeOrdinateur;
import net.ent.etrs.model.entities.references.TypeReseau;
import net.ent.etrs.model.facade.FacadeMetier;
import net.ent.etrs.model.facade.FacadeMetierFactory;
import net.ent.etrs.model.facade.exceptions.BusinessException;
import net.ent.etrs.start.exceptions.SaisieMaterielInformatiqueException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Presenter {

    private static FacadeMetier facadeMetier;

    public static void main(String[] args) {
        facadeMetier = FacadeMetierFactory.fabriquerFacadeMetier();
        facadeMetier.initialierApplication();
        int choix = 0;
        do {
            // afficher le menu
            choix = afficherMenu();
            // traiter les options du menu
            traiterOption(choix);

        } while (choix != 0);
    }

    private static int afficherMenu() {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(Arrays.asList(Constantes.MENU),"Gestion de parc informatique");
        return LectureConsole.lectureChoixInt(0, Constantes.MENU.length);
    }

    private static void traiterOption(final int choix) {
        switch (choix) {
            case 1: //Créer un matériel informatique
                creerMaterielInformatique();
                break;
            case 2: //Supprimer un matériel informatique
                supprimerMaterielInformatique();
                break;
            case 3: //Lister les matériel informatiques
                listerMaterielInformatique();
                break;
            case 4: //Affecter un matériel informatique à une pièce
                affecterMaterielInformatiquePiece();
                break;
            case 5: //Lister les matériel informatiques d'un bâtiment
                listerMaterielInformatiqueBatiment();
                break;
            default:
                break;
        }

    }

    /**
     * Affiche la liste des matériels informatique d'un bâtiment sélectionné.
     */
    private static void listerMaterielInformatiqueBatiment() {
        //Affichage des batiments et récupération du batiment sélectionné
        Batiment batimentSelectionne = null;
        try {
            batimentSelectionne = getChoixBatiment(facadeMetier.listerBatiment());
            AffichageConsole.afficherErreur(String.format("Bâtiment : %s%n", batimentSelectionne.getLibelle()));
            //Récupération de la liste des matériels informatique pour le batiment sélectionné
            List<MaterielInformatique> lst = facadeMetier.listerMaterielInformatiqueBatiment(batimentSelectionne);
            //si la liste est vide
            //Affichage d'un message
            if (lst.size()==0){
                AffichageConsole.afficherErreur(Constantes.MSG_LISTE_MATERIEL_BATIMENT_VIDE);
            }else {
                //sinon
                //parcours de la liste des matériels informatique pour demander l'affichage de chaque matériel
                for (MaterielInformatique mat : lst) {
                    afficherMaterielInformatique(mat);
                }
            }
        } catch (Exception e) {
            AffichageConsole.afficherErreur(e.getMessage());
        }

    }

    /**
     * Affecte un matériel informatique à une pièce.
     */
    private static void affecterMaterielInformatiquePiece() {
        try {
            //Sélection du matériel informatique
            MaterielInformatique materielInformatique = selectionnerMaterielInformatique(facadeMetier.listerMaterielInformatiqueNonAffecte());
            //sélection du batiment
            Batiment batimentSelectionne = getChoixBatiment(facadeMetier.listerBatiment());
            //sélection de la pièce
            Piece piece = selectionnerPiece(batimentSelectionne.getPieces());
            //Ajout du matériel informatique à la pièce
            piece.ajouterMaterielInformatique(materielInformatique);
            //Mise à jour des données du batiment (batiment -> pièce -> liste matériels Informatique)
            facadeMetier.affecterMaterielInformatiquePiece(batimentSelectionne);
        } catch (Exception e) {
            AffichageConsole.afficherErreur(e.getMessage());
        }

    }

    /**
     * Affiche la liste des pièces passées en paramètre et renvoie la pièce sélectionnée.
     * @param lstPiece liste des pièces.
     * @return la pièce sélectionnée.
     */
    private static Piece selectionnerPiece(final List<Piece> lstPiece) throws Exception {
        if (lstPiece.size() == 0){
            throw new Exception(Constantes.MSG_LISTE_PIECE_VIDE);
        }else {
            List<String> lstPieceLibelle = new ArrayList<>();
            AffichageConsole.afficherErreur(Constantes.MSG_SELECTION_PIECE);
            for (Piece piece : lstPiece){
                lstPieceLibelle.add(piece.getNumero());
            }
            int choixPiece = getChoixUtilisateur(lstPieceLibelle,1);
            return lstPiece.get(choixPiece-1);
        }

    }

    /**
     * Affiche la liste des bâtiments passés en paramètre et renvoie le bâtiment sélectionné.
     * @param lstBatiment liste des bâtiments
     * @return le bâtiment sélectionné.
     */
    private static Batiment getChoixBatiment(final List<Batiment> lstBatiment) throws Exception {
        if(lstBatiment.size() == 0){
            throw new Exception(Constantes.MSG_LISTE_BATIMENT_VIDE);
        }else {
            List<String> lstBatimentLibelle = new ArrayList<>();
            AffichageConsole.afficherErreur(Constantes.MSG_SELECTION_BATIMENT);
            for (Batiment batiment : lstBatiment) {
                lstBatimentLibelle.add(batiment.getLibelle());
            }
            int choixBatiment = getChoixUtilisateur(lstBatimentLibelle, 1);
            return lstBatiment.get(choixBatiment - 1);
        }
    }

    /**
     * Affiche et demande la sélection d'un matériel informatique.
     * @param lstMaterielInformatique la liste des matériels informatique.
     * @return le matériel informatique sélectionné.
     * @throws Exception si la liste des matériels informatique est vide.
     */
    private static MaterielInformatique selectionnerMaterielInformatique(final List<MaterielInformatique> lstMaterielInformatique) throws Exception {
        if(lstMaterielInformatique.size() == 0) {
            throw new Exception(Constantes.MSG_LISTE_MATERIEL_NON_AFFECTE_VIDE);
        }else {

            int choixTypeMaterielInfo = getChoixUtilisateur(Arrays.asList(Constantes.TYPE_MATERIEL_INFORMATIQUE), 1);



            List<String> materielInformatiqueList = new ArrayList<>();
            for (MaterielInformatique mat : lstMaterielInformatique) {
                if (choixTypeMaterielInfo == 1 && mat instanceof Ordinateur) {
                    Ordinateur ordi = (Ordinateur) mat;
                    materielInformatiqueList.add(String.format("%-20s : %-15s - %s", ordi.getNumSerie(), ordi.getTypeReseau(), ordi.getTypeOrdinateur().getLibelle()));
                }
                if (choixTypeMaterielInfo == 2 && mat instanceof Ecran) {
                    Ecran ecran = (Ecran) mat;
                    materielInformatiqueList.add(String.format("%-20s : %-20s", ecran.getNumSerie(), ecran.getTailleEcran().getLibelle()));
                }
            }
            if (materielInformatiqueList.size() == 0){
                throw new Exception(Constantes.MSG_LISTE_MATERIEL_NON_AFFECTE_VIDE);
            }else {
                int choixMat = getChoixUtilisateur(materielInformatiqueList, 1);
                return lstMaterielInformatique.get(choixMat - 1);
            }
        }
    }

    /**
     * Récupère et demande l'affichage des matériels informatique.
     */
    private static void listerMaterielInformatique() {
        for (MaterielInformatique mat : facadeMetier.listerMaterielInformatique()){
            afficherMaterielInformatique(mat);
        }

    }

    /**
     * Affiche le matériel informatique en fonction de son type (Ordinateur ou Ecran).
     * @param mat le matériel informatique a afficher.
     */
    private static void afficherMaterielInformatique(final MaterielInformatique mat) {
        if(mat instanceof Ordinateur){
            Ordinateur ordi = (Ordinateur) mat;
            afficherOrdinateur(ordi);
        }
        if (mat instanceof Ecran){
            Ecran ecran = (Ecran) mat;
            afficherEcran(ecran);
        }
    }

    /**
     * Affiche l'écran passé en paramètre selon un formatage particulier.
     * @param mat le matériel informatique a afficher.
     */
    private static void afficherEcran(final Ecran mat) {
        StringBuilder sb = getInfoMateriel(mat.getNumSerie(), mat.getDateGarantie(), mat.getClass().getSimpleName());
        sb.append(String.format("\ttype de matériel : %s",mat.getTailleEcran().getLibelle()));
        AffichageConsole.afficherErreur(sb.toString());
    }

    /**
     * Formate les données passées en paramètre.
     * @param numSerie numéro de série du matériel informatique.
     * @param dateGarantie date de garantie du matériel informatique.
     * @param simpleName type du matériel informatique.
     * @return une chaine de caractère ({@link StringBuilder} formatée (ex : Ordinateur : numSerie dateGarantie).
     */
    private static StringBuilder getInfoMateriel(final String numSerie, final LocalDate dateGarantie, final String simpleName) {
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName).append(" : ").append(String.format("%s %s", numSerie, dateGarantie)).append(System.lineSeparator());
        return sb;
    }

    /**
     * Affiche l'ordinateur passé en paramètre selon un formatage particulier.
     * @param mat le matériel informatique a afficher.
     */
    private static void afficherOrdinateur(final Ordinateur mat) {
        StringBuilder sb = getInfoMateriel(mat.getNumSerie(), mat.getDateGarantie(), mat.getClass().getSimpleName());
        sb.append(String.format("\ttype de matériel : %s",mat.getTypeOrdinateur().getLibelle()));
        sb.append(System.lineSeparator());
        sb.append(String.format("\ttype de réseau : %s",mat.getTypeReseau()));
        sb.append(System.lineSeparator());
        AffichageConsole.afficherErreur(sb.toString());
    }

    /**
     * Supprime un matériel informatique sélectionné.
     */
    private static void supprimerMaterielInformatique() {
        try {
            facadeMetier.supprimerMaterielInformatique(selectionnerMaterielInformatique(facadeMetier.listerMaterielInformatique()));
            AffichageConsole.afficherErreur(Constantes.MSG_SUPPRESSION_MATERIEL_INFORMATIQUE_SUCCES);
        } catch (Exception e) {
            AffichageConsole.afficherErreur(e.getMessage());
        }
    }

    /**
     * Crée un matériel informatique en fonction de la saisie de l'utilisateur.
     */
    private static void creerMaterielInformatique() {
        int choixTypeMaterielInfo = getChoixUtilisateur(Arrays.asList(Constantes.TYPE_MATERIEL_INFORMATIQUE), 1);
        try {
            switch (choixTypeMaterielInfo){
                case 1 :
                    facadeMetier.creerMaterielInformatique(saisirOrdinateur());
                    break;
                case 2 :
                    facadeMetier.creerMaterielInformatique(saisirEcran());
                    break;
            }
            AffichageConsole.afficherErreur(Constantes.MSG_CREATION_MATERIEL_REUSSITE);
        } catch (BusinessException  e) {
//            //todo e.printStackTrace()
//            e.printStackTrace();
            AffichageConsole.afficherErreur(e.getMessage());
        } catch (SaisieMaterielInformatiqueException e) {
            AffichageConsole.afficherErreur(e.getCause().getMessage());
        }

    }

    /**
     * Affiche la liste passée en paramêtre et renvoie le choix de l'utilisateur.
     * @param strings liste a afficher
     * @param indiceDepart indice de départ de la numérotation des éléments de la liste
     * @return le choix saisi par l'utilisateur
     */
    private static int getChoixUtilisateur(final List<String> strings, final int indiceDepart) {
        AffichageConsole.afficherMenuSimple(strings);
        return LectureConsole.lectureChoixInt(indiceDepart, strings.size());
    }

    /**
     * Crée un écran en fonction de la saisie de l'utilisateur.
     * @return le matériel informatique créé.
     * @throws SaisieMaterielInformatiqueException si une erreure est survenue dans la saisie des informations nécessaire à la création de l'écran.
     */
    private static MaterielInformatique saisirEcran() throws SaisieMaterielInformatiqueException {

        try {
            TailleEcran tailleEcran = recupererTailleEcran();
            String numSerie = saisirNumSerie();
            LocalDate dateGarantie = saisirDateGrantie();
            return EntitiesFactory.fabriquerEcran(numSerie, dateGarantie, tailleEcran);
        } catch (MaterielInformatiqueConstructionException e) {
            throw new SaisieMaterielInformatiqueException(Constantes.MSG_ERREUR_SAISIE_MATERIEL,e);
        }
    }

    /**
     * Demande la saisie de la date de garantie à l'utilisateur.
     * @return la date saisie.
     */
    private static LocalDate saisirDateGrantie() {
        return LectureConsole.lectureLocalDate(Constantes.SAISIR_DATE_GARANTIE, Constantes.PATTERN_DATE);
    }

    /**
     * Demande la saisie du numéro de série à l'utilisateur.
     * @return le numéro de série saisi.
     */
    private static String saisirNumSerie() {
        return LectureConsole.lectureChaineCaracteres(Constantes.SAISIR_NUM_SERIE);
    }

    /**
     * Affiche les tailles d'écran et demande la sélection d'une taille d'écran {@link TailleEcran}.
     * @return la taille d'écran {@link TailleEcran} sélectionnée.
     */
    private static TailleEcran recupererTailleEcran() {
        List<String> lstTailleEcran = new ArrayList<>();
        for (TailleEcran tailleEcran : TailleEcran.values()){
            lstTailleEcran.add(tailleEcran.getLibelle());
        }
//        AffichageConsole.afficherMenuSimple(lstTailleEcran);
//        int choix = LectureConsole.lectureChoixInt(1, lstTailleEcran.size());
        int choix = getChoixUtilisateur(lstTailleEcran, 1);
        return TailleEcran.getTTailleEcranByLibelle(lstTailleEcran.get(choix-1));
    }

    /**
     * Crée un ordinateur en fonction de la saisie de l'utilisateur.
     * @return le matériel informatique créé.
     * @throws SaisieMaterielInformatiqueException si une erreur est survenue dans la saisie des informations nécessaire à la création de l'ordinateur.
     */
    private static MaterielInformatique saisirOrdinateur() throws SaisieMaterielInformatiqueException {
        try {
            TypeOrdinateur typeOrdinateur = recupererTypeOrdinateur();
            TypeReseau typeReseau = recupererTypeReseau();
            String numSerie = saisirNumSerie();
            LocalDate dateGarantie = saisirDateGrantie();
            return EntitiesFactory.fabriquerOrdinateur(numSerie, dateGarantie, typeOrdinateur, typeReseau);
        } catch (MaterielInformatiqueConstructionException e) {
//            //todo e.printStackTrace()
//            e.printStackTrace();
            throw new SaisieMaterielInformatiqueException(Constantes.MSG_ERREUR_SAISIE_MATERIEL,e);
        }
    }

    /**
     * Affiche et demande la sélection du type d'ordinateur {@link TypeOrdinateur}.
     * @return le type d'ordinateur sélectionné.
     */
    private static TypeOrdinateur recupererTypeOrdinateur() {
        List<String> lstTypeOrdi = new ArrayList<>();
        for (TypeOrdinateur typeOrdinateur : TypeOrdinateur.values()){
            lstTypeOrdi.add(typeOrdinateur.getLibelle());
        }
//        AffichageConsole.afficherMenuSimple(lstTypeOrdi);
//        int choix = LectureConsole.lectureChoixInt(1, lstTypeOrdi.size());
        int choix = getChoixUtilisateur(lstTypeOrdi, 1);
        return TypeOrdinateur.getTypeOrdinateurByLibelle(lstTypeOrdi.get(choix-1));
    }

    /**
     * Affiche et demande la sélection du type de réseau {@link TypeReseau}.
     * @return le type de réseau sélectionné.
     */
    private static TypeReseau recupererTypeReseau() {
        List<String> lstTypeReseau = new ArrayList<>();
        for (TypeReseau typeReseau : TypeReseau.values()){
            lstTypeReseau.add(typeReseau.name());
        }
//        AffichageConsole.afficherMenuSimple(lstTypeReseau);
//        int choix = LectureConsole.lectureChoixInt(1, lstTypeReseau.size());
        int choix = getChoixUtilisateur(lstTypeReseau, 1);
        return TypeReseau.valueOf(lstTypeReseau.get(choix-1));
    }
}
