package net.ent.etrs.coffrefort.model;


import net.ent.etrs.coffrefort.model.exceptions.KeyAlreadyGivenException;
import net.ent.etrs.coffrefort.model.exceptions.LockerAlreadyClosedException;
import net.ent.etrs.coffrefort.model.exceptions.LockerAlreadyOpenException;
import net.ent.etrs.coffrefort.model.exceptions.LockerNotOpenException;
import net.ent.etrs.coffrefort.model.refs.Etat;

import java.util.UUID;

public class CoffreFort<E> {

    private E element;

    private final UUID key;

    private boolean keyHasBeenGiven = false;

    private Etat etat;

    public CoffreFort() {
        this.key = UUID.randomUUID();
    }

    public UUID getKey() throws KeyAlreadyGivenException {
        if (this.keyHasBeenGiven) {
            throw new KeyAlreadyGivenException("La clé a déja été délivré !");
        }
        this.keyHasBeenGiven = true;
        return this.key;
    }

    public void open(UUID k) throws LockerAlreadyOpenException {
        if (this.etat == Etat.OPEN) {
            throw new LockerAlreadyOpenException("Le coffre est déja ouvert.");
        }
        if (k == this.key) {
            this.etat = Etat.OPEN;
        }
    }

    public void close(UUID k) throws LockerAlreadyClosedException {
        if (this.etat == Etat.CLOSE) {
            throw new LockerAlreadyClosedException("Le coffre est fermé.");
        }
        if (k == this.key) {
            this.etat = Etat.CLOSE;
        }
    }

    public E getElement() throws LockerNotOpenException {
        if (this.etat == Etat.OPEN) {
            return element;
        } else {
            throw new LockerNotOpenException("Le coffre est fermé !");
        }

    }

    public E putElement(E newElement) throws LockerNotOpenException {
        if (this.etat == Etat.OPEN) {
            E oldElement = this.element;
            this.element = newElement;
            return oldElement;
        } else {
            throw new LockerNotOpenException("Le coffre est fermé !");
        }
    }
}
