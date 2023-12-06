package net.ent.etrs.model.entities.references;

public enum TypeOrdinateur {
    BUR("Bureautique"),
    DEV("Développement"),
    SIMU("Simulation"),
    OPS("Opération");

    private final String libelle;

    TypeOrdinateur(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public static TypeOrdinateur getTypeOrdinateurByLibelle(String libelle){
        for (TypeOrdinateur typeOrdinateur : TypeOrdinateur.values()){
            if(typeOrdinateur.getLibelle().equals(libelle)){
                return typeOrdinateur;
            }
        }
        return null;
    }
}
