package model.entities;

import model.exceptions.CoordonneeException;
import model.references.C;
import model.references.TypeCase;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Carte {
    private char[][] grille;

    public char[][] getGrille() {
        return grille;
    }
    public Carte() throws Exception {
        initialiserContenu();
    }

    private void initialiserContenu() throws Exception {
        grille  = new char[C.DIM][C.DIM];
        //initialiserSable
        for (int y = 0; y < C.DIM; y++) {
            for (int x = 0; x <C.DIM ; x++) {
                grille[y][x]= TypeCase.SABLE.getSymbole();
            }

        }

        //initialiserPieges
        Random rand = new Random();
        int y1 = rand.nextInt(C.DIM);
        int x1= rand.nextInt(C.DIM);

        grille[y1][x1]= TypeCase.PIEGE.getSymbole();

        for (int nbp = 0; nbp < C.NB_PIEGE-1; nbp++) {


            int y2 = 0;
            int x2 = 0;
            do {
                y2 = rand.nextInt(C.DIM);
                x2 = rand.nextInt(C.DIM);

            } while (x1 == x2 && y1 == y2);
            grille[y2][x2] = TypeCase.PIEGE.getSymbole();
        }

        //initialiserTresor
        int yTresor=0;
        int xTresor=0;
        do{
            yTresor = rand.nextInt(C.DIM);
            xTresor = rand.nextInt(C.DIM);
        }while(grille[yTresor][xTresor]!= TypeCase.SABLE.getSymbole());

        //MAJ de la grille
        grille[yTresor][xTresor] = TypeCase.TRESOR.getSymbole();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return Arrays.equals(grille, carte.grille);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(grille);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nCarte:");
        for (int y = 0; y < C.DIM; y++) {
            sb.append(System.lineSeparator());
            for (int x = 0; x < C.DIM; x++) {
                sb.append(grille[y][x]);
            }
        }
        return sb.toString();
    }

    public boolean isPiegeAt(int y, int x) {
        if(y>=0 && y<=C.DIM && x>=0 && x<=C.DIM){
            if(grille[y][x]== TypeCase.PIEGE.getSymbole()){
                return true;
            }
        }
        return false;
    }

    public boolean isTresorAt(int y, int x) {
        if(y>=0 && y<=C.DIM && x>=0 && x<=C.DIM){
            if(grille[y][x]== TypeCase.TRESOR.getSymbole()){
                return true;
            }
        }
        return false;

    }

    public Coordonnee getCoordonneeTresor() throws CoordonneeException {
        Coordonnee c=null;

        for (int y = 0; y < C.DIM; y++) {
            for (int x = 0; x < C.DIM; x++) {
                if(isPiegeAt(y,x)){
                    c = FabriqueMetier.fabriquerCoordonnee(y,x);
                    x=C.DIM;
                    y=C.DIM;
                }
            }
        }
        return c;
    }
}
