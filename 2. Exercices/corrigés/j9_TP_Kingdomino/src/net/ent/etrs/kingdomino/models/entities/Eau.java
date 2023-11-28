package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.TuileException;

import java.util.Objects;

public class Eau extends Tuile{

    private char symbol = '€';
    protected Eau(int nbCouronne) throws TuileException {
        super(nbCouronne);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eau eau = (Eau) o;
        return symbol == eau.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "Eau{" +
                "symbol=" + symbol +
                "} " + super.toString();
    }
}
