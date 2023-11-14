package net.ent.etrs.simugladiateur.modeles.entities;

import net.ent.etrs.simugladiateur.modeles.entities.references.ConstanteMetier;

public class Thrace extends Gladiateur {
    public Thrace(String nom, int experience) {
        super(nom, experience);
    }

    @Override
    public int chanceVaincre(Gladiateur g2) {
        if (g2 instanceof Mirmillon) {
            return ConstanteMetier.POURCENTAGE_RACE * -1;
        }
        if (g2 instanceof Crepullaire) {
            return ConstanteMetier.POURCENTAGE_RACE;
        }
        return 0;
    }
}
