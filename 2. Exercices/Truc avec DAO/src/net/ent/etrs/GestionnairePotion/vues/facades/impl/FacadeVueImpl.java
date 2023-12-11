package net.ent.etrs.GestionnairePotion.vues.facades.impl;

import net.ent.etrs.GestionnairePotion.model.entities.EntitiesFactory;
import net.ent.etrs.GestionnairePotion.model.entities.Ingredient;
import net.ent.etrs.GestionnairePotion.model.entities.Potion;
import net.ent.etrs.GestionnairePotion.model.exceptions.EntitiesException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionAmeliorationException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionDeDegatException;
import net.ent.etrs.GestionnairePotion.model.exceptions.PotionDeVieException;
import net.ent.etrs.GestionnairePotion.model.references.ConstMetier;
import net.ent.etrs.GestionnairePotion.model.references.Contenant;
import net.ent.etrs.GestionnairePotion.model.references.Nature;
import net.ent.etrs.GestionnairePotion.vues.commons.utils.AffichageConsole;
import net.ent.etrs.GestionnairePotion.vues.commons.utils.AffichageConsole2;
import net.ent.etrs.GestionnairePotion.vues.commons.utils.LectureConsole;
import net.ent.etrs.GestionnairePotion.vues.facades.FacadeVue;
import net.ent.etrs.GestionnairePotion.vues.references.ConstVue;
import net.ent.etrs.GestionnairePotion.vues.references.ListeOptions;
import net.ent.etrs.GestionnairePotion.vues.references.TypePotions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FacadeVueImpl implements FacadeVue {
    protected FacadeVueImpl() {

    }

    @Override
    public void afficherLesIngredients(List<Ingredient> ingredientList) {
        if(Objects.isNull(ingredientList)){
            afficherMessageErreur(ConstVue.INGREDIENT_LIST_NULL);
            return;
        }
        if(ingredientList.isEmpty()){
            afficherMessage(ConstVue.INGREDIENT_LIST_VIDE);
            return;
        }
        afficherMessage("| num |     nom de l'ingrédient        | poids |  magique? |    nature    |");
        String[][] donneeIngredient = new String[ingredientList.size()][ConstVue.INGREDIENT_ATTRIBUTS+1];
        for (int i = 0; i < ingredientList.size(); i++) {
            donneeIngredient[i][0] = String.format("%-3d", i+1);
            donneeIngredient[i][1] = String.format("%-30s", ingredientList.get(i).getNom());
            donneeIngredient[i][2] = String.format("%-10d", ingredientList.get(i).getPoids());
            if(ingredientList.get(i).isEstMagique()){
                donneeIngredient[i][3] = "magique ";
            }else {
                donneeIngredient[i][3] = "normal  ";
            }
            donneeIngredient[i][4] = String.format("%-12s", ingredientList.get(i).getNature().getLibelle());
        }
        AffichageConsole2.afficherGrille(donneeIngredient);
    }

    @Override
    public Ingredient creerUnIngredient() {
        try {
            String nom = getNom("saisissez le nom de l'ingrédient :");
            Nature nature = selectionnerNatureIngredient();
            int poids = LectureConsole.lectureEntier("quel est son poids ? :");
            boolean estMagique = LectureConsole.lectureBoolean("est-il magique ? :");
            return EntitiesFactory.fabriquerIngredient(nom, estMagique, poids, nature);
        } catch (EntitiesException e) {
            afficherMessageErreur(e.getMessage());
            return null;
        }
    }

    @Override
    public Ingredient selectionnerIngredient(List<Ingredient> ingredientList) {
        afficherLesIngredients(ingredientList);
        int indexI = LectureConsole.lectureChoixInt(1, ingredientList.size()) -1;
        afficherMessage(String.format("vous avez sélectionner l'ingrédient : %s", ingredientList.get(indexI).getNom()));
        return ingredientList.get(indexI);
    }

    @Override
    public int afficherMenuPrincipal() {
        Map<Integer, String> options = new HashMap<>();
        for (int i = 0; i < ListeOptions.values().length; i++) {
            options.put(ListeOptions.values()[i].getIndex(), ListeOptions.values()[i].getOption());
        }
        AffichageConsole.afficherMenuEntoure(options, ConstVue.NOM_PROGRAMME);
        return LectureConsole.lectureChoixInt(ListeOptions.values()[0].getIndex(),
                                              ListeOptions.values()[ListeOptions.values().length-1].getIndex());
    }

    @Override
    public Potion creerUnePotion() {
        try {
            String nom = getNom("saisissez le nom de la potion :");
            Contenant contenant = selectionnerContenantPotion();
            int volume = LectureConsole.lectureEntier("quel est son volume ? :");
            TypePotions choixPotion = choixPotionType();
            switch (choixPotion){
                case VIE :
                    return EntitiesFactory.fabriquerPotionDeVie(nom, volume, contenant);
                case DEGAT :
                    return EntitiesFactory.fabriquerPotionDeDegat(nom, volume, contenant);
                case AMELIORATION :
                    return EntitiesFactory.fabriquerPotionAmelioration(nom, volume, contenant);
                default :
                    return null;
            }
        } catch (EntitiesException e) {
            afficherMessageErreur(e.getMessage());
            return null;
        }
    }

    @Override
    public void afficherToutesLesPotions(List<Potion> potionList) {
        if(Objects.isNull(potionList)){
            afficherMessageErreur(ConstVue.POTION_LIST_NULL);
            return;
        }
        if(potionList.isEmpty()){
            afficherMessage(ConstVue.POTION_LIST_VIDE);
            return;
        }
        String[][] donneePotion = new String[potionList.size()][ConstVue.POTION_ATTRIBUTS+1];
        afficherMessage("| num |     nom de la potion           | volume |  contenant   | effet");
        for (int i = 0; i < potionList.size(); i++) {
            donneePotion[i][0] = String.format("%-3d", i+1);
            donneePotion[i][1] = String.format("%-30s", potionList.get(i).getNom());
            donneePotion[i][2] = String.format("%-6d", potionList.get(i).getVolume());
            donneePotion[i][3] = String.format("%-12s", potionList.get(i).getContenant().getLibelle());
            try {
                donneePotion[i][4] = String.format("%-150s", potionList.get(i).getEffet());
            } catch (PotionDeDegatException e) {
                afficherMessageErreur(e.getMessage());
                return;
            }
        }
        AffichageConsole2.afficherGrille(donneePotion);
    }

    @Override
    public void afficherMessageErreur(String msg) {
        AffichageConsole.afficherErreur(msg);
    }

    @Override
    public Potion ajouterUnIngredient(Potion pot, Ingredient ingred) {
        if(LectureConsole.lectureBoolean("Voulez-vous vraiment ajouter cette ingrédient à cette potion ?")){
            try {
                pot.ajouterIngredient(ingred);
            } catch (PotionDeDegatException | PotionDeVieException | PotionAmeliorationException e) {
                afficherMessageErreur(e.getMessage());
            }
        }
        return pot;
    }

    @Override
    public void afficherMessage(String msg) {
        AffichageConsole.afficherMessageAvecSautLigne(msg);
    }

    @Override
    public Potion supprimerUnePotion(List<Potion> potionList) {
        afficherToutesLesPotions(potionList);
        int indexP = LectureConsole.lectureChoixInt(1, potionList.size()) -1;
        return potionList.get(indexP);
    }

    @Override
    public Nature selectionnerNatureIngredient() {
        Map<Integer, String> options = new HashMap<>();
        for (int i = 1; i < Nature.values().length+1; i++) {
            options.put(i, Nature.values()[i-1].getLibelle());
        }
        AffichageConsole.afficherMenuEntoure(options, ConstVue.NOM_PROGRAMME);
        int indexNature = LectureConsole.lectureChoixInt(1, Nature.values().length) -1;
        return Nature.values()[indexNature];
    }

    private String getNom(String entete){
        String nom;
        do{
            nom = LectureConsole.lectureChaineCaracteres(entete);
            if(nom.length() > ConstMetier.NOM_MAX_SIZE){
                afficherMessage(ConstVue.NOM_TROP_GRAND);
            }
        }while (nom.length() > ConstMetier.NOM_MAX_SIZE);
        return nom;
    }

    private TypePotions choixPotionType() {
        Map<Integer, String> options = new HashMap<>();
        for (int i = 0; i < TypePotions.values().length; i++) {
            options.put(i+1, TypePotions.values()[i].getOption());
        }
        AffichageConsole.afficherMenuEntoure(options, "choisissez le type de la potion");
        int choix = LectureConsole.lectureChoixInt(1, TypePotions.values().length) -1;
        return TypePotions.values()[choix];
    }

    private Contenant selectionnerContenantPotion() {
        Map<Integer, String> options = new HashMap<>();
        for (int i = 0; i < Contenant.values().length; i++) {
            options.put(i+1, Contenant.values()[i].getLibelle());
        }
        AffichageConsole.afficherMenuEntoure(options, "choisissez le contenant");
        int choix = LectureConsole.lectureChoixInt(1, Contenant.values().length) -1;
        return Contenant.values()[choix];
    }
}
