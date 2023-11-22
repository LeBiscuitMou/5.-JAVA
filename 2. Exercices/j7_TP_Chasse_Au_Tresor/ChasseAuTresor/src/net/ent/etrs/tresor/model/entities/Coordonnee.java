package net.ent.etrs.tresor.model.entities;

import java.util.Objects;

public class Coordonnee {
    private int y;
    private int x;

    public Coordonnee(int y, int x) {
        this.setY(y);
        this.setX(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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

    @Override
    public String toString() {
        return "Coordonnee{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
