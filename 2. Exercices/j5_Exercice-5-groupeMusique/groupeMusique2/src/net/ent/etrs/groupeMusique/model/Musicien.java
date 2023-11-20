package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.MusicienException;
import net.ent.etrs.groupeMusique.model.exception.PersonneException;
import net.ent.etrs.groupeMusique.model.references.Sexe;
import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Musicien extends Personne{
    private String nomArtiste;
    private Materiel[] materiels = new Materiel[0];


    protected Musicien(String nom, String prenom, Sexe sexe, String nomArtiste, LocalDate laDateNaissance) throws PersonneException {
        super(nom, prenom, sexe, laDateNaissance);
        this.setNomArtiste(nomArtiste);
    }

    protected String getNomArtiste() {
        return nomArtiste;
    }

    protected Materiel[] getMateriels() {
        return Arrays.copyOf(materiels, materiels.length);
    }



    private void setNomArtiste(String nomArtiste) throws PersonneException {
       //todo
    }

    protected void ajouterMateriel(Materiel materiel) throws MusicienException {
        //TODO agrandir le tableau ?
        if (Objects.isNull(materiel)){
            throw new MusicienException(ConstantesMetier.MATERIEL_ERROR_NULL);
        }
        for (int i = 0; i < materiels.length; i++) {
            if (this.materiels[i] == null){
                this.materiels[i] = materiel;
                return;
            }
        }
        System.out.println("plus de place pour ce materiel: " + materiel.toString());
    }

    protected void changerMateriel(Materiel materiel, int place) throws MusicienException {
        if (Objects.isNull(materiel)){
            throw new MusicienException(ConstantesMetier.MATERIEL_ERROR_NULL);
        }
        if (place < this.materiels.length && place >= 0){
            this.materiels[place] = materiel;
        }
        else {
            //TODO exception ?
            System.out.println("emplacement invalide");
        }
    }

    protected void enleverMateriel(int place) {
        if (place < this.materiels.length && place >= 0){
            this.materiels[place] = null;
            //TODO réduction du tableau?
        }
        else {
            //TODO exception ?
            System.out.println("emplacement invalide");
        }
    }

    protected String getAllMateriels() {
        StringBuilder listeMateriel = new StringBuilder();
        for (Materiel mat: materiels) {
            listeMateriel.append(mat.toString());
            listeMateriel.append("\n");
        }
        return listeMateriel.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musicien musicien = (Musicien) o;
        return Objects.equals(nomArtiste, musicien.nomArtiste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomArtiste);
    }

    @Override
    public String toString() {
        return "Musicien{" +
                "nomArtiste='" + nomArtiste + '\'' +
                '}';
    }
}
