package net.ent.etrs.emploi.model.facades;

import net.ent.etrs.emploi.model.entities.Cours;
import net.ent.etrs.emploi.model.entities.Journee;
import net.ent.etrs.emploi.model.entities.Matiere;
import net.ent.etrs.emploi.model.entities.UniteValeur;
import net.ent.etrs.emploi.model.entities.references.TypeMatiere;
import net.ent.etrs.emploi.model.facades.exceptions.FacadeMetierEmploiTempsException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FacadeMetierEmploiTemps {
    public UniteValeur creerUniteValeur(String nom, LocalDate dateDebut) throws FacadeMetierEmploiTempsException;
    public Matiere creerMatiere(String nom, String codeMatiere, TypeMatiere typeMatiere, int leNombreHeureMatiere) throws FacadeMetierEmploiTempsException;
    public void ajouterCoursMatiere(String nomMatiere, Cours cours);
    public Cours creerCours(int numCours, int duree, LocalDateTime heureDebutCours) throws FacadeMetierEmploiTempsException;
    public List<Cours> afficherTousLesCoursMatiere();
    public List<Matiere> afficherToutesLesMatieresUV();
    public Journee creerJourneeCours();
}
