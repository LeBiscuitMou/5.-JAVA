package net.ent.etrs.tpmap.start;


import net.ent.etrs.tpmap.entities.Eleve;
import net.ent.etrs.tpmap.entities.Matiere;
import net.ent.etrs.tpmap.entities.MatiereComparator;
import net.ent.etrs.tpmap.entities.Note;

import java.util.*;


public final class TestMap {

    private static Map<Eleve, Map<Matiere, List<Note>>> maMap = new TreeMap<>();

    public static void main(String[] args) {
        initialiserMapEleve();
        afficher();
    }

    private static void afficher() {
        //Je parcours l'ensemble des entrées de la map d'élèves
        for (Map.Entry<Eleve, Map<Matiere, List<Note>>> eleveMapEntry : maMap.entrySet()) {
            //J'affiche les infos de l'élève puis le calcul de sa moyenne générale
            System.out.println(String.format("%s %s %s %.2f", eleveMapEntry.getKey().getNid(), eleveMapEntry.getKey().getNom(), eleveMapEntry.getKey().getPrenom(), calculerMoyenneEleve(eleveMapEntry.getValue())));
            //Je parcours l'ensemble des entrées de la map de matières
            for (Map.Entry<Matiere, List<Note>> matiereListEntry : eleveMapEntry.getValue().entrySet()) {
                //J'affiche la matière puis le calcul de la moyenne de la matière
                System.out.println(String.format("\t%s : %.4f", matiereListEntry.getKey(), calculerMoyenneMatiere(matiereListEntry.getValue())));
                //Je parcours la liste des notes
                for (Note note : matiereListEntry.getValue()) {
                    //J'affiche la note avec son coeff
                    System.out.println(String.format("\t\t%.4f (coeff:%d)",
                            note.getValeur(),
                            note.getCoeff()));
                }

            }


        }


    }

    private static Double calculerMoyenneMatiere(List<Note> notes) {

        //somme des notes
        float somme = 0.0f;
        //somme des coeff
        float sommeCoeff = 0.0f;
        for (Note note : notes) {
            somme += note.getValeur() * note.getCoeff();
            sommeCoeff += note.getCoeff();
        }
        //renvoi du calcul de la moyenne
        return Double.valueOf(somme / sommeCoeff);

    }

    private static Double calculerMoyenneEleve(Map<Matiere, List<Note>> mapMatiere) {


        //somme des moyennes des matières
        double somme = 0.0;
        for (Map.Entry<Matiere, List<Note>> matiereListEntry : mapMatiere.entrySet()) {
            somme += calculerMoyenneMatiere(matiereListEntry.getValue());
        }

        //renvoi du calcul de la moyenne de l'élève
        return somme / mapMatiere.size();


    }

    private static void initialiserMapEleve() {
        Eleve e1 = new Eleve("123456789", "tintin", "tintin p");
        Eleve e2 = new Eleve("456789123", "serge", "jeanne");
        Eleve e3 = new Eleve("145632789", "olive", "tom");
        Eleve e4 = new Eleve("987563214", "ken", "barbie");
        Eleve e5 = new Eleve("954786321", "seiya", "saint");

        maMap.put(e1, initialiserMatiere());
        maMap.put(e2, initialiserMatiere());
        maMap.put(e3, initialiserMatiere());
        maMap.put(e4, initialiserMatiere());
        maMap.put(e5, initialiserMatiere());
    }

    private static Map<Matiere, List<Note>> initialiserMatiere() {
        Map<Matiere, List<Note>> mapMatiere = new TreeMap<>(new MatiereComparator());

        Random random = new Random();
        for (Matiere m : Matiere.values()) {
            if (random.nextBoolean()) {
                mapMatiere.put(m, initNotes());
            }
        }

        return mapMatiere;
    }

    private static List<Note> initNotes() {
        List<Note> notes1 = new ArrayList<>();

        notes1.add(new Note((new Random().nextInt(20)) + (new Random().nextFloat()), new Random().nextInt(8) + 1));
        notes1.add(new Note((new Random().nextInt(20)) + (new Random().nextFloat()), new Random().nextInt(8) + 1));
        notes1.add(new Note((new Random().nextInt(20)) + (new Random().nextFloat()), new Random().nextInt(8) + 1));
        notes1.add(new Note((new Random().nextInt(20)) + (new Random().nextFloat()), new Random().nextInt(8) + 1));
        return notes1;
    }
}
