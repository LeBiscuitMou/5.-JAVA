package net.ent.etrs.pjjeudesociete.models.dao.impl;

import net.ent.etrs.pjjeudesociete.models.dao.IDaoJeuSociete;
import net.ent.etrs.pjjeudesociete.models.entities.JeuSociete;
import net.ent.etrs.pjjeudesociete.models.references.Mecanisme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuSocieteDaoImpl extends MemBaseDao<JeuSociete> implements IDaoJeuSociete {
    @Override
    public List<JeuSociete> getLesJeuSocieteParMecanisme(Mecanisme mecanisme) {
        List<JeuSociete> jeuSocieteList = new ArrayList<>();
        for (JeuSociete jeuSociete : persist.values()) {
            for (Mecanisme mecanisme1 : jeuSociete.getMecanismes()) {
                if (mecanisme1.equals(mecanisme)) {
                    jeuSocieteList.add(jeuSociete);
                }
            }
        }
        return Collections.unmodifiableList(jeuSocieteList);
    }
}