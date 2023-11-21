package net.ent.etrs.groupeMusique.model;

import net.ent.etrs.groupeMusique.model.exception.MaterielException;

public class Instrument extends Materiel{
    protected Instrument(String reference) throws MaterielException {
        super(reference);
    }
}
