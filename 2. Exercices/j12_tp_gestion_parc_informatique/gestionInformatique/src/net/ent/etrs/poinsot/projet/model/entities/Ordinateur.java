package net.ent.etrs.poinsot.projet.model.entities;

import net.ent.etrs.poinsot.projet.model.entities.exceptions.MaterielInformatiqueException;
import net.ent.etrs.poinsot.projet.model.entities.exceptions.OrdinateurException;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;
import net.ent.etrs.poinsot.projet.model.references.TypeOrdinateur;
import net.ent.etrs.poinsot.projet.model.references.TypeReseau;

import java.time.LocalDate;
import java.util.Objects;

public class Ordinateur extends MaterielInformatique {
    private TypeOrdinateur typeOrdinateur;
    private TypeReseau typeReseau;

    protected Ordinateur(String numSerie, LocalDate dateGarantie) throws MaterielInformatiqueException {
        super(numSerie, dateGarantie);
    }

    public TypeOrdinateur getTypeOrdinateur() {
        return typeOrdinateur;
    }

    public void setTypeOrdinateur(TypeOrdinateur typeOrdinateur) throws OrdinateurException {
        if (Objects.isNull(typeOrdinateur)) {
            throw new OrdinateurException(ConstanteMetier.ORDINATEUR_TYPE_ORDINATEUR_IS_NULL);
        }
        this.typeOrdinateur = typeOrdinateur;
    }

    public TypeReseau getTypeReseau() {
        return typeReseau;
    }

    public void setTypeReseau(TypeReseau typeReseau) throws OrdinateurException {
        if (Objects.isNull(typeReseau)) {
            throw new OrdinateurException(ConstanteMetier.ORDINATEUR_TYPE_ORDINATEUR_IS_NULL);
        }
        this.typeReseau = typeReseau;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "typeOrdinateur=" + typeOrdinateur +
                ", typeReseau=" + typeReseau +
                '}';
    }
}