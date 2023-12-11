package net.ent.etrs.gestionJeuxVideo.models.facade.impl;

import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoBase;
import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoConsole;
import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoFabriquant;
import net.ent.etrs.gestionJeuxVideo.models.dao.IDaoJeuVideo;
import net.ent.etrs.gestionJeuxVideo.models.dao.exceptions.DaoException;
import net.ent.etrs.gestionJeuxVideo.models.dao.impl.DaoFactory;
import net.ent.etrs.gestionJeuxVideo.models.entities.Console;
import net.ent.etrs.gestionJeuxVideo.models.entities.Fabriquant;
import net.ent.etrs.gestionJeuxVideo.models.entities.JeuVideo;
import net.ent.etrs.gestionJeuxVideo.models.facade.FacadeMetier;
import net.ent.etrs.gestionJeuxVideo.models.facade.exceptions.BusinessException;
import net.ent.etrs.gestionJeuxVideo.models.references.ConstanteMetier;
import net.ent.etrs.gestionJeuxVideo.models.references.Genre;

import java.util.*;

public class FacadeMetierImpl implements FacadeMetier {
    IDaoJeuVideo daoJeuVideo = DaoFactory.fabriquerDaoJeuVideo();
    IDaoConsole daoConsole = DaoFactory.fabriquerDaoConsole();
    IDaoFabriquant daoFabriquant = DaoFactory.fabriquerDaoFabriquant();

    protected FacadeMetierImpl() {
    }

    @Override
    public JeuVideo sauvergarderJeuVideo(JeuVideo jv) throws BusinessException {
        try {
            if (Objects.isNull(jv)) {
                throw new BusinessException(ConstanteMetier.FACADEMETIER_JV_NULL);
            }
            daoJeuVideo.save(jv);
            return jv;
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADEMETIER_ERROR_DAO, e);
        }
    }

    @Override
    public Fabriquant sauvegarderFabriquant(Fabriquant fabriquant) throws BusinessException {
        try {
            if (Objects.isNull(fabriquant)) {
                throw new BusinessException(ConstanteMetier.FACADEMETIER_FABRIQUANT_NULL);
            }
            daoFabriquant.save(fabriquant);
            return fabriquant;
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADEMETIER_ERROR_DAO, e);
        }
    }

    @Override
    public Console sauvegarderConsole(Console console) throws BusinessException {
        try {
            if (Objects.isNull(console)) {
                throw new BusinessException(ConstanteMetier.FACADEMETIER_CONSOLE_NULL);
            }
            daoConsole.save(console);
            return console;
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADEMETIER_ERROR_DAO, e);
        }
    }

    @Override
    public List<Fabriquant> recupererFabriquants() throws BusinessException {
        try {
            List<Fabriquant> fabriquantList = new ArrayList<>();
            daoFabriquant.findAll().iterator().forEachRemaining(fabriquantList::add);
            return Collections.unmodifiableList(fabriquantList);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADEMETIER_ERROR_DAO, e);
        }
    }

    @Override
    public List<Console> recupererConsole() throws BusinessException {
        try {
            List<Console> consoleList = new ArrayList<>();
            daoConsole.findAll().iterator().forEachRemaining(consoleList::add);
            return Collections.unmodifiableList(consoleList);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADEMETIER_ERROR_DAO, e);
        }
    }

    @Override
    public List<JeuVideo> recupererJeuVideo() throws BusinessException {
        try {
            List<JeuVideo> jeuVideoList = new ArrayList<>();
            daoJeuVideo.findAll().iterator().forEachRemaining(jeuVideoList::add);
            return Collections.unmodifiableList(jeuVideoList);
        } catch (DaoException e) {
            throw new BusinessException(ConstanteMetier.FACADEMETIER_ERROR_DAO, e);
        }
    }

    @Override
    public List<JeuVideo> recupererJeuVideoParGenre(Genre genre) throws BusinessException {

    }

    @Override
    public Map<Console, List<JeuVideo>> recupererConsoleAvecLeurJeuxVideo() throws BusinessException {
        return null;
    }

    @Override
    public void initialisation(List<String> init) throws BusinessException {

    }
}