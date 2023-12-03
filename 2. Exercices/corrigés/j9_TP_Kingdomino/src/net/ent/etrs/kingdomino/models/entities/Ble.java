package net.ent.etrs.kingdomino.models.entities;

import net.ent.etrs.kingdomino.models.entities.exceptions.TuileException;

import java.util.Objects;

public class Ble extends Tuile{

    private char symbol = '!';

    protected Ble(int nbCouronne) throws TuileException {
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
        Ble ble = (Ble) o;
        return symbol == ble.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return "Ble{" +
                "symbol=" + symbol +
                "} " + super.toString();
    }
}
