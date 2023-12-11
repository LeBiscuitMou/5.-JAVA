package net.ent.etrs.CatalogueJeuVideo.model.entities;

import net.ent.etrs.CatalogueJeuVideo.model.exceptions.ConsoleException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.JeuVideoException;
import net.ent.etrs.CatalogueJeuVideo.model.references.ConstErrMsg;
import net.ent.etrs.CatalogueJeuVideo.model.references.Pays;
import net.ent.etrs.CatalogueJeuVideo.model.utils.StringVerif;
import net.ent.etrs.CatalogueJeuVideo.model.utils.exceptions.StringVerifException;

import java.time.LocalDate;
import java.util.*;

public class Console extends AbstractEntity {
    /* ******************************** VARIABLES ******************************** */
    private String nom;
    private Fabriquant fabriquant;
    private final Map<Pays, LocalDate> sorties = new HashMap<>();

    /* ******************************* CONSTRUCTOR ******************************* */
    protected Console(String nom, Fabriquant fabriquant) throws ConsoleException {
        this.setNom(nom);
        this.setFabriquant(fabriquant);
    }

    protected Console(String nom, Fabriquant fabriquant, Map<Pays, LocalDate> sorties) throws ConsoleException {
        this.setNom(nom);
        this.setFabriquant(fabriquant);
        for(Map.Entry<Pays, LocalDate> entry : sorties.entrySet()){
            setSortiePays(entry.getKey(), entry.getValue());
        }
    }
    /* ********************************* GETTERS ********************************* */
    public String getNom() {
        return nom;
    }

    public Fabriquant getFabriquant() {
        return fabriquant;
    }

    public Map<Pays, LocalDate> getSorties() {
        return Collections.unmodifiableMap(sorties);
    }
    /* ********************************* SETTERS ********************************* */
    private void setNom(String nom) throws ConsoleException {
        try {
            StringVerif.verifierString(nom);
        } catch (StringVerifException e) {
            throw new ConsoleException(ConstErrMsg.NOM_INCORRECT, e);
        }
        this.nom = nom;
    }

    private void setFabriquant(Fabriquant fabriquant) throws ConsoleException {
        if(Objects.isNull(fabriquant)){
            throw new ConsoleException(ConstErrMsg.FABRICANT_NULL);
        }

        this.fabriquant = fabriquant;
    }
    /* ******************************** FONCTIONS ******************************** */
    public void setSortiePays(Pays pays, LocalDate dateSortie) throws ConsoleException {
        if(Objects.isNull(pays)){
            throw new ConsoleException(ConstErrMsg.PAYS_NULL);
        }
        if(Objects.isNull(dateSortie)){
            throw new ConsoleException(ConstErrMsg.DATE_SORTIE_NULL);
        }
        if(sorties.containsKey(pays)){
            throw new ConsoleException(ConstErrMsg.DATE_SORTIE_EXIST);
        }
        // une console peut être prévue d'être sortie dans un pays dans le futur.
        sorties.put(pays, dateSortie);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Console console)) return false;
        return Objects.equals(getNom(), console.getNom()) && Objects.equals(getFabriquant(), console.getFabriquant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getFabriquant());
    }

    @Override
    public String toString() {
        return "Console{" +
                "nom='" + nom + '\'' +
                ", fabriquant=" + fabriquant +
                '}';
    }

    /* **************************** PRIVATE FUNCTIONS **************************** */


}
