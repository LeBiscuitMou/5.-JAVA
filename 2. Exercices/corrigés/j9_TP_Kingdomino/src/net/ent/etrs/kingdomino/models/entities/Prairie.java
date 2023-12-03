package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.TuileException;

import java.util.Objects;

public class Prairie extends Tuile{

    private char symbol = '§';
    protected Prairie(int nbCouronne) throws TuileException {
        super(nbCouronne);
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prairie prairie = (Prairie) o;
        return symbol == prairie.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "Prairie{" +
                "symbol=" + symbol +
                "} " + super.toString();
    }
}
