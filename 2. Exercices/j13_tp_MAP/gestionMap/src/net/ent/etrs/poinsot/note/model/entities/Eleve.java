package net.ent.etrs.poinsot.note.model.entities;

import net.ent.etrs.poinsot.note.model.entities.exceptions.EleveException;
import net.ent.etrs.poinsot.note.model.references.ConstanteMetier;

import java.util.Objects;

public class Eleve implements Comparable<Eleve> {
    private String nid;
    private String nom;
    private String prenom;

    public Eleve(String nid, String nom, String prenom) throws EleveException {
        this.setNid(nid);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) throws EleveException {
        if (Objects.isNull(nid)) {
            throw new EleveException(ConstanteMetier.ELEVE_NID_IS_NULL);
        }
        if (nid.isBlank()) {
            throw new EleveException(ConstanteMetier.ELEVE_NID_IS_BLANK);
        }
        this.nid = nid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws EleveException {
        if (Objects.isNull(nom)) {
            throw new EleveException(ConstanteMetier.ELEVE_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new EleveException(ConstanteMetier.ELEVE_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws EleveException {
        if (Objects.isNull(prenom)) {
            throw new EleveException(ConstanteMetier.ELEVE_PRENOM_IS_NULL);
        }
        if (prenom.isBlank()) {
            throw new EleveException(ConstanteMetier.ELEVE_PRENOM_IS_BLANK);
        }
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleve eleve = (Eleve) o;
        return Objects.equals(nid, eleve.nid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid);
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "nid='" + nid + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    @Override
    public int compareTo(Eleve o) {
        return this.getNid().compareTo(o.getNid());
    }
}