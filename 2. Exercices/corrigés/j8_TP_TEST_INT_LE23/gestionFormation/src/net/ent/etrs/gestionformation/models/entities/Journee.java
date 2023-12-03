package net.ent.etrs.gestionformation.models.entities;

import net.ent.etrs.gestionformation.models.entities.exceptions.JourneeException;
import net.ent.etrs.gestionformation.models.entities.references.ConstanteMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Journee {

    private LocalDate date;

    private List<Cours> lesCours = new ArrayList<>();

    protected Journee(LocalDate date) throws JourneeException {
        this.setDate(date);
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(LocalDate date) throws JourneeException {
        if (Objects.isNull(date)){
            throw new JourneeException(ConstanteMetier.JOURNEE_DATE_NULL);
        }
        this.date = date;
    }

    public List<Cours> getLesCours() {
        return lesCours;
    }

    public void ajouterCours(Cours cours) throws JourneeException {
        if (Objects.isNull(cours)){
            throw new JourneeException(ConstanteMetier.JOURNEE_COURS_NULL);
        }
        if (this.lesCours.contains(cours)){
            throw new JourneeException(ConstanteMetier.JOURNEE_COURS_ALREADY_EXIST);
        }
        if(calculHeureCours()+cours.getDuree() > ConstanteMetier.JOURNEE_NB_HEURE_MAX){
            throw new JourneeException(ConstanteMetier.JOURNEE_NB_HEURE_ERROR);
        }
        if(verificationHeureCours(cours)){
            throw new JourneeException(ConstanteMetier.JOURNEE_COURS_PRESENT_A_CETTE_HEURE);
        }
        this.lesCours.add(cours);
    }

    /**
     * Permet de vérifier qu'il n'y a pas de cours pendant le cours que l'on ajoute
     * @param cours cours à ajouter
     * @return s'il y a un cours en simultané
     */
    private boolean verificationHeureCours(Cours cours) {
        for (Cours c : lesCours) {
            //Si le cours à ajouter commence en même temps que le cours courant
            if(cours.getDebutCours().isEqual(c.getDebutCours())){
                return true;
            }
            //Si son commencement est dans le cours déjà présent
           if(cours.getDebutCours().isAfter(c.getDebutCours()) && cours.getDebutCours().isBefore(c.getDebutCours().plusHours(c.getDuree()))){
                return true;
           }
            //Si sa fin est dans le cours déjà présent
            if (cours.getDebutCours().plusHours(cours.getDuree()).isAfter(c.getDebutCours()) && cours.getDebutCours().plusHours(cours.getDuree()).isBefore(c.getDebutCours().plusHours(c.getDuree()))){
                return true;
            }
        }

        return false;
    }

    /**
     * Permet de calculer le nombre d'heure de cours dans une journée.
     * @return le nombre d'heure déjà programmer dans la journée.
     */
    private int calculHeureCours() {
        int retour = 0;
        for (Cours cours : this.lesCours) {
            retour += cours.getDuree();
        }
        return retour;
    }
}
