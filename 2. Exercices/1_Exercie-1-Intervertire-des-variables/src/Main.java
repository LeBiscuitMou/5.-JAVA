public class Main {

    //Static permet l'accès aux données à toutes les instances de la classe
    static String nom = "marc";
    static String autreChaine = "autre texte";




    public static void main(String[] args) {

        //Echange des valeurs de chaines

        echange(nom, autreChaine);
        System.out.println("Bonjour " + nom);

    }

    private static void echange(String pnom, String pautreChaine) {
        // Déclaration d'une variable temporaire
        String temp;
        temp = pnom;
        nom = pautreChaine;
        autreChaine = temp;
    }
}
