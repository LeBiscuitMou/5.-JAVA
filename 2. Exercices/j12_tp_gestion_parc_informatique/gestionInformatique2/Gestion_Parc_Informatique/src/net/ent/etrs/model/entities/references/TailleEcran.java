package net.ent.etrs.model.entities.references;

public enum TailleEcran {
    P19(19),
    P21(21),
    P22(22);

    private final int taille;

    TailleEcran(int taille) {
        this.taille = taille;
    }

    public int getTaille() {
        return taille;
    }

    /**
     * Renvoie la taille suivie de " pouces".
     * @return le libelle de la taille (ex: 19 pouces).
     */
    public String getLibelle(){
        return this.getTaille()+" pouces";
    }

    public static TailleEcran getTTailleEcranByLibelle(String libelle){
        for (TailleEcran tailleEcran : TailleEcran.values()){
            if(tailleEcran.getLibelle().equals(libelle)){
                return tailleEcran;
            }
        }
        return null;
    }

}
