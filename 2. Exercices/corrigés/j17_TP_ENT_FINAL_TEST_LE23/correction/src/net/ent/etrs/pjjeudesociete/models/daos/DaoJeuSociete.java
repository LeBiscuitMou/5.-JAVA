package net.ent.etrs.pjjeudesociete.models.daos;

import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;

import java.util.List;

public interface DaoJeuSociete extends BaseDao<JeuSociete> {

    List<JeuSociete> getJeuSocieteByMecanisme(Mecanisme mecanisme);

    List<JeuSociete> getJeuSocieteByMaisonEdition(MaisonEdition maisonEdition);
}
