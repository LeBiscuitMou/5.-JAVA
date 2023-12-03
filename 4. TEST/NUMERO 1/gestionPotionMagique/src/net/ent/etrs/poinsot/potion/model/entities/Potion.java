package net.ent.etrs.poinsot.potion.model.entities;

import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionDegatException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionException;
import net.ent.etrs.poinsot.potion.model.entities.exceptions.PotionVieException;
import net.ent.etrs.poinsot.potion.model.references.ConstanteMetier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Potion {
    private String nom;
    private int volume;
    private Contenant contenant;
    private List<Ingredient> lesIngredients = new ArrayList<>();

    public Potion(String nom, int volume, Contenant contenant) throws PotionException {
        this.setNom(nom);
        this.setVolume(volume);
        this.setContenant(contenant);
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws PotionException {
        if (Objects.isNull(nom)) {
            throw new PotionException(ConstanteMetier.POTION_NOM_IS_NULL);
        }
        if (nom.isBlank()) {
            throw new PotionException(ConstanteMetier.POTION_NOM_IS_BLANK);
        }
        this.nom = nom;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) throws PotionException {
        if (volume < 0) {
            throw new PotionException(ConstanteMetier.POTION_VOLUME_IS_NEGATIVE);
        }
        if (volume > contenant.getVolume()) {
            throw new PotionException(ConstanteMetier.POTION_VOLUME_SUPERIEUR_CONTENANT);
        }
        this.volume = volume;
    }

    public Contenant getContenant() {
        return contenant;
    }

    public void setContenant(Contenant contenant) throws PotionException {
        if (Objects.isNull(contenant)) {
            throw new PotionException(ConstanteMetier.POTION_CONTENANT_IS_NULL);
        }
        this.contenant = contenant;
    }

    public List<Ingredient> getLesIngredients() {
        return Collections.unmodifiableList(lesIngredients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potion potion = (Potion) o;
        return Objects.equals(nom, potion.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return "Potion{" +
                "nom='" + nom + '\'' +
                ", volume=" + volume +
                ", contenant=" + contenant +
                '}';
    }

    public abstract int effetPotion() throws PotionVieException, PotionDegatException;
    public abstract boolean estFinie();

    public void ajouterIngredient(Ingredient ingredient) throws PotionException {
        if (Objects.isNull(ingredient)) {
            throw new PotionException(ConstanteMetier.INGREDIENT_IS_NULL);
        }
        if (estFinie()) {
            throw new PotionException(ConstanteMetier.POTION_TERMINEE);
        }
        this.lesIngredients.add(ingredient);
    }
}