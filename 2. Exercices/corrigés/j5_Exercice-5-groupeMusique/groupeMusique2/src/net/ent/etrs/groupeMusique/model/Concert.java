package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.ConcertException;
import net.ent.etrs.groupeMusique.model.references.ConstantesMetier;
import net.ent.etrs.groupeMusique.model.references.TypeConcert;
import net.ent.etrs.groupeMusique.model.utils.VerificationUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Concert {
    private String nom;
    private TypeConcert typeConcert;
    private Lieu lieu;

    private LocalDateTime dateConcert;
    private Musicien[] musiciens;
    private Materiel[] materiels;

    Concert(String nom, TypeConcert leTypeConcert, Lieu leLieu, LocalDateTime laDateConcert) throws ConcertException {
        this.setNom(nom);
        this.setTypeConcert(leTypeConcert);
        this.setLieu(leLieu);
        this.musiciens = new Musicien[1];
        this.setDateConcert(laDateConcert);
    }


    private void setNom(String nom) throws ConcertException {
        //Si c'est null
        if(Objects.isNull(nom)){
            throw new ConcertException(ConstantesMetier.NOM_IS_NULL);
        }
        //Si c'est vide
        if(nom.isBlank()){
            throw new ConcertException(ConstantesMetier.NOM_IS_BLANK);
        }
        //Règles Métier
        //Limiter la taille du nom
        if (nom.length() > ConstantesMetier.NOM_LONGUEUR_MAX){
            throw new ConcertException(ConstantesMetier.NOM_ERROR_LONGUEUR);
        }
        //Pas de chiffre
        if(VerificationUtils.aUnChiffre(nom)){
            throw new ConcertException(ConstantesMetier.NOM_ERROR_CHIFFRE);
        }

        this.nom = nom;
    }

    private void setTypeConcert(TypeConcert typeConcert) {
        if(Objects.isNull(typeConcert)){
            //TODO
        }
        this.typeConcert = typeConcert;
    }

    private void setLieu(Lieu lieu) {
        if(Objects.isNull(lieu)){
            //TODO
        }
        this.lieu = lieu;
    }

    protected void ajouterMusicien(Musicien musicien) throws ConcertException {
        if (Objects.isNull(musicien)){
            throw new ConcertException(ConstantesMetier.MATERIEL_ERROR_NULL);
        }
        //TODO methode agrandissement tableau
        for (int i = 0; i < musiciens.length; i++) {
            if (this.musiciens[i] == null){
                this.musiciens[i] = musicien;
                return;
            }
        }
       //TODO EXception
    }



    protected void enleverMusicien(Musicien musicien) {
        //TODO a revoir
    }

    protected void ajouterMateriel(Materiel materiel) throws ConcertException {
        if (Objects.isNull(materiel)){
            throw new ConcertException(ConstantesMetier.MATERIEL_ERROR_NULL);
        }
        for (int i = 0; i < materiels.length; i++) {
            if (this.materiels[i] == null){
                this.materiels[i] = materiel;
                return;
            }
        }
        System.out.println("plus de place pour ce materiel: " + materiel.toString());
    }

    protected void changerMateriel(Materiel materiel, int place) throws ConcertException {
        if (Objects.isNull(materiel)){
            throw new ConcertException(ConstantesMetier.MATERIEL_ERROR_NULL);
        }
        if (place < this.materiels.length && place >= 0){
            this.materiels[place] = materiel;
        }
        else {
            System.out.println("emplacement invalide");
        }
    }

    protected void enleverMateriel(int place) {
        if (place < this.materiels.length && place >= 0){
            this.materiels[place] = null;
        }
        else {
            System.out.println("emplacement invalide");
        }
    }

    protected String getNom() {
        return nom;
    }

    protected TypeConcert getTypeConcert() {
        return typeConcert;
    }

    protected Lieu getLieu() {
        return lieu;
    }

    public Musicien[] getMusiciens() {
        return Arrays.copyOf(musiciens, musiciens.length);
    }

    public Materiel[] getMateriels() {
        return Arrays.copyOf(materiels, materiels.length);
    }

    public LocalDateTime getDateConcert() {
        return dateConcert;
    }

    public void setDateConcert(LocalDateTime dateConcert) throws ConcertException {
        if(Objects.isNull(dateConcert)){
            throw new ConcertException(ConstantesMetier.CONCERT_DATE_NULL);
        }
        if(dateConcert.isBefore(LocalDateTime.now())){
            throw new ConcertException(ConstantesMetier.CONCERT_DATE_PASSE);
        }

        this.dateConcert = dateConcert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Objects.equals(nom, concert.nom) && Objects.equals(lieu, concert.lieu) && Objects.equals(dateConcert, concert.dateConcert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, lieu, dateConcert);
    }

    @Override
    public String toString() {
        return "Concert{" +
                "nom='" + nom + '\'' +
                ", typeConcert=" + typeConcert +
                ", lieu=" + lieu +
                ", dateConcert=" + dateConcert +
                '}';
    }
}
