package net.ent.etrs.model.entities;

import net.ent.etrs.model.entities.exceptions.MaterielInformatiqueException;
import net.ent.etrs.model.entities.references.Constantes;

import java.time.LocalDate;
import java.util.Objects;


public class MaterielInformatique {


    private String numSerie;


    private LocalDate dateGarantie;

    protected MaterielInformatique() {
    }

    protected MaterielInformatique(final String numSerie, final LocalDate dateGarantie) throws MaterielInformatiqueException {
        setNumSerie(numSerie);
        setDateGarantie(dateGarantie);
    }

    public String getNumSerie() {
        return numSerie;
    }

    public LocalDate getDateGarantie() {
        return dateGarantie;
    }

    private void setNumSerie(final String numSerie) throws MaterielInformatiqueException {
        if(Objects.isNull(numSerie)){
            throw new MaterielInformatiqueException(Constantes.MSG_NUM_SERIE_NULL_EXCEPTION);
        }
        if (numSerie.length() != Constantes.LONGUEUR_NUM_SERIE){
            throw new MaterielInformatiqueException(Constantes.MSG_NUM_SERIE_LENGTH_EXCEPTION);
        }
        this.numSerie = (String.format("%s_%s",this.getClass().getSimpleName(),numSerie));
    }

    public void setDateGarantie(final LocalDate dateGarantie) throws MaterielInformatiqueException {
        if (Objects.isNull(dateGarantie)){
            throw new MaterielInformatiqueException(Constantes.MSG_DATE_GARANTIE_NULL_EXCEPTION);
        }
        if (dateGarantie.isBefore(LocalDate.now())){
            throw new MaterielInformatiqueException(Constantes.MSG_DATE_GARANTIE_PAST_EXCEPTION);
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
