package net.ent.etrs.simugladiateur.starter;

import net.ent.etrs.simugladiateur.modeles.entities.Crepullaire;
import net.ent.etrs.simugladiateur.modeles.entities.Gladiateur;
import net.ent.etrs.simugladiateur.modeles.entities.Mirmillon;
import net.ent.etrs.simugladiateur.modeles.entities.Thrace;
import net.ent.etrs.simugladiateur.modeles.entities.references.ConstanteMetier;

import java.util.Objects;
import java.util.Random;

public class Lanceur {
    private static Gladiateur[] lesGladiateurs;

    public static void main(String[] args) {
        //Initialisation des Gladiateur
        lesGladiateurs = init();

        //J'affiche les Gladiateurs initiaux
        affichageGladiateurs(lesGladiateurs);

        do {
            //Je selectionne un Gladiateur
            Gladiateur g1 = selectionnerGladiateur(lesGladiateurs);
            Gladiateur g2;
            do {
                //Puis son adversaire
                g2 = selectionnerGladiateur(lesGladiateurs);
            } while (g2.equals(g1));

            //Affichage Combat
            affichageCombat(g1, g2);

            //Je lance le combat
            gestionCombat(g1, g2);

        } while (!verificationVictoire(lesGladiateurs));

        //Je réaffiche les gladiateurs restants
        System.out.println("\n Résultat du Tournoi");
        affichageGladiateurs(lesGladiateurs);
    }

    /**
     * Methode pour afficher un combat
     *
     * @param g1 1er gladiateur
     * @param g2 2e gladiateur
     */
    private static void affichageCombat(Gladiateur g1, Gladiateur g2) {
        System.out.println("/".repeat(50) + "\n"
                + "Le combat : \n"
                + g1.getNom() + " Le " + g1.getClass().getSimpleName() + " avec " + g1.getExperience() + " d'expérience \n"
                + " à \n"
                + g2.getNom() + " Le " + g2.getClass().getSimpleName() + " avec " + g2.getExperience() + " d'expérience \n"
                + "/".repeat(50)
        );
    }

    /**
     * Permet de selectionner un gladiateur de façon aléatoire
     *
     * @param lesGladiateurs la liste des Gladiateurs
     * @return le gladiateur selectionné
     */
    private static Gladiateur selectionnerGladiateur(Gladiateur[] lesGladiateurs) {
        Random r = new Random();
        return lesGladiateurs[r.nextInt(0, lesGladiateurs.length)];
    }


    /**
     * Permet d'initialiser le tournoi
     *
     * @return la liste des Gladiateurs
     */
    private static Gladiateur[] init() {
        Gladiateur[] gladiateurs = new Gladiateur[12];
        gladiateurs[0] = new Thrace("Spartacus", 3);
        gladiateurs[1] = new Mirmillon("Crixus", 3);
        gladiateurs[2] = new Crepullaire("Oenomaus", 3);
        gladiateurs[3] = new Thrace("Fulgur", 1);
        gladiateurs[4] = new Mirmillon("Polydromos", 1);
        gladiateurs[5] = new Crepullaire("Fulgur", 1);
        gladiateurs[6] = new Thrace("Faustus", 1);
        gladiateurs[7] = new Crepullaire("Heraclès", 2);
        gladiateurs[8] = new Mirmillon("Victor", 1);
        gladiateurs[9] = new Thrace("Gannicus", 3);
        gladiateurs[10] = new Mirmillon("Verus", 2);
        gladiateurs[11] = new Crepullaire("Priscus", 2);

        return gladiateurs;
    }

    /**
     * Permet d'afficher tous les gladiateurs d'un tableau
     *
     * @param gladiateurs les gladiateurs
     */
    private static void affichageGladiateurs(Gladiateur[] gladiateurs) {
        for (Gladiateur g : gladiateurs) {
            System.out.println(g.getNom() + " Expérience : " + g.getExperience() + " Nombre Victoire = " + g.getNbVictoires());
        }
    }

