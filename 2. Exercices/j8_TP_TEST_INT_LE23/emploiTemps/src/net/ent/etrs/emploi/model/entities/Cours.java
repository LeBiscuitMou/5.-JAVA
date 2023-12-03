package net.ent.etrs.emploi.model.entities;

import net.ent.etrs.emploi.model.entities.exceptions.CoursException;
import net.ent.etrs.emploi.model.references.ConstantesMetier;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cours {
    private String idCours;
    private int numCours;
    private int duree;
    private LocalDateTime heureDebutCours;

    public Cours(int numCours, int duree, LocalDateTime heureDebutCours) throws CoursException {
        this.setNumCours(numCours);
        this.setDuree(duree);
        this.setHeureDebutCours(heureDebutCours);
    }

    public int getNumCours() {
        return numCours;
    }

    public void setNumCours(int numCours) {
        this.numCours = numCours;
    }

    public String getIdCours() {
        return idCours;
    }

    public void setIdCours(String codMatiere) throws CoursException {
        if (Objects.isNull(codMatiere)) {
            throw new CoursException(ConstantesMetier.ID_COURS_OBJECT_NULL);
        }
        if (codMatiere.isBlank()) {
            throw new CoursException(ConstantesMetier.ID_COURS_OBJECT_IS_BLANK);
        }
        this.idCours = codMatiere + "-" + numCours;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) throws CoursException {
        if (duree <= 0) {
            throw new CoursException(ConstantesMetier.COURS_DUREE_NEGATIF_0);
        }
        if (duree > ConstantesMetier.DUREE_MAX_COURS) {
            throw new CoursException(ConstantesMetier.COURS_DUREE_TROP_LONGUE);
        }
        this.duree = duree;
    }

    public LocalDateTime getHeureDebutCours() {
        return heureDebutCours;
    }

    public void setHeureDebutCours(LocalDateTime heureDebutCours) throws CoursException {
        if (Objects.isNull(heureDebutCours)) {
            throw new CoursException(ConstantesMetier.COURS_HEURE_DEBUT_IS_NULL);
        }
        if (verifierHorairesJournee(heureDebutCours)) {
            this.heureDebutCours = heureDebutCours;
        }
    }

    public boolean verifierHorairesJournee(LocalDateTime heureDebutCours) throws CoursException {
        if (heureDebutCours.getHour() < ConstantesMetier.HEURE_DEBUT_JOURNEE) {
            throw new CoursException(ConstantesMetier.COURS_HEURE_DEBUT_AVANT_DEBUT_JOURNEE);
        }
        if (heureDebutCours.getHour() > ConstantesMetier.HEURE_FIN_JOURNEE) {
            throw new CoursException(ConstantesMetier.COURS_HEURE_FIN_APRES_FIN_JOURNEE);
        }
        if ((heureDebutCours.getHour() == ConstantesMetier.HEURE_PAUSE_MIDI)
                &&  heureDebutCours.getMinute() > ConstantesMetier.MINUTE_PAUSE_MIDI) {
            throw new CoursException(ConstantesMetier.COURS_HEURE_PAUSE_DE_MIDI_FAIM);
        }
        return true;
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
                ", numCours=" + numCours +
                ", duree=" + duree +
                ", heureDebutCours=" + heureDebutCours +
                '}';
    }
}
