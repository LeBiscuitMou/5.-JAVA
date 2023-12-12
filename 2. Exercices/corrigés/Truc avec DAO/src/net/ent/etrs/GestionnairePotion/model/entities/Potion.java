package net.ent.etrs.GestionnairePotion.model.entities;

import net.ent.etrs.GestionnairePotion.model.exceptions.*;
import net.ent.etrs.GestionnairePotion.model.references.ConstErrMsg;
import net.ent.etrs.GestionnairePotion.model.references.ConstMetier;
import net.ent.etrs.GestionnairePotion.model.references.Contenant;
import net.ent.etrs.GestionnairePotion.model.utils.StringVerif;
import net.ent.etrs.GestionnairePotion.model.utils.exceptions.StringVerifException;

import java.util.*;

public abstract class Potion extends AbstractEntity {
    /* ******************************** VARIABLES ******************************** */
    private String nom;
    private Contenant contenant;
    private int volume;
    /* ******************************* CONSTRUCTOR ******************************* */
    protected Potion(String nom, int volume, Contenant contenant) throws PotionException {
        this.setNom(nom);
        this.setContenant(contenant);
        this.setVolume(volume);
    }
    /* ********************************* GETTERS ********************************* */
    public String getNom() {
        return nom;
    }

    public int getVolume() {
        return volume;
    }

    public Contenant getContenant() {
        return contenant;
    }

    public abstract String getEffet() throws PotionDeDegatException;

    public abstract List<Ingredient> getIngredientList();
    /* ********************************* SETTERS ********************************* */
    private void setNom(String nom) throws PotionException {
        try {
            StringVerif.verifierStringAvecMaximum(nom, ConstMetier.NOM_MAX_SIZE);
        } catch (StringVerifException e) {
            throw new PotionException(ConstErrMsg.POTION_NOM_INVALIDE ,e);
        }
        this.nom = nom;
    }

    private void setVolume(int volume) throws PotionException {
        if (volume < 0){
            throw new PotionException(ConstErrMsg.POTION_VOLUME_INVALIDE);
        }
        if (volume > contenant.getVolume()){
            throw new PotionException(ConstErrMsg.POTION_VOLUME_INVALIDE);
        }
        this.volume = volume;
    }

    private void setContenant(Contenant contenant) throws PotionException {
        if (Objects.isNull(contenant)){
            throw new PotionException(ConstErrMsg.POTION_CONTENANT_NULL);
        }
        this.contenant = contenant;
    }
    /* ******************************** FONCTIONS ******************************** */
    public abstract void ajouterIngredient(Ingredient ingredientAjoute) throws PotionDeDegatException, PotionDeVieException, PotionAmeliorationException;

    public abstract boolean isReady();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Potion potion)) return false;
        return getVolume() == potion.getVolume() && Objects.equals(getNom(), potion.getNom()) && getContenant() == potion.getContenant();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getContenant(), getVolume());
    }

    @Override
    public String toString() {
        return "Potion{" +
                "nom='" + nom + '\'' +
                ", volume=" + volume +
                ", contenant=" + contenant +
                '}';
    }
    /* **************************** PRIVATE FUNCTIONS **************************** */
}
