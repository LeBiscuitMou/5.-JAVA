package net.ent.etrs.poinsot.demoComparableComparator.model.entities;

import net.ent.etrs.poinsot.demoComparableComparator.model.entities.exceptions.MilitaireException;
import net.ent.etrs.poinsot.demoComparableComparator.model.entities.references.ConstanteMetier;
import net.ent.etrs.poinsot.demoComparableComparator.model.entities.references.GradeOTAN;

import java.util.Objects;

public class Militaire implements Comparable<Militaire> {
    private String nid;
    private GradeOTAN gradeOTAN;
    private String nom;
    private String prenom;

    public Militaire(String nid, GradeOTAN gradeOTAN, String nom, String prenom) throws MilitaireException {
        this.setNid(nid);
        this.setGradeOTAN(gradeOTAN);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) throws MilitaireException {
        if (Objects.isNull(nid)) {
            throw new MilitaireException(ConstanteMetier.MILITAIRE_NID_IS_NULL);
        }
        if (nid.isBlank()) {
            throw new MilitaireException(ConstanteMetier.MILITAIRE_NID_IS_BLANK);
        }
        this.nid = nid;
    }

    public GradeOTAN getGradeOTAN() {
        return gradeOTAN;
    }

    public void setGradeOTAN(GradeOTAN gradeOTAN) throws MilitaireException {
        if (Objects.isNull(gradeOTAN)) {
            throw new MilitaireException(ConstanteMetier.MILITAIRE_GRADE_OTAN_IS_NULL);
        }
        this.gradeOTAN = gradeOTAN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws MilitaireException {
        if (Objects.isNull(nom)) {
            throw new MilitaireException(ConstanteMetier.MILITAIRE_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new MilitaireException(ConstanteMetier.MILITAIRE_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws MilitaireException {
        if (Objects.isNull(prenom)) {
            throw new MilitaireException(ConstanteMetier.MILITAIRE_PRENOM_IS_NULL);
        }
        if (prenom.isBlank()) {
            throw new MilitaireException(ConstanteMetier.MILITAIRE_PRENOM_IS_BLANK);
        }
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Militaire militaire = (Militaire) o;
        return Objects.equals(nid, militaire.nid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid);
    }

    @Override
    public String toString() {
        return "Militaire{" +
                "nid='" + nid + '\'' +
                ", gradeOTAN=" + gradeOTAN +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    @Override
    public int compareTo(Militaire o) {
        return this.nid.compareTo(o.getNid());
    }
}