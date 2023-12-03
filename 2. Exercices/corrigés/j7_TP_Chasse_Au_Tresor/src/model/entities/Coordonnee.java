package model.entities;

import model.exceptions.CoordonneeException;
import model.references.C;

import java.util.Objects;

public class Coordonnee {
    private int y; // ligne
    private int x; //colonne

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    private void isCorrect(int nb) throws CoordonneeException {
        if(nb<0 || nb>= C.DIM){
            throw new CoordonneeException("ERR: le no de ligne ou de colonne est incorrect");
        }
    }
    public void setY(int y) throws CoordonneeException {
        isCorrect(y);
        this.y = y;
    }

    public void setX(int x) throws CoordonneeException {
        isCorrect(x);
        this.x = x;
    }

    public Coordonnee(int y,int x) throws CoordonneeException {
        setY(y);
        setX(x);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("y=").append(y);
        sb.append(", x=").append(x);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnee that = (Coordonnee) o;
        return y == that.y && x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
