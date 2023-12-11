package net.ent.etrs.gestionJeuxVideo.models.entities;

import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.JeuVideoException;
import net.ent.etrs.gestionJeuxVideo.models.references.ConstanteMetier;
import net.ent.etrs.gestionJeuxVideo.models.references.Genre;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class JeuVideo extends AbstractEntity {
    private Fabriquant studioDev;
    private LocalDate dateSortie;
    private String nom;
    private Genre genre;
    private Set<Console> plateformes;

    public JeuVideo(Fabriquant studioDev, LocalDate dateSortie, String nom, Genre genre) throws JeuVideoException {
        this.setStudioDev(studioDev);
        this.setDateSortie(dateSortie);
        this.setNom(nom);
        this.setGenre(genre);
    }

    public Fabriquant getStudioDev() {
        return studioDev;
    }

    public void setStudioDev(Fabriquant studioDev) throws JeuVideoException {
        if (Objects.isNull(studioDev)) {
            throw new JeuVideoException(ConstanteMetier.FABRIQUANT_NOM_ERROR);
        }
        this.studioDev = studioDev;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) throws JeuVideoException {
        if (Objects.isNull(dateSortie)) {
            throw new JeuVideoException(ConstanteMetier.CONSOLE_PAYS_DATE_NULL);
        }
        if (dateSortie.isBefore(LocalDate.now())) {
            throw new JeuVideoException(ConstanteMetier.JEU_VIDEO_DATE_PASSE);
        }
        this.dateSortie = dateSortie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws JeuVideoException {
        if (Objects.isNull(nom)) {
            throw new JeuVideoException(ConstanteMetier.JEUVIDEO_NOM_ERROR);
        }
        if (nom.isBlank()) {
            throw new JeuVideoException(ConstanteMetier.JEUVIDEO_NOM_ERROR);
        }
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) throws JeuVideoException {
        if (Objects.isNull(genre)) {
            throw new JeuVideoException(ConstanteMetier.JEU_VIDEO_GENRE_IS_NULL);
        }
        this.genre = genre;
    }

    public Set<Console> getPlateformes() {
        return plateformes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JeuVideo jeuVideo = (JeuVideo) o;
        return Objects.equals(studioDev, jeuVideo.studioDev) && Objects.equals(dateSortie, jeuVideo.dateSortie) && Objects.equals(nom, jeuVideo.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studioDev, dateSortie, nom);
    }

    @Override
    public String toString() {
        return "JeuVideo{" +
                "studioDev=" + studioDev +
                ", dateSortie=" + dateSortie +
                ", nom='" + nom + '\'' +
                ", genre=" + genre +
                '}';
    }

    public void addPlateform(Console console) throws JeuVideoException {
        if (Objects.isNull(console)) {
            throw new JeuVideoException(ConstanteMetier.JEU_VIDEO_DATE_PASSE);
        }
        plateformes.add(console);
    }
}