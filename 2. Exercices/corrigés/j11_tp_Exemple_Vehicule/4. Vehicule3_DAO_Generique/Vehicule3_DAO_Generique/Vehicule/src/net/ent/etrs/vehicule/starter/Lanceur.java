package net.ent.etrs.vehicule.starter;


import net.ent.etrs.vehicule.presenter.Presenteur;

import java.util.UUID;


public class Lanceur {

    public static void main(String[] args) {

       Presenteur p = new Presenteur();
        p.init();
    }

}
