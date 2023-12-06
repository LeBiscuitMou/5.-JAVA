package net.ent.etrs.poinsot.coffreFort.model;

import net.ent.etrs.poinsot.coffreFort.model.exceptions.CoffreFortException;
import net.ent.etrs.poinsot.coffreFort.model.exceptions.KeyAlreadyGivenException;
import net.ent.etrs.poinsot.coffreFort.model.exceptions.LockerAlreadyOpenException;
import net.ent.etrs.poinsot.coffreFort.model.references.ConstanteMetier;
import net.ent.etrs.poinsot.coffreFort.model.references.Etat;

import java.util.Objects;
import java.util.UUID;

public class CoffreFort<E> {
    private final UUID key = UUID.randomUUID();
    private boolean keyHasBeenGiven = false;
    private Etat etat;

    public CoffreFort() {
    }

    public UUID getKey() throws KeyAlreadyGivenException {
        if (isKeyHasBeenGiven()) {
            throw new KeyAlreadyGivenException(ConstanteMetier.COFFRE_FORT_KEY_ALREADY_GIVEN);
        }
        return key;
    }

    public boolean isKeyHasBeenGiven() {
        return keyHasBeenGiven;
    }

    public void setKeyHasBeenGiven(boolean keyHasBeenGiven) {
        this.keyHasBeenGiven = keyHasBeenGiven;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) throws CoffreFortException {
        if (Objects.isNull(etat)) {
            throw new CoffreFortException(ConstanteMetier.COFFRE_FORT_ETAT_IS_NULL);
        }
        this.etat = etat;
    }

    public void open(UUID k) throws LockerAlreadyOpenException, CoffreFortException {
        if (etat.equals(Etat.OPEN)) {
            throw new LockerAlreadyOpenException(ConstanteMetier.COFFRE_FORT_DEJA_OUVERT);
        }
        if (this.key.equals(k)) {
            this.setEtat(Etat.OPEN);
        }
    }

    public void close(UUID k) throws LockerAlreadyOpenException, CoffreFortException {
        if (etat.equals(Etat.CLOSED)) {
            throw new LockerAlreadyOpenException(ConstanteMetier.COFFRE_FORT_DEJA_FERME);
        }
        if (this.key.equals(k)) {
            this.setEtat(Etat.CLOSED);
        }
    }

    public E getElement() {
        if (etat.equals(Etat.CLOSED)) {

        }
    }

    public E putElement(E newElement) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffreFort<?> that = (CoffreFort<?>) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "CoffreFort{" +
                "key=" + key +
                ", keyHasBeenGiven=" + keyHasBeenGiven +
                '}';
    }
}