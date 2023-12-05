package net.ent.etrs.poinsot.note.start;

import net.ent.etrs.poinsot.note.model.entities.Eleve;
import net.ent.etrs.poinsot.note.model.entities.Note;
import net.ent.etrs.poinsot.note.model.entities.exceptions.EleveException;
import net.ent.etrs.poinsot.note.model.entities.exceptions.NoteException;
import net.ent.etrs.poinsot.note.model.entities.exceptions.TestMapException;
import net.ent.etrs.poinsot.note.model.references.ConstanteMetier;
import net.ent.etrs.poinsot.note.model.references.Matiere;

import java.util.*;

public final class TestMap {
    private static Map<Eleve, Map<Matiere, List<Note>>> maMap = new HashMap<>();

    private TestMap() {
    }

    public static void main(String[] args) {
        try {
            initialiserMapEleve();

            afficher();
        } catch (TestMapException e) {
            e.printStackTrace();
        }
    }

    private static void afficher() {

    }

    private static Double calculerMoyenneEleve(Map<Matiere, List<Note>> map) {
        for (Map.Entry<Matiere, List<Note>> entry : map.entrySet()) {

        }
    }

    private static Double calculerMoyenneMatiere(List<Note> noteList) {
        Double moyenne = 0.0;
        int sommeCoeff = 0;

        for (Note n : noteList) {
            moyenne += (n.getValeur() * n.getCoeff() * 1.0);
            sommeCoeff += n.getCoeff();
        }

        moyenne /= (sommeCoeff * 1.0);
        return moyenne;
    }

    private static void initialiserMapEleve() throws TestMapException {
        try {
            Eleve ibo = new Eleve("123", "IBO", "Rosan");
            maMap.put(ibo, initialiserMatiere());
        } catch (EleveException e) {
            throw new TestMapException(ConstanteMetier.TEST_MAP_INITIALISER_MAP_ELEVE_EXCEPTION, e);
        }
    }

    private static Map<Matiere, List<Note>> initialiserMatiere() {
        Map<Matiere, List<Note>> mapMatiere = new HashMap<>();

        try {
            mapMatiere.put(Matiere.BDD, initNotes());
            mapMatiere.put(Matiere.COO, initNotes());
            mapMatiere.put(Matiere.HTML, initNotes());
            mapMatiere.put(Matiere.SQL, initNotes());
            mapMatiere.put(Matiere.JAVA, initNotes());
            mapMatiere.put(Matiere.ANASI, initNotes());
            mapMatiere.put(Matiere.PROJET, initNotes());
        } catch (TestMapException e) {
            throw new RuntimeException(e);
        }

        return mapMatiere;
    }

    private static List<Note> initNotes() throws TestMapException {
        List<Note> notes = new ArrayList<>();

        try {
            for (int i = 0; i < 4; i++) {
                Random randomNote = new Random();
                Random randomCoeff = new Random();
                Note n = null;
                n = new Note(randomNote.nextFloat(20), randomCoeff.nextInt(5));
                notes.add(n);
            }
            return notes;
        } catch (NoteException e) {
            throw new TestMapException(ConstanteMetier.TEST_MAP_INITIALISER_MAP_ELEVE_EXCEPTION, e);
        }
    }
}