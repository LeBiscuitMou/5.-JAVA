package net.ent.etrs.GestionnairePotion.vues.commons.utils;

import net.ent.etrs.GestionnairePotion.vues.references.ConstVue;

import java.util.Objects;

public final class AffichageConsole2 {
    public static void afficherGrille(String[][] grille){
        if(Objects.isNull(grille)){
            return;
        }
        StringBuilder affichage = new StringBuilder();
        for (String[] line: grille) {
            afficherInterlineGrille(line);
            affichage.append('|');
            for (String text : line) {
                affichage.append(String.format(" %s |", text));
            }
            System.out.println(affichage);
            affichage.delete(0, affichage.length());
        }
        afficherInterlineGrille(grille[0]);
    }

    public static void afficherInterlineGrille(String[] line){
        StringBuilder affichage = new StringBuilder();
        affichage.append('|');
        for (String text : line) {
            affichage.append("-".repeat(text.length()+2));
            affichage.append("|");
        }
        System.out.println(affichage);
    }

    public static void afficherGrille(char[][] grille) {
        if(Objects.isNull(grille)){
            return;
        }
        StringBuilder affichage = new StringBuilder();
        for (char[] line: grille) {
            afficherInterlineGrille(line);
            affichage.append('|');
            for (char text : line) {
                affichage.append(String.format(" %c |", text));
            }
            System.out.println(affichage);
            affichage.delete(0, affichage.length());
        }
        afficherInterlineGrille(grille[0]);
    }

    public static void afficherInterlineGrille(char[] line){
        StringBuilder affichage = new StringBuilder();
        affichage.append('|');
        for (char text : line) {
            affichage.append("---|");
        }
        System.out.println(affichage);
    }


}
