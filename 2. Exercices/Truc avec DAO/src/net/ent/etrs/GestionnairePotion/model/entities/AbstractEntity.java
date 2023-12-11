package net.ent.etrs.GestionnairePotion.model.entities;

import java.util.Objects;

public abstract class AbstractEntity {

    Long id = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (Objects.nonNull(id)) {
            this.id = id;
        }
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
