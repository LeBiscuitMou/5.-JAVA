package net.ent.etrs.gestionblinde.start;

import net.ent.etrs.gestionblinde.presenter.Presenteur;

public class Lanceur {
    public static void main(String[] args) {
        Presenteur p = new Presenteur();
        p.start();
    }
}
