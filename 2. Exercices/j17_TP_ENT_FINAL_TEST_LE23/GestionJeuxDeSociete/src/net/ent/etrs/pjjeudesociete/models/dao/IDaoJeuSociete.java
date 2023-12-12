package net.ent.etrs.pjjeudesociete.models.dao;

import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.references.Mecanisme;

import java.util.List;

public interface IDaoJeuSociete extends BaseDao<JeuSociete> {
    List<JeuSociete> getLesJeuSocieteParMecanisme(Mecanisme mecanisme);
}