    /**
     * Methode qui gère le combat entre 2 gladiateurs
     *
     * @param g1 1er Gladiateur
     * @param g2 2e Gladiateur
     */
    private static void gestionCombat(Gladiateur g1, Gladiateur g2) {
        Random r = new Random();

        int probabilite = calculeProbaibiliteExp(g1, g2) + calculeProbaibiliteRaces(g1, g2) + ConstanteMetier.EGALITE_COMBAT;

        //Pour gérer le cas d'un gros delta d'exp;
        int resultatCombat = r.nextInt(0, 100);

        if (resultatCombat < probabilite) {
            miseAjourGladiateurs(g1, g2);
        } else {
            miseAjourGladiateurs(g2, g1);
        }


    }

    /**
     * Permet de mettre à jour l'Expérience du vainqueur et la survie du perdant
     *
     * @param gladGagnant le gladiateur qui a gagné le combat
     * @param gladPerdant le gladiateur qui a perdu le combat
     */
    private static void miseAjourGladiateurs(Gladiateur gladGagnant, Gladiateur gladPerdant) {

        //Ajout des points d'experience
        gladGagnant.gagneExperience(gladPerdant);
        gladGagnant.gagneUneVictoire();

        //affichage du Gagnant
        System.out.println("Le gagnant : " + gladGagnant.getNom() + " possède maintenant " + gladGagnant.getExperience() + " d'expérience et " + gladGagnant.getNbVictoires() + " victoires");

        //Survie du perdant
        Random r = new Random();
        int survie = r.nextInt(0, 100);
        if (survie < ConstanteMetier.POURCENTAGE_SURVIE) {
            //Le gladiateur mort est retiré du tableau
            retirerGladiateur(gladPerdant);
            System.out.println("Le perdant : " + gladPerdant.getNom() + " est mort");
        } else {
            System.out.println("Le perdant : " + gladPerdant.getNom() + " a survécu");
            gladPerdant.gagneExperience(gladGagnant);
        }

    }

    /**
     * Permet de retirer le gladiateur mort et redimensionne le tableau
     *
     * @param gladPerdant le gladiateur mort
     */
    private static void retirerGladiateur(Gladiateur gladPerdant) {
        for (int i = 0; i < lesGladiateurs.length; i++) {
            if (lesGladiateurs[i].equals(gladPerdant)) {
                lesGladiateurs[i] = null;
            }
        }
        lesGladiateurs = redimensionnerLeTableauGladiateur();
    }

    /**
     * Permet de redimensionner le tableau
     *
     * @return le tableau redimensionné
     */
    private static Gladiateur[] redimensionnerLeTableauGladiateur() {
        Gladiateur[] retour = new Gladiateur[lesGladiateurs.length - 1];
        int cpt = 0;

        for (Gladiateur g : lesGladiateurs) {
            if (Objects.nonNull(g)) {
                retour[cpt] = g;
                cpt++;
            }
        }

        return retour;
    }


    /**
     * Permet de calculer le bonus lié à la Race
     *
     * @param g1 1er Gladiateur
     * @param g2 2e Gladiateur
     * @return le bonus
     */
    private static int calculeProbaibiliteRaces(Gladiateur g1, Gladiateur g2) {
        return g1.chanceVaincre(g2);
    }

    /**
     * Permet de calculer le bonus lié à l'expérience
     *
     * @param g1 1er Gladiateur
     * @param g2 2e Gladiateur
     * @return le bonus
     */
    private static int calculeProbaibiliteExp(Gladiateur g1, Gladiateur g2) {
        return (g1.getExperience() - g2.getExperience()) * ConstanteMetier.POURCENTAGE_EXP;
    }

    /**
     * Permet de vérifier les conditions de victoire
     *
     * @param lesGladiateurs les gladiateurs
     * @return si une des condition de victoire est remplie ou non
     */
    private static boolean verificationVictoire(Gladiateur[] lesGladiateurs) {
        if (lesGladiateurs.length == 1) {
            return true;
        }
        for (Gladiateur g : lesGladiateurs) {
            if (g.getNbVictoires() == ConstanteMetier.NB_VICTOIRE_NECESSAIRE) {
                return true;
            }
        }
        return false;
    }

}
