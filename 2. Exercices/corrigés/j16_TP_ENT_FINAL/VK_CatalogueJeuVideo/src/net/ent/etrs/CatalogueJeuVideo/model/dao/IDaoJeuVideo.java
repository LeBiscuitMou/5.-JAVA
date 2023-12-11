package net.ent.etrs.CatalogueJeuVideo.model.dao;

import net.ent.etrs.CatalogueJeuVideo.model.entities.JeuVideo;
import net.ent.etrs.CatalogueJeuVideo.model.references.Genre;

import java.util.List;

public interface IDaoJeuVideo extends BaseDao<JeuVideo>{
    List<JeuVideo> getJeuVideoParGenres(Genre genre);
}
