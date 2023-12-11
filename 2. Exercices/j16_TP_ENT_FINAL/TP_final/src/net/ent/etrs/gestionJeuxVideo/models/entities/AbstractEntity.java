package net.ent.etrs.gestionJeuxVideo.models.entities;

import net.ent.etrs.gestionJeuxVideo.models.entities.exceptions.AbstractEntityException;
import net.ent.etrs.gestionJeuxVideo.models.references.ConstanteMetier;

import java.util.Objects;

public abstract class AbstractEntity {
    Long id = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws AbstractEntityException {
        if (id < 0) {
            throw new AbstractEntityException(ConstanteMetier.ABSTRACT_ENTITY_ID_IS_NEGATIVE);
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }
}