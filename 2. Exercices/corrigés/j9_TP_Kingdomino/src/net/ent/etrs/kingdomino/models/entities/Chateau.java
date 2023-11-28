package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.TuileException;

import java.util.Objects;

public class Chateau extends Tuile{

    private char symbol = '£';

    protected Chateau(int nbCouronne) throws TuileException {
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
        Chateau chateau = (Chateau) o;
        return symbol == chateau.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "Chateau{" +
                "symbol=" + symbol +
                "} " + super.toString();
    }
}
