package net.ent.etrs.kingdomino.entities;

import net.ent.etrs.kingdomino.entities.references.TypeTuile;
import net.ent.etrs.kingdomino.references.ConstanteMetier;

import java.util.Arrays;

public class Terrain {
    private Tuile[][] grille;

    protected Terrain() {
        initialiserContenu();
    }

    public Tuile[][] getGrille() {
        return Arrays.copyOf(this.grille, ConstanteMetier.TAILLE_GRILLE);
    }

    private void initialiserContenu() {
        grille = new Tuile[ConstanteMetier.TAILLE_GRILLE][ConstanteMetier.TAILLE_GRILLE];

        int positionChateau = ConstanteMetier.TAILLE_GRILLE / 2;

        grille[positionChateau][positionChateau] = ;

        // Initialiser grille de Tuile
        for (int i = 0; i < ConstanteMetier.TAILLE_GRILLE; i++) {
            for (int j = 0; j < ConstanteMetier.TAILLE_GRILLE; j++) {

            }
        }
    }

}
