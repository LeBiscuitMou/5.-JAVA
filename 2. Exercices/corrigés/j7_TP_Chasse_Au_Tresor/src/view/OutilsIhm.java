package view;

import model.entities.Carte;
import model.entities.Coordonnee;
import model.entities.Equipage;
import model.entities.Score;
import model.references.C;

public final class OutilsIhm {
    private OutilsIhm(){}



    public static void afficherCarte(Ihm v,Carte uneCarte) {
        StringBuilder sb = new StringBuilder("La carte:");
        sb.append(System.lineSeparator());
        sb.append("  /.A...B...C...D...E...F...G...H...I...J..").append(System.lineSeparator());


        for (int y = 0; y < C.DIM ; y++) {
            sb.append(String.format("%02d|",y));
            for (int x = 0; x < C.DIM; x++) {
                char c = uneCarte.getGrille()[y][x];
                sb.append(String.format(" %c |",c));
            }
            sb.append(System.lineSeparator());
        }

        sb.append(" .\\......................................./").append(System.lineSeparator());

        v.afficher(sb.toString());
    }

    public static void afficherUnPassage(Ihm v, int ctrPassage, String identite, int ligneCourante) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("no passage : %d , [%12S] fin exploitation ligne :%d, ligne suivante sera : %d",
                                      ctrPassage,identite,ligneCourante,ligneCourante));

        v.afficher(sb.toString());
    }

    public static void afficherLesResultats(Ihm vue, int[] tab1,int[] tab2, int noJoueurGagnant) {
        StringBuilder sb = new StringBuilder("\nLes Résultats:");
        sb.append(System.lineSeparator());
        sb.append("\n/--------------+-----+--------+---------\\").append(System.lineSeparator());
        sb.append("| Identite     | pas | pt vie | GAGNANT |").append(System.lineSeparator());
        sb.append("+--------------+-----+--------+---------|");


        String[] tabIdentite = {C.IDENT_J1,C.IDENT_J2};

        for (int idxj = 0; idxj < C.NB_JOUEUR; idxj++) {
            String strGagnant=" ";
            if(idxj == noJoueurGagnant){
                strGagnant = "GAGNANT";
            }
            sb.append(String.format("%n| %12S | %2d  | %5d  | %7s |",
                    tabIdentite[idxj],
                    tab1[idxj],
                    tab2[idxj],
                    strGagnant
                    ));
        }

        sb.append("\n\\--------------+-----+--------+--------/").append(System.lineSeparator());

        vue.afficher(sb.toString());
    }

    public static void afficherCoordonneesTresor(Ihm vue, Coordonnee coordT) {
        StringBuilder sb = new StringBuilder("Le trésor a été trouvé en :");
        int lig = coordT.getY();
        char charCol =  (char) (coordT.getX()+C.CODE_ASCII_A);

        sb.append("[").append(charCol).append("]:").append(lig);
        sb.append(System.lineSeparator());
        vue.afficher(sb.toString());
    }
}
