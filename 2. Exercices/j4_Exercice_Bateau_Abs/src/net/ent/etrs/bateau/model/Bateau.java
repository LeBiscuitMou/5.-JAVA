package net.ent.etrs.bateau.model;

public abstract class Bateau {
    private String nom;
    private MoyenPropulsion moyenPropulsion;
    private Armement[] armements;

    public Bateau(String nom, MoyenPropulsion moyenPropulsion, Armement[] armements) {
        this.nom = nom;
        this.moyenPropulsion = moyenPropulsion;
        this.armements = armements;
    }
}