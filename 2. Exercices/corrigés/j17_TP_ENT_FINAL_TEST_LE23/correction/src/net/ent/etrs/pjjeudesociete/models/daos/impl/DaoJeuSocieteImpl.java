package net.ent.etrs.pjjeudesociete.models.daos.impl;

import net.ent.etrs.pjjeudesociete.models.daos.DaoJeuSociete;
import net.ent.etrs.pjjeudesociete.models.daos.MemBaseDao;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.MaisonEdition;
import net.ent.etrs.pjjeudesociete.models.entities.references.Mecanisme;

import java.util.ArrayList;
import java.util.List;

public class DaoJeuSocieteImpl extends MemBaseDao<JeuSociete> implements DaoJeuSociete {
    @Override
    public List<JeuSociete> getJeuSocieteByMecanisme(Mecanisme mecanisme) {

        List<JeuSociete> result = new ArrayList<>();
        for (JeuSociete jeu : this.persist.values()) {
            if (jeu.getMecanismes().contains(mecanisme)) {
                result.add(jeu);
            }
        }
        return result;
    }

    @Override
    public List<JeuSociete> getJeuSocieteByMaisonEdition(MaisonEdition maisonEdition) {
        List<JeuSociete> result = new ArrayList<>();
        for (JeuSociete jeu : this.persist.values()) {
            if (jeu.getMaisonEdition().equals(maisonEdition)) {
                result.add(jeu);
            }
        }
        return result;
    }
}
