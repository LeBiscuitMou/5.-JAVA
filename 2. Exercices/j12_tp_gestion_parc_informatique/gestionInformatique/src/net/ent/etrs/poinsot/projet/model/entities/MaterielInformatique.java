package net.ent.etrs.poinsot.projet.model.entities;

import net.ent.etrs.poinsot.projet.model.entities.exceptions.MaterielInformatiqueException;
import net.ent.etrs.poinsot.projet.model.references.ConstanteMetier;

import java.time.LocalDate;
import java.util.Objects;

public class MaterielInformatique {
    private String numSerie;
    private LocalDate dateGarantie;

    protected MaterielInformatique(String numSerie, LocalDate dateGarantie) throws MaterielInformatiqueException {
        this.setNumSerie(numSerie);
        this.setDateGarantie(dateGarantie);
    }

    public String getNumSerie() {
        return numSerie;
    }

    private void setNumSerie(String numSerie) throws MaterielInformatiqueException {
        if (Objects.isNull(numSerie)) {
            throw new MaterielInformatiqueException(ConstanteMetier.MSG_NUM_SERIE_NULL_EXCEPTION);
        }
        if (numSerie.isBlank()) {
            throw new MaterielInformatiqueException(ConstanteMetier.MSG_NUM_SERIE_BLANK_EXCEPTION);
        }
        if (numSerie.length() > ConstanteMetier.LONGUEUR_NUM_SERIE) {
            throw new MaterielInformatiqueException(ConstanteMetier.MSG_NUM_SERIE_LENGTH_EXCEPTION);
        }
        this.numSerie = numSerie;
    }

    public LocalDate getDateGarantie() {
        return dateGarantie;
    }

    public void setDateGarantie(LocalDate dateGarantie) throws MaterielInformatiqueException {
        if (Objects.isNull(dateGarantie)) {
            throw new MaterielInformatiqueException(ConstanteMetier.MSG_DATE_GARANTIE_NULL_EXCEPTION);
        }
        if (dateGarantie.isBefore(LocalDate.now())) {
            throw new MaterielInformatiqueException(ConstanteMetier.MSG_DATE_GARANTIE_PAST_EXCEPTION);
        }
        this.dateGarantie = dateGarantie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterielInformatique that = (MaterielInformatique) o;
        return Objects.equals(numSerie, that.numSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numSerie);
    }

    @Override
    public String toString() {
        return "MaterielInformatique{" +
                "numSerie='" + numSerie + '\'' +
                ", dateGarantie=" + dateGarantie +
                '}';
    }
}