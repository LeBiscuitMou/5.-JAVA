package net.ent.etrs.model.entities;

import net.ent.etrs.model.entities.exceptions.MaterielInformatiqueException;
import net.ent.etrs.model.entities.exceptions.OrdinateurException;
import net.ent.etrs.model.entities.references.TypeOrdinateur;
import net.ent.etrs.model.entities.references.TypeReseau;

import java.time.LocalDate;
import java.util.Objects;


public class Ordinateur extends MaterielInformatique{


    private TypeOrdinateur typeOrdinateur;


    private TypeReseau typeReseau;


    private Ordinateur() {
    }

    protected Ordinateur(final String numSerie, final LocalDate dateGarantie) throws MaterielInformatiqueException {
        super(numSerie, dateGarantie);
    }

    public TypeOrdinateur getTypeOrdinateur() {
        return typeOrdinateur;
    }

    public TypeReseau getTypeReseau() {
        return typeReseau;
    }

    public void setTypeOrdinateur(final TypeOrdinateur typeOrdinateur) throws OrdinateurException {
        if (Objects.isNull(typeOrdinateur)){
            throw new OrdinateurException();
        }
        this.typeOrdinateur = typeOrdinateur;
    }

    public void setTypeReseau(final TypeReseau typeReseau) throws OrdinateurException {
        if (Objects.isNull(typeOrdinateur)){
            throw new OrdinateurException();
        }
        this.typeReseau = typeReseau;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "typeOrdinateur=" + typeOrdinateur +
                ", typeReseau=" + typeReseau +
                "} " + super.toString();
    }
}
