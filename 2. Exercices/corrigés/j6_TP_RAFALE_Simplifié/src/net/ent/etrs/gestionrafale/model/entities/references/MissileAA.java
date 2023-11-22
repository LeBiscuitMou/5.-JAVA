package net.ent.etrs.gestionrafale.model.entities.references;

public enum MissileAA {

    AA_MICA("anti-aérien MICA", 112, CodeOTAN.FOX2),
    AA_METEOR("Meteor (BVRAAM)", 185, CodeOTAN.FOX3),
    AA_R550_MAGIC_2("R550 MK2 Magic 2", 89, CodeOTAN.FOX2),
    SUPER_530("Super 530", 250, CodeOTAN.FOX1);

    /**
     * Nom du missile anti-aérien
     */
    private final String libelle;
    /**
     * Poids du missile en kg
     */
    private final int poids;
    /**
     * Catégorie du missileen nomenclature OTANienne
     */
    private final CodeOTAN nomenclatureOTAN;

    MissileAA(String libelle, int poids, CodeOTAN nomenclatureOTAN) {
        this.libelle = libelle;
        this.poids = poids;
        this.nomenclatureOTAN = nomenclatureOTAN;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getPoids() {
        return poids;
    }

    public CodeOTAN getNomenclatureOTAN() {
        return nomenclatureOTAN;
    }
}
