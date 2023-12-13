package net.ent.etrs.poeleague.model.entities;

import net.ent.etrs.poeleague.model.entities.exceptions.PersonnageException;
import net.ent.etrs.poeleague.model.entities.references.ConstantMetier;
import net.ent.etrs.poeleague.model.entities.references.LabySpecialite;

import java.util.Objects;

public class Personnage extends AbstractEntity {

    private String pseudo;
    private Integer level;
    private LabySpecialite build;

    public Personnage(String pseudo, Integer level, LabySpecialite build) throws PersonnageException {
        this.setBuild(build);
        this.setLevel(level);
        this.setPseudo(pseudo);
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) throws PersonnageException {
        if (null == pseudo || pseudo.isBlank()) {
            throw new PersonnageException(ConstantMetier.PERSONNAGE_NOM_INCORRECT);
        }
        this.pseudo = pseudo;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) throws PersonnageException {
        if (Objects.isNull(level)) {
            throw new PersonnageException(ConstantMetier.PERSONNAGE_LEVEL_NULL);
        }
        if (level < ConstantMetier.PERSONNAGE_LEVEL_MIN || level > ConstantMetier.PERSONNAGE_LEVEL_MAX) {
            throw new PersonnageException(ConstantMetier.PERSONNAGE_LEVEL_ERROR);
        }
        this.level = level;
    }

    public LabySpecialite getBuild() {
        return build;
    }

    public void setBuild(LabySpecialite build) throws PersonnageException {
        if (null == build) {
            throw new PersonnageException(ConstantMetier.PERSONNAGE_BUILD_NULL);
        }
        this.build = build;
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
        return Objects.hash(super.hashCode(), pseudo);
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "pseudo='" + pseudo + '\'' +
                ", level=" + level +
                ", build=" + build +
                "} " + super.toString();
    }
}
