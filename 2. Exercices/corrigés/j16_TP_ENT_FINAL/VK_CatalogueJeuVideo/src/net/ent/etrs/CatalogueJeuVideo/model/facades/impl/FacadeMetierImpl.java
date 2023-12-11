package net.ent.etrs.CatalogueJeuVideo.model.facades.impl;

import net.ent.etrs.CatalogueJeuVideo.model.dao.*;
import net.ent.etrs.CatalogueJeuVideo.model.dao.exceptions.DaoException;
import net.ent.etrs.CatalogueJeuVideo.model.dao.impl.DaoFactory;
import net.ent.etrs.CatalogueJeuVideo.model.entities.*;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.BusinessException;
import net.ent.etrs.CatalogueJeuVideo.model.exceptions.EntitiesException;
import net.ent.etrs.CatalogueJeuVideo.model.facades.FacadeMetier;
import net.ent.etrs.CatalogueJeuVideo.model.references.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {
    /* ******************************** VARIABLES ******************************** */
    IDaoJeuVideo daoJeuVideo = DaoFactory.fabriquerJeuVideoDao();
    IDaoConsole daoConsole = DaoFactory.fabriquerConsoleDao();
    IDaoFabriquant daoFabriquant = DaoFactory.fabriquerFabriquantDao();

    /* ******************************* CONSTRUCTOR ******************************* */
    protected FacadeMetierImpl() {

    }

    /* ******************************** FONCTIONS ******************************** */
    /**
     * Permet de sauvegarder un jeu video
     *
     * @param jv le jeu vidfeo à sauvegarder
     * @return le jeu video sauvegarder
     */
    @Override
    public JeuVideo sauvergarderJeuVideo(JeuVideo jv) throws BusinessException {
        try {
            if (Objects.isNull(jv)){
                throw new BusinessException(ConstErrMsg.JEU_VIDEO_NULL);
            }
            return daoJeuVideo.save(jv);
        } catch (DaoException | BusinessException e) {
            throw new BusinessException(ConstErrMsg.JEU_VIDEO_SAUVEGARDE, e);
        }
    }

    /**
     * Permet de sauvegarder un fabriquant
     *
     * @param fabriquant le fabriquant à sauvegarder
     * @return le fabriquant sauvegarder
     */
    @Override
    public Fabriquant sauvegarderFabriquant(Fabriquant fabriquant) throws BusinessException {
        try {
            if (Objects.isNull(fabriquant)){
                throw new BusinessException(ConstErrMsg.FABRICANT_NULL);
            }
            return daoFabriquant.save(fabriquant);
        } catch (DaoException | BusinessException e) {
            throw new BusinessException(ConstErrMsg.FABRIQUANT_SAUVEGARDE, e);
        }
    }

    /**
     * Permet de sauvegarder une console
     *
     * @param console la console à sauvegarder
     * @return la console sauvegarder
     */
    @Override
    public Console sauvegarderConsole(Console console) throws BusinessException {
        try {
            if (Objects.isNull(console)){
                throw new BusinessException(ConstErrMsg.CONSOLE_NULL);
            }
            return daoConsole.save(console);
        } catch (DaoException | BusinessException e) {
            throw new BusinessException(ConstErrMsg.CONSOLE_SAUVEGARDE, e);
        }
    }

    /**
     * Permet de récupérer tous les fabriquant
     *
     * @return la liste de tous les fabriquant
     */
    @Override
    public List<Fabriquant> recupererFabriquants() throws BusinessException {
        List<Fabriquant> list = new ArrayList<>();
        try {
            daoFabriquant.findAll().iterator().forEachRemaining(list::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstErrMsg.FABRIQUANT_RECUPERER, e);
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * Permet de récupérer toutes les consoles
     *
     * @return la liste de toutes les console
     */
    @Override
    public List<Console> recupererConsole() throws BusinessException {
        List<Console> list = new ArrayList<>();
        try {
            daoConsole.findAll().iterator().forEachRemaining(list::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstErrMsg.CONSOLES_RECUPERER, e);
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * Permet de récuperer tous les jeux video
     *
     * @return la liste de tous les jeux video
     */
    @Override
    public List<JeuVideo> recupererJeuVideo() throws BusinessException {
        List<JeuVideo> list = new ArrayList<>();
        try {
            daoJeuVideo.findAll().iterator().forEachRemaining(list::add);
        } catch (DaoException e) {
            throw new BusinessException(ConstErrMsg.JEUX_VIDEO_RECUPERER, e);
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * Permet de récuperer tous les jeux video du genre choisi
     *
     * @param genre le genre choisi
     * @return la liste des jeux video de ce genre
     */
    @Override
    public List<JeuVideo> recupererJeuVideoParGenre(Genre genre) throws BusinessException {
        if(Objects.isNull(genre)){
            throw new BusinessException(ConstErrMsg.GENRE_NULL);
        }
        return Collections.unmodifiableList(daoJeuVideo.getJeuVideoParGenres(genre));
    }

    /**
     * Permet de récupérer un dictionnaire contenant toutes les consoles avec leurs jeux video
     * @return une map contenant toutes les consoles avec leurs jeux video
     */
    @Override
    public Map<Console, List<JeuVideo>> recupererConsoleAvecLeurJeuxVideo() throws BusinessException {
        try {
            Map<Console, List<JeuVideo>> map = new HashMap<>();
            for(Console mE : daoConsole.findAll()){
                map.put(mE, new ArrayList<>());
            }
            for(JeuVideo jeu : daoJeuVideo.findAll()){
                for(Console console : jeu.getPlateformes()){
                    map.get(console).add(jeu);
                }
            }
            return map;
        } catch (DaoException e) {
            throw new BusinessException(ConstErrMsg.DATABASE_ACCESS, e);
        }
    }

    /**
     * Permet d'initialisaer les données du logiciel
     *
     * @param init liste de chaine de caractères contenant les données d'initilisation
     */
    @Override
    public void initialisation(List<String> init) throws BusinessException {
        // préparation des données d'initialisation
        List<String[]> listJeu = new ArrayList<>();
        List<String[]> listConsole = new ArrayList<>();
        for(String text : init){
            if(text.toUpperCase().startsWith("JEU")){
                listJeu.add(text.split(";"));
            }
            if(text.toUpperCase().startsWith("CONSOLE")){
                listConsole.add(text.split(";"));
            }
        }

        // fabrique le tout
        List<Fabriquant> fabricants = new ArrayList<>();
        for(String[] tab : listJeu){
            createAndSaveJeuVideoInit(fabricants, tab);
        }
        for(String[] tab : listConsole){
            createAndSaveConsoleInit(fabricants, tab);
        }
    }

    /**
     * Met à jour un jeu vidéo
     *
     * @param jeu le jeu vidéo à mettre à jour
     */
    @Override
    public void modifierJeuVideo(JeuVideo jeu) throws BusinessException {
        try {
            daoJeuVideo.delete(jeu.getId());
            daoJeuVideo.save(jeu);
        } catch (DaoException e) {
            throw new BusinessException(ConstErrMsg.JEU_VIDEO_UPDATE, e);
        }
    }


    /**
     * Crée un fabricant à partir de données stocké dans un tableau et le sauvegarde dans la base de données.
     *
     * @param data un tableau contenant les données du fabricant à créer
     * @param fabriquantList une liste de fabricant à remplir et utiliser
     * @return l'index du fabricant crée.
     * @throws BusinessException l'exception lancée
     */
    private int createAndSaveFabriquantInit(List<Fabriquant> fabriquantList, String[] data) throws BusinessException {
        try {
            // data [nom, date, pays]
            // si fabricant crée, on retourne son index dans la liste donné
            for(int i = 0; i < fabriquantList.size() ; i++){
                if (fabriquantList.get(i).getNom().equals(data[0])){
                    return i;
                }
            }

            // si fabricant pas encore fabriqué, on le fabrique, on l'ajoute dans la liste, et on retourne son index
            fabriquantList.add(sauvegarderFabriquant(EntitiesFactory.fabriquerFabriquant(
                    data[0],
                    LocalDate.parse(data[1], DateTimeFormatter.ofPattern(ConstMetier.DATE_PATTERN)),
                    Pays.valueOf(data[2].toUpperCase())
            )));
            return fabriquantList.size()-1;
        } catch (EntitiesException e) {
            throw new BusinessException(ConstErrMsg.INITIALISATION_FAIL, e);
        }
    }


    /**
     * Crée et sauvegarde dans la base de données les jeux vidéo et les fabricants qui leur sont associés.
     *
     * @param fabriquantList une liste de fabricant à remplir et utiliser
     * @param data les données du jeu vidéo à enregistrer
     * @throws BusinessException INITIALISATION_FAIL exception
     */
    private void createAndSaveJeuVideoInit(List<Fabriquant> fabriquantList, String[] data) throws BusinessException {
        //("JEU;Valorant;02/06/2020;FPS;Riot Games;22/09/2006;USA")
        int indexFab = createAndSaveFabriquantInit(fabriquantList, new String[]{data[4], data[5], data[6]});

        try {
            sauvergarderJeuVideo(EntitiesFactory.fabriquerJeuVideo(
                    data[1],
                    LocalDate.parse(data[2], DateTimeFormatter.ofPattern(ConstMetier.DATE_PATTERN)),
                    Genre.valueOf(data[3].toUpperCase()),
                    fabriquantList.get(indexFab)));
        } catch (EntitiesException e) {
            throw new BusinessException(ConstErrMsg.INITIALISATION_FAIL, e);
        }
    }

    /**
     * Crée et sauvegarde dans la base de données les consoles et les fabricants qui leur sont associés.
     *
     * @param fabriquantList une liste de fabricant à remplir et utiliser
     * @param data les données de la console à enregistrer
     * @throws BusinessException INITIALISATION_FAIL exception
     */
    private void createAndSaveConsoleInit(List<Fabriquant> fabriquantList, String[] data) throws BusinessException {
        //("CONSOLE;Playstation;SONY;16/11/1993;USA;JAPON;03/12/1994;USA;09/09/1995;FRANCE;29/09/1995")
        int indexFab = createAndSaveFabriquantInit(fabriquantList, new String[]{data[2], data[3], data[4]});

        HashMap<Pays, LocalDate> map = new HashMap<>();
        for (int i = 5; i < data.length; i+=2) {
            map.put(Pays.valueOf(data[i].toUpperCase()),
                    LocalDate.parse(data[i+1], DateTimeFormatter.ofPattern(ConstMetier.DATE_PATTERN)));
        }

        try {
            sauvegarderConsole(EntitiesFactory.fabriquerConsole(
                    data[1],
                    fabriquantList.get(indexFab),
                    map));
        } catch (EntitiesException e) {
            throw new BusinessException(ConstErrMsg.INITIALISATION_FAIL, e);
        }
    }
}
