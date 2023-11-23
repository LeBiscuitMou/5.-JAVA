package net.ent.etrs.gestionformation.models.entities;

import net.ent.etrs.gestionformation.models.entities.exceptions.CoursException;
import net.ent.etrs.gestionformation.models.entities.references.ConstanteMetier;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cours {

    private String idCours;

    private int duree;

    private LocalDateTime debutCours;

    protected Cours(String idCours, int duree) throws CoursException {
       this.setIdCours(idCours);
       this.setDuree(duree);
    }

    public String getIdCours() {
        return idCours;
    }

    private void setIdCours(String idCours) throws CoursException {
        if (Objects.isNull(idCours)) {
            throw new CoursException(ConstanteMetier.COURS_ID_NULL);
        }
        if(idCours.isBlank()){
            throw new CoursException(ConstanteMetier.COURS_ID_VIDE);
        }
        this.idCours = idCours;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) throws CoursException {
        if (duree < ConstanteMetier.COURS_DUREE_MIN || duree > ConstanteMetier.COURS_DUREE_MAX){
            throw new CoursException(ConstanteMetier.COURS_DUREE_INCORRECTE);
        }

        this.duree = duree;
    }

    public LocalDateTime getDebutCours() {
        return debutCours;
    }

    public void setDebutCours(LocalDateTime debutCours) throws CoursException {
        if (Objects.isNull(debutCours)){
            throw new CoursException(ConstanteMetier.COURS_DEBUT_COURS_NULL);
        }
        this.debutCours = debutCours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Objects.equals(idCours, cours.idCours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCours);
    }

    @Override
    public String toString() {
        return "Cours{" +
                "idCours='" + idCours + '\'' +
                ", duree=" + duree +
                ", debutCours=" + debutCours +
                '}';
    }
}
