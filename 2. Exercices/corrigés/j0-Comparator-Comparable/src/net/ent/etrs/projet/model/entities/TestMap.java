package net.ent.etrs.projet.model.entities;

import net.ent.etrs.projet.model.entities.comparator.MatiereComparator;
import net.ent.etrs.projet.model.exceptions.EleveException;
import net.ent.etrs.projet.model.exceptions.NoteException;
import net.ent.etrs.projet.model.references.ConstMetier;
import net.ent.etrs.projet.model.references.Matiere;
import net.ent.etrs.projet.vues.commons.utils.AffichageConsole;

import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.*;

public class TestMap {
    /* ******************************** VARIABLES ******************************** */
    private Map<Eleve, Map<Matiere, List<Note>>> maMap;
    private Random rand = new Random();
    /* ******************************* CONSTRUCTOR ******************************* */
    public TestMap() {
        initialiserMapEleve();
    }
    /* ********************************* GETTERS ********************************* */

    /* ********************************* SETTERS ********************************* */

    /* ******************************** FONCTIONS ******************************** */
    public void exec(){
        afficher();
    }
    /* **************************** PRIVATE FUNCTIONS **************************** */
    private void afficher(){
        StringBuilder message = new StringBuilder();
        Set<Eleve> eleveSet = maMap.keySet();
        for (Eleve eleve:eleveSet) {
            Map<Matiere, List<Note>> notesEleve = maMap.get(eleve);

            message.append(String.format("%s %.2f\n", eleve.toString(), calculerMoyenneEleve(notesEleve)));

            for (Matiere mat: notesEleve.keySet()) {
                List<Note> noteList = notesEleve.get(mat);
                if(noteList.isEmpty()){
                    continue;
                }

                message.append(String.format("%s%s : %.4f\n", ConstMetier.BLANC, mat.name(), calculerMoyenneMatiere(noteList)));
                for (Note n: noteList){
                    message.append(String.format("%s%s\n",ConstMetier.BLANC.repeat(2), n.toString()));
                }
            }
        }
        AffichageConsole.afficherMessageAvecSautLigne(message.toString());
    }
    private double calculerMoyenneEleve(Map<Matiere, List<Note>> notesEleve){
        float sommeNoteCoeff = 0;
        int sommeCoeff = 0;
        for (Matiere mat: notesEleve.keySet()) {
            List<Note> noteList = notesEleve.get(mat);
            if(noteList.isEmpty()){
                continue;
            }

            for (Note n: noteList){
                sommeNoteCoeff += n.getValeur() * n.getCoeff();
                sommeCoeff += n.getCoeff();
            }
        }

        if(sommeCoeff == 0){
            return 0;
        }
        return sommeNoteCoeff/sommeCoeff;
    }

    private double calculerMoyenneMatiere(List<Note> noteList){
        float sommeNoteCoeff = 0;
        int sommeCoeff = 0;

        for (Note n: noteList){
            sommeNoteCoeff += n.getValeur() * n.getCoeff();
            sommeCoeff += n.getCoeff();
        }

        if(sommeCoeff == 0){
            return 0;
        }
        return sommeNoteCoeff/sommeCoeff;
    }

    private void initialiserMapEleve(){
        maMap = new TreeMap<>();
        try {
            Eleve patrick = new Eleve("548326578", "l'étoile", "patrick");
            maMap.put(patrick, initialiserMatiere());

            Eleve varin = new Eleve("425836578", "varin", "kévin");
            maMap.put(varin, initialiserMatiere());

            Eleve nzomononucleose = new Eleve("125486537", "nzomononucleose", "inès");
            maMap.put(nzomononucleose, initialiserMatiere());
        } catch (EleveException e) {
            throw new RuntimeException(e);
        }
    }

    private  Map<Matiere, List<Note>> initialiserMatiere(){
        Map<Matiere, List<Note>> matiereMap = new TreeMap<>(new MatiereComparator());
        for (Matiere mat: Matiere.values()) {
            matiereMap.put(mat, initNotes());
        }
        return matiereMap;
    }

    private List<Note> initNotes(){
        List<Note> noteList = new ArrayList<>();
        for(int i = 0 ; i < rand.nextInt(2, 6); i++){
            try {
                noteList.add(new Note(rand.nextFloat(5, 20), rand.nextInt(1, 4)));
            } catch (NoteException e) {
                throw new RuntimeException(e);
            }
        }
        return noteList;
    }

}
