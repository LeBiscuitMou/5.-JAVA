package net.ent.etrs.gestionLeague.models.entities;

import net.ent.etrs.gestionLeague.models.entities.exceptions.PersonnageException;
import net.ent.etrs.gestionLeague.models.entities.references.ConstantesMetier;
import net.ent.etrs.gestionLeague.models.entities.references.LabySpecialite;

import java.util.Objects;

public class Personnage extends AbstractEntity {
    private Integer level;
    private LabySpecialite build;
    private String pseudo;

    public Personnage(Integer level, LabySpecialite build, String pseudo) throws PersonnageException {
        this.setLevel(level);
        this.setBuild(build);
        this.setPseudo(pseudo);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) throws PersonnageException {
        if (Objects.isNull(level)) {
            throw new PersonnageException(ConstantesMetier.PERSONNAGE_LEVEL_NULL);
        }
        if (level < ConstantesMetier.PERSONNAGE_LEVEL_MIN || level > ConstantesMetier.PERSONNAGE_LEVEL_MAX) {
            throw new PersonnageException(ConstantesMetier.PERSONNAGE_LEVEL_ERROR);
        }
        this.level = level;
    }

    public LabySpecialite getBuild() {
        return build;
    }

    public void setBuild(LabySpecialite build) throws PersonnageException {
        if (Objects.isNull(build)) {
            throw new PersonnageException(ConstantesMetier.PERSONNAGE_BUILD_NULL);
        }
        this.build = build;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) throws PersonnageException {
        if (Objects.isNull(pseudo) || pseudo.isBlank()) {
            throw new PersonnageException(ConstantesMetier.PERSONNAGE_NOM_INCORRECT);
        }
        this.pseudo = pseudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnage that = (Personnage) o;
        return Objects.equals(pseudo, that.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo);
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "level=" + level +
                ", build=" + build +
                ", pseudo='" + pseudo + '\'' +
                '}';
    }
}