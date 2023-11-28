package net.ent.etrs.exemplePersonne.model.entities;

import net.ent.etrs.exemplePersonne.model.entities.exceptions.PersonneExceptions;
import net.ent.etrs.exemplePersonne.model.entities.references.ConstanteMetier;

import java.time.LocalDate;
import java.util.*;

public class Personne {

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    List<Voiture> sesVoitures = new ArrayList<>();

    protected Personne(String nom, String prenom, LocalDate dateNaissance) throws PersonneExceptions {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public LocalDate getDateNaissance() {
        return this.dateNaissance;
    }

    public List<Voiture> getSesVoitures() {
        return Collections.unmodifiableList(this.sesVoitures);
    }

    private void setNom(String leNom) throws PersonneExceptions {
        if(Objects.isNull(leNom)){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_NOM_NULL);
        }
        if (leNom.isBlank()){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_NOM_VIDE);
        }
        //Règles métier

      this.nom = leNom;
    }

    private void setPrenom(String pPrenom) throws PersonneExceptions {
        if(Objects.isNull(pPrenom)){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_PRENOM_NULL);
        }
        if (pPrenom.isBlank()){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_PRENOM_VIDE);
        }
        this.prenom = pPrenom;
    }

    private void setDateNaissance(LocalDate dateNaissance) throws PersonneExceptions {
        if(Objects.isNull(dateNaissance)){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_DATE_NULL);
        }
        if(dateNaissance.isAfter(LocalDate.now())){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_DATE_FUTUR);
        }
        //Règles métier

        this.dateNaissance = dateNaissance;
    }

    public void ajouterVoiture(Voiture laVoiture) throws PersonneExceptions {
        if(Objects.isNull(laVoiture)){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_VOITURE_NULL);
        }
        if(this.sesVoitures.contains(laVoiture)){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_VOITURE_ALREADY_EXIST);
        }

        this.sesVoitures.add(laVoiture);
    }

    public void retirerVoiture(Voiture laVoiture) throws PersonneExceptions {
        if(null == laVoiture){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_VOITURE_NULL);
        }
        if(!this.sesVoitures.contains(laVoiture)){
            throw new PersonneExceptions(ConstanteMetier.PERSONNE_VOITURE_NOT_EXIST);
        }
        this.sesVoitures.remove(laVoiture);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(dateNaissance, personne.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, dateNaissance);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
