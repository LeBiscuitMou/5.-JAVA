package net.ent.etrs.gestionformation.models.entities;

import net.ent.etrs.gestionformation.models.entities.exceptions.UniteValeurException;
import net.ent.etrs.gestionformation.models.entities.references.ConstanteMetier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UniteValeur {

    private String nom;

    private LocalDate dateDebut;

    List<Matiere> lesMatieres = new ArrayList<Matiere>();

    protected UniteValeur(String nom, LocalDate dateDebut) throws UniteValeurException {
        this.setNom(nom);
        this.setDateDebut(dateDebut);
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws UniteValeurException {

        if (Objects.isNull(nom)) {
            throw new UniteValeurException(ConstanteMetier.UV_NOM_NULL);
        }
        if(nom.isBlank()){
            throw new UniteValeurException(ConstanteMetier.UV_NOM_VIDE);
        }
        this.nom = nom;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    private void setDateDebut(LocalDate dateDebut) throws UniteValeurException {
        if (Objects.isNull(dateDebut)){
            throw new UniteValeurException(ConstanteMetier.UV_DATE_DEBUT_NULL);
        }
        if(!dateDebut.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            throw new UniteValeurException(ConstanteMetier.UV_DATE_DEBUT_DIFF_LUNDI);
        }
        this.dateDebut = dateDebut;
    }

    public List<Matiere> getLesMatieres() {
        return Collections.unmodifiableList(this.lesMatieres);
    }

    public void ajouterMatiere(Matiere matiere) throws UniteValeurException {
        if (Objects.isNull(matiere)){
            throw new UniteValeurException(ConstanteMetier.UV_MATIERE_NULL);
        }
        if (this.lesMatieres.contains(matiere)){
            throw new UniteValeurException(ConstanteMetier.UV_MATIERE_ALREADY_EXIST);
        }
        if (matiere.isValid()){
            this.lesMatieres.add(matiere);
        }else{
            throw new UniteValeurException(ConstanteMetier.UV_MATIERE_INVALID);
        }

    }

    public void retirerMatiere(Matiere matiere) throws UniteValeurException {
        if (Objects.isNull(matiere)){
            throw new UniteValeurException(ConstanteMetier.UV_MATIERE_NULL);
        }
        if (this.lesMatieres.contains(matiere)){
            this.lesMatieres.remove(matiere);
        }
        else {
            throw new UniteValeurException(ConstanteMetier.UV_MATIERE_UNKNOW);
        }

    }

    public boolean estValide(){
        return this.lesMatieres.size() > ConstanteMetier.UV_NB_MATIERE_MIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniteValeur that = (UniteValeur) o;
        return Objects.equals(nom, that.nom) && Objects.equals(dateDebut, that.dateDebut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, dateDebut);
    }

    @Override
    public String toString() {
        return "UniteValeur{" +
                "nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                '}';
    }
}
