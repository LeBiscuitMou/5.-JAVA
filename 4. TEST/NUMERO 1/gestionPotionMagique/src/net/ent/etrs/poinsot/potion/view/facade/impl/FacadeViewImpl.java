package net.ent.etrs.poinsot.potion.view.facade.impl;

import net.ent.etrs.poinsot.potion.model.entities.Contenant;
import net.ent.etrs.poinsot.potion.model.entities.EntitiesFactory;
import net.ent.etrs.poinsot.potion.model.entities.Ingredient;
import net.ent.etrs.poinsot.potion.model.entities.Potion;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.IngredientException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;
import net.ent.etrs.poinsot.potion.model.references.Nature;
import net.ent.etrs.poinsot.potion.view.commons.utils.AffichageConsole;
import net.ent.etrs.poinsot.potion.view.commons.utils.LectureConsole;
import net.ent.etrs.poinsot.potion.view.facade.FacadeView;
import net.ent.etrs.poinsot.potion.view.facade.exceptions.FacadeViewException;
import net.ent.etrs.poinsot.potion.view.references.ConstanteView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacadeViewImpl implements FacadeView {
    @Override
    public void afficherLesIngredients(List<Ingredient> lesIngredients) {
        for (Ingredient i : lesIngredients) {
            AffichageConsole.afficherMessageAvecSautLigne(i.toString());
        }
    }

    @Override
    public Ingredient creerUnIngredient() throws FacadeViewException {
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de l'ingrédient");
        boolean estMagique = LectureConsole.lectureBoolean("Est ce que cet ingrédient est magique ?");
        int poids = LectureConsole.lectureEntier("Saisir le poids");
        Nature nature = selectionnerNatureIngredient();
        try {
            return EntitiesFactory.fabriquerIngredient(nom, estMagique, poids, nature);
        } catch (IngredientException e) {
            throw new FacadeViewException(ConstanteView.FACADE_IMPOSSIBLE_CREER_INGREDIENT);
        }
    }

    @Override
    public Ingredient selectionnerIngredient(List<Ingredient> lesIngredients) throws FacadeViewException {
        if (lesIngredients.isEmpty()) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUN_INGREDIENTS);
        }
        List<String> lesIngredientsString = new ArrayList<>();
        for (Ingredient i : lesIngredients) {
            lesIngredientsString.add(i.toString());
        }
        AffichageConsole.afficherMenuSimple(lesIngredientsString);
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner un ingrédient: ");
        int choix = LectureConsole.lectureChoixInt(0, lesIngredientsString.size());

        return lesIngredients.get(choix - 1);
    }

    @Override
    public void afficherMenuPrincipal(List<String> menu) {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menu, "Gestion de potions magique");
    }

    @Override
    public Potion creerUnePotion() throws FacadeViewException {
        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom de la potion");
        int volume = LectureConsole.lectureEntier("Saisir le volume de la potion");
        Contenant contenant = null;
        try {
            return EntitiesFactory.fabriquerPotion(nom, volume, contenant);
        } catch (PotionException e) {
            throw new FacadeViewException(ConstanteView.FACADE_IMPOSSIBLE_CREER_POTION);
        }
    }

    @Override
    public void afficherToutesLesPotions(List<Potion> lesPotions) {
        for (Potion p : lesPotions) {
            AffichageConsole.afficherMessageAvecSautLigne(p.toString());
        }
    }

    @Override
    public void afficherMessageErreur(String message) {
        AffichageConsole.afficherErreur(message);
    }

    @Override
    public Potion ajouterUnIngredient(Potion potion, Ingredient ingredient) {
        return null;
    }

    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    @Override
    public Potion supprimerUnePotion(List<Potion> lesPotions) throws FacadeViewException {
        if (lesPotions.isEmpty()) {
            throw new FacadeViewException(ConstanteView.FACADE_AUCUNE_POTION);
        }
        List<String> lesPotionsString = new ArrayList<>();
        for (Potion p : lesPotions) {
            lesPotionsString.add(p.toString());
        }
        AffichageConsole.afficherMenuSimple(lesPotionsString);
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner une potion à supprimer");
        int choix = LectureConsole.lectureChoixInt(0, lesPotionsString.size());
        return lesPotions.get(choix - 1);
    }

    @Override
    public Nature selectionnerNatureIngredient() {
        List<String> lesNatures = new ArrayList<>();
        for (Nature n : Arrays.asList(Nature.values())) {
            lesNatures.add(n.toString().toUpperCase());
        }
        AffichageConsole.afficherMenuSimple(lesNatures);
        AffichageConsole.afficherMessageAvecSautLigne("Sélectionner une nature pour l'ingrédient : ");
        int choix = LectureConsole.lectureChoixInt(0, lesNatures.size());
        return Nature.values()[choix - 1];
    }
}