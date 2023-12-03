package view;

/**
 * Classe abstraite d'ihm qui doit permettre de réaliser des affichage et des saisies.
 */
public abstract class AbstractIhm implements Ihm{
    @Override
    public abstract void afficher(String msg);

    @Override
    public abstract int saisirEntier(String msg);

    /**
     * Méthode chargée de réaliser la saisie d'un entier appartenant à unt intervalle[mini:maxi].
     * @param msg:String, le message
     * @param mini: int, le minimum attendu
     * @param maxi: le maximum attendu
     * @return int, l'entier saisi
     */
    @Override
    public  int saisirEntierBorne(String msg, int mini, int maxi)  {
        int nbSaisi = -1;
        boolean ok=false;
        do{
            nbSaisi = saisirEntier(msg);
            if(nbSaisi<mini || nbSaisi>maxi){
                afficher("ERR: Nombre incorrect hors de ["+mini+":"+maxi+"]");
            }else{
                ok=true;
            }

        }while(!ok);
        return nbSaisi;
    }
}
