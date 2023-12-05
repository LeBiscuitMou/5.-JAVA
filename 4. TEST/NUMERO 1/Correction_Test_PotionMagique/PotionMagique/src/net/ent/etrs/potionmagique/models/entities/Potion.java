package net.ent.etrs.potionmagique.models.entities;

import net.ent.etrs.potionmagique.models.entities.exceptions.PotionException;
import net.ent.etrs.potionmagique.models.entities.references.ConstanteMetier;
import net.ent.etrs.potionmagique.models.entities.references.Contenant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Potion {

    protected List<Ingredient> lesIngredients = new ArrayList<>();
    private String nom;
    private Integer volume;
    private Contenant contenant;

    public Potion(String nom, Integer volume, Contenant contenant) throws PotionException {
        this.setNom(nom);
        this.setContenant(contenant);
        this.setVolume(volume);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws PotionException {
        if (Objects.isNull(nom)) {
            throw new PotionException(ConstanteMetier.POTION_NOM_NULL);
        }
        if (nom.isBlank()) {
            throw new PotionException(ConstanteMetier.POTION_NOM_VIDE);
        }
        this.nom = nom;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) throws PotionException {
        if (Objects.isNull(volume)) {
            throw new PotionException(ConstanteMetier.POTION_VOLUME_NULL);
        }
        if (volume <= 0) {
            throw new PotionException(ConstanteMetier.POTION_VOLUME_POSITIF);
        }
        if (volume > this.contenant.getVolume()) {
            throw new PotionException(ConstanteMetier.POTION_VOLUME_CONTENANT_UNSUPPORTED);
        }

        this.volume = volume;
    }

    public Contenant getContenant() {
        return contenant;
    }

    public void setContenant(Contenant contenant) throws PotionException {
        if (Objects.isNull(contenant)) {
            throw new PotionException(ConstanteMetier.POTION_CONTENANT_NULL);
        }
        //TODO en fonction de si on test le contenant avant le volume ou l'inverse
//        if (contenant.getVolume() < this.volume) {
//            throw new PotionException(ConstanteMetier.POTION_CONTENANT_VOLUME_INCORRECT);
//        }
        this.contenant = contenant;
    }

    /**
     * Renvoie les effect de la potion
     *
     * @return les effets de la potion
     */
    public abstract String effectPotion();

    /**
     * Permet d'ajouter un ingrédient à la Potion
     *
     * @param lIngredient l'ingrédient qui est rajouté
     */
    public abstract void ajouterIngredient(Ingredient lIngredient) throws PotionException;

    public List<Ingredient> getLesIngredients() {
        return Collections.unmodifiableList(this.lesIngredients);
    }

    /**
     * Permet de savoir si la Potion est complète
     *
     * @return si la potion est complète ou non
     */
    public abstract boolean estFinie();

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
}
