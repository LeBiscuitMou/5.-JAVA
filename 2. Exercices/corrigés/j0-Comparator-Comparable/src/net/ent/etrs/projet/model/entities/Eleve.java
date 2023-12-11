package net.ent.etrs.projet.model.entities;

import net.ent.etrs.projet.model.exceptions.EleveException;
import net.ent.etrs.projet.model.references.ConstMetier;
import net.ent.etrs.projet.model.references.ErrorMsg;
import net.ent.etrs.projet.model.utils.StringVerif;
import net.ent.etrs.projet.model.utils.exceptions.StringVerifException;

import java.util.Objects;

public class Eleve implements Comparable<Eleve> {
    /* ******************************** VARIABLES ******************************** */
    private String nid;
    private String nom;
    private String prenom;
    /* ******************************* CONSTRUCTOR ******************************* */

    public Eleve(String nid, String nom, String prenom) throws EleveException {
        this.setNid(nid);
        this.setNom(nom);
        this.setPrenom(prenom);
    }
    /* ********************************* GETTERS ********************************* */
    public String getNid() {
        return nid;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    /* ********************************* SETTERS ********************************* */

    private void setNid(String nid) throws EleveException {
        try {
            StringVerif.verifierString(nid, ConstMetier.NID_SIZE, ConstMetier.NID_SIZE);
        } catch (StringVerifException e) {
            throw new EleveException(ErrorMsg.ELEVE_NID_INVALIDE);
        }
        this.nid = nid;
    }

    private void setNom(String nom) throws EleveException {
        try {
            StringVerif.verifierString(nom);
        } catch (StringVerifException e) {
            throw new EleveException(ErrorMsg.ELEVE_NOM_INVALIDE);
        }
        this.nom = nom;
    }

    private void setPrenom(String prenom) throws EleveException {
        try {
            StringVerif.verifierString(prenom);
        } catch (StringVerifException e) {
            throw new EleveException(ErrorMsg.ELEVE_PRENOM_INVALIDE);
        }
        this.prenom = prenom;
    }
    /* ******************************** FONCTIONS ******************************** */

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Eleve eleve)) return false;
        return Objects.equals(getNid(), eleve.getNid()) && Objects.equals(getNom(), eleve.getNom()) && Objects.equals(getPrenom(), eleve.getPrenom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNid(), getNom(), getPrenom());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", nid, nom, prenom);
    }

    @Override
    public int compareTo(Eleve eleve){
        if(this.nom.compareTo(eleve.getNom()) != 0){
            this.nom.compareTo(eleve.getNom());
        }
        if(this.prenom.compareTo(eleve.getPrenom()) != 0){
            this.prenom.compareTo(eleve.getPrenom());
        }
        return this.nid.compareTo(eleve.getNid());
    }


    /* **************************** PRIVATE FUNCTIONS **************************** */
}
