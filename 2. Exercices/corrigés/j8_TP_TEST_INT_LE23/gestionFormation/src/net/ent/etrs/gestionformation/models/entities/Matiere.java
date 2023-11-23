package net.ent.etrs.gestionformation.models.entities;

import net.ent.etrs.gestionformation.models.entities.exceptions.MatiereException;
import net.ent.etrs.gestionformation.models.entities.references.ConstanteMetier;
import net.ent.etrs.gestionformation.models.entities.references.TypeMatiere;

import java.util.*;

public class Matiere {

    private String nom;

    private String codeMatiere;

    private TypeMatiere typeMatiere;

    List<Cours> lesCours = new ArrayList<>();

    protected Matiere(String nom, String codeMatiere,TypeMatiere type) throws MatiereException {
        this.setNom(nom);
        this.setCodeMatiere(codeMatiere);
        this.setTypeMatiere(type);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws MatiereException {

        if (Objects.isNull(nom)) {
            throw new MatiereException(ConstanteMetier.MATIERE_NOM_NULL);
        }
        if(nom.isBlank()){
            throw new MatiereException(ConstanteMetier.MATIERE_NOM_VIDE);
        }
        this.nom = nom;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    private void setCodeMatiere(String codeMatiere) throws MatiereException {

        if (Objects.isNull(nom)) {
            throw new MatiereException(ConstanteMetier.MATIERE_CODE_NULL);
        }
        if(nom.isBlank()){
            throw new MatiereException(ConstanteMetier.MATIERE_CODE_VIDE);
        }
        this.codeMatiere = codeMatiere;
    }

    public TypeMatiere getTypeMatiere() {
        return typeMatiere;
    }

    public void setTypeMatiere(TypeMatiere typeMatiere) throws MatiereException {
        if (Objects.isNull(typeMatiere)) {
            throw new MatiereException(ConstanteMetier.MATIERE_TYPEMATIERE_NULL);
        }
        this.typeMatiere = typeMatiere;
    }

    public List<Cours> getLesCours() {
        return Collections.unmodifiableList(this.lesCours);
    }

    public void ajouterCours(Cours cours) throws MatiereException {
        if (Objects.isNull(cours)){
            throw new MatiereException(ConstanteMetier.MATIERE_COURS_NULL);
        }
        if(this.lesCours.contains(cours)){
            throw new MatiereException(ConstanteMetier.MATIERE_COURS_ALREADY_EXIST);
        }
        this.lesCours.add(cours);
    }

    public void retirerCours(Cours cours) {
//TODO non demandé
    }

    public boolean isValid(){
        int nbHeure =0;

        for (Cours c :
                this.lesCours) {
            nbHeure += c.getDuree();
        }
        return nbHeure >= ConstanteMetier.MATIERE_NB_HEURE_MIN && nbHeure <= ConstanteMetier.MATIERE_NB_HEURE_MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matiere matiere = (Matiere) o;
        return Objects.equals(codeMatiere, matiere.codeMatiere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeMatiere);
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "nom='" + nom + '\'' +
                ", codeMatiere='" + codeMatiere + '\'' +
                '}';
    }
}
