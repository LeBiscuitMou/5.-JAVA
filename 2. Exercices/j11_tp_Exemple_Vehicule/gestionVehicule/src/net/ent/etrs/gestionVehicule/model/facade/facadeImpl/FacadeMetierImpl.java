package net.ent.etrs.gestionVehicule.model.facade.facadeImpl;

import net.ent.etrs.gestionVehicule.model.entities.Vehicule;
import net.ent.etrs.gestionVehicule.model.facade.FacadeMetier;
import net.ent.etrs.gestionVehicule.model.facade.exceptions.FacadeMetierException;
import net.ent.etrs.gestionVehicule.model.references.ConstanteMetier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FacadeMetierImpl implements FacadeMetier {
    private List<Vehicule> persistanceVehicule = new ArrayList<>();

    @Override
    public Vehicule sauvegarderVehicule(Vehicule v) throws FacadeMetierException {
        if (Objects.isNull(v)) {
            throw new FacadeMetierException(ConstanteMetier.FACADE_ERROR_SVG_VEHICULE);
        }
        if (this.persistanceVehicule.contains(v)) {
            throw new FacadeMetierException(ConstanteMetier.FACADE_ERROR_VEHICULE_ALREADY_EXIST);
        }
        this.persistanceVehicule.add(v);
        return v;
    }

    @Override
    public List<Vehicule> recupererTousVehicule() {
        return Collections.unmodifiableList(this.persistanceVehicule);
    }

    @Override
    public List<Vehicule> recupererTousVhlSortieAvant(LocalDate dateSortie) {
        List<Vehicule> retour = new ArrayList<>();
        for (Vehicule v: this.persistanceVehicule) {
            if(v.getDateDeSortie().isBefore(dateSortie)){
                retour.add(v);
            }
        }
        return retour;
    }

    @Override
    public List<Vehicule> recupererTousVhlConsoSuperieur(float valeur) throws FacadeMetierException {
        if (valeur < 0) {
            throw new FacadeMetierException(ConstanteMetier.FACADE_ERROR_VHL_CONSO);
        }
        List<Vehicule> retour = new ArrayList<>();
        for (Vehicule v : this.persistanceVehicule) {
            if (v.getConsommation() > valeur) {
                retour.add(v);
            }
        }
        return retour;
    }

    @Override
    public void supprimerVehicule(Vehicule v) throws FacadeMetierException {
        if (Objects.isNull(v)) {
            throw new FacadeMetierException(ConstanteMetier.FACADE_ERROR_SVG_VEHICULE);
        }
        if (!this.persistanceVehicule.contains(v)) {
            throw new FacadeMetierException(ConstanteMetier.FACADE_ERROR_VEHICULE_NOT_EXIST);
        }
        this.persistanceVehicule.remove(v);
    }
}
