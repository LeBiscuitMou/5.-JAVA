package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.TuileException;

import java.util.Objects;

public class Foret extends Tuile{

    private char symbol = '+';
    protected Foret(int nbCouronne) throws TuileException {
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
        Foret foret = (Foret) o;
        return symbol == foret.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "Foret{" +
                "symbol=" + symbol +
                "} " + super.toString();
    }
}
