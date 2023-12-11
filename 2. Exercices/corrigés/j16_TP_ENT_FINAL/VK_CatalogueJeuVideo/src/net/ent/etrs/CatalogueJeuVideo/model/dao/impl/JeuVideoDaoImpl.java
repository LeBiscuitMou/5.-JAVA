package net.ent.etrs.CatalogueJeuVideo.model.dao.impl;

import net.ent.etrs.CatalogueJeuVideo.model.dao.IDaoJeuVideo;
import net.ent.etrs.CatalogueJeuVideo.model.entities.JeuVideo;
import net.ent.etrs.CatalogueJeuVideo.model.references.Genre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuVideoDaoImpl extends MemBaseDao<JeuVideo> implements IDaoJeuVideo {

    protected JeuVideoDaoImpl() {
    }

    @Override
    public List<JeuVideo> getJeuVideoParGenres(Genre genre) {
        List<JeuVideo> list = new ArrayList<>();
        for(JeuVideo jeu : persist.values()){
            if(jeu.getGenre().equals(genre)){
                list.add(jeu);
            }
        }
        return Collections.unmodifiableList(list);
    }
}
