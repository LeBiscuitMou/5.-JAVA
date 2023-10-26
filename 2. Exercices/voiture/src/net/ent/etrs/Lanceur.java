package net.ent.etrs;

import net.ent.etrs.model.entities.Garage;
import net.ent.etrs.model.entities.Voiture;

public class Lanceur {
    public static void main(String[] args) {
        Voiture bmw = new Voiture("BMW", 123);
        Garage schaeffer = new Garage(bmw);
        schaeffer.uneVoiture.afficherInfo();
    }
}