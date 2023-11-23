package net.ent.etrs.emploi.model.entities;

import net.ent.etrs.emploi.model.entities.exceptions.JourneeException;
import net.ent.etrs.emploi.model.entities.references.JoursDeLaSemaine;
import net.ent.etrs.emploi.model.entities.references.TypeMatiere;
import net.ent.etrs.emploi.model.references.ConstantesMetier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Journee {
    private List<Matiere> lesMatieres = new ArrayList<>();
    private List<Cours> lesCours = new ArrayList<>();
    private TypeMatiere typeMatiere;
    private JoursDeLaSemaine jour;
    private LocalDateTime heureEtDateJournee;

    public Journee(TypeMatiere typeMatiere, JoursDeLaSemaine jour, LocalDateTime heureEtDateJournee) throws JourneeException {
        this.setTypeMatiere(typeMatiere);
        this.setJour(jour);
        this.setHeureEtDateJournee(heureEtDateJournee);
    }

    public List<Matiere> getLesMatieres() {
        return Collections.unmodifiableList(this.lesMatieres);
    }

    public List<Cours> getLesCours() {
        return Collections.unmodifiableList(this.lesCours);
    }

    public TypeMatiere getTypeMatiere() {
        return typeMatiere;
    }

    public void setTypeMatiere(TypeMatiere typeMatiere) {
        this.typeMatiere = typeMatiere;
    }

    public JoursDeLaSemaine getJour() {
        return jour;
    }

    public void setJour(JoursDeLaSemaine jour) throws JourneeException {
        if (Objects.isNull(jour)) {
            throw new JourneeException(ConstantesMetier.JOURNEE_JOUR_SEMAINE_IS_NULL);
        }
        this.jour = jour;
    }

    public LocalDateTime getHeureEtDateJournee() {
        return heureEtDateJournee;
    }

    public void setHeureEtDateJournee(LocalDateTime heureEtDateJournee) throws JourneeException {
        if (Objects.isNull(heureEtDateJournee)) {
            throw new JourneeException(ConstantesMetier.COURS_HEURE_DEBUT_IS_NULL);
        }
        this.heureEtDateJournee = heureEtDateJournee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journee journee = (Journee) o;
        return jour == journee.jour && Objects.equals(heureEtDateJournee, journee.heureEtDateJournee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jour, heureEtDateJournee);
    }

    @Override
    public String toString() {
        return "Journee{" +
                "typeMatiere=" + typeMatiere +
                ", jour=" + jour +
                ", heureEtDateJournee=" + heureEtDateJournee +
                '}';
    }
}
