package net.ent.etrs.emploi.model.entities;

import net.ent.etrs.emploi.model.entities.exceptions.MatiereException;
import net.ent.etrs.emploi.model.entities.references.TypeMatiere;
import net.ent.etrs.emploi.model.references.ConstantesMetier;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Matiere {
    private String nom;
    private String codeMatiere;
    private TypeMatiere typeMatiere;
    private List<Cours> lesCours;
    private int nombreHeureMatiere;

    public Matiere(String nom, String codeMatiere, TypeMatiere typeMatiere, int leNombreHeureMatiere) throws MatiereException {
        this.setNom(nom);
        this.setCodeMatiere(codeMatiere);
        this.setTypeMatiere(typeMatiere);
        this.setNombreHeureMatiere(leNombreHeureMatiere);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws MatiereException {
        if (Objects.isNull(nom)) {
            throw new MatiereException(ConstantesMetier.MATIERE_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new MatiereException(ConstantesMetier.MATIERE_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) throws MatiereException {
        if (Objects.isNull(codeMatiere)) {
            throw new MatiereException(ConstantesMetier.MATIERE_CODE_MATIERE_IS_NULL);
        }
        if (codeMatiere.isBlank()) {
            throw new MatiereException(ConstantesMetier.MATIERE_CODE_MATIERE_IS_BLANK);
        }
        this.codeMatiere = codeMatiere;
    }

    public TypeMatiere getTypeMatiere() {
        return typeMatiere;
    }

    public void setTypeMatiere(TypeMatiere typeMatiere) {
        this.typeMatiere = typeMatiere;
    }

    public int getNombreHeureMatiere() {
        return nombreHeureMatiere;
    }

    public void setNombreHeureMatiere(int nombreHeureMatiere) throws MatiereException {
        if (nombreHeureMatiere < 0) {
            throw new MatiereException(ConstantesMetier.MATIERE_NOMBRE_HEURES_MATIERE_NEGATIF);
        }
        if (nombreHeureMatiere < ConstantesMetier.NOMBRE_HEURES_MATIERE_MINIMUM) {
            throw new MatiereException(ConstantesMetier.MATIERE_NOMBRE_HEURES_INSUFFISANT);
        }
        if (nombreHeureMatiere > ConstantesMetier.NOMBRE_HEURES_MATIERE_MAXIMUM) {
            throw new MatiereException(ConstantesMetier.MATIERE_NOMBRE_HEURES_EXCESSIF);
        }
        this.nombreHeureMatiere = nombreHeureMatiere;
    }

    public List<Cours> getLesCours() {
        return Collections.unmodifiableList(this.lesCours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matiere matiere = (Matiere) o;
        return codeMatiere == matiere.codeMatiere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeMatiere);
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "nom='" + nom + '\'' +
                ", codeMatiere=" + codeMatiere +
                ", typeMatiere=" + typeMatiere +
                '}';
    }
}
