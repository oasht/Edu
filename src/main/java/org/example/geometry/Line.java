package org.example.geometry;//import example_1_1_1.Point;

import java.util.Objects;

public class Line<T extends Point> implements Measurable, Cloneable {
    private T first;
    private T second;

    public Line(T first, T second) {
        this.first = first;
        this.second = second;
    }

//    public Line(int x, int y, int z, int w) {
//        this(new Point(x, y), new Point(z, w));
//
//    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public double length() {
        double cath1 = Math.abs(second.y - first.y);
        double cath2 = Math.abs(second.x - first.x);
        return (double) Math.hypot(cath1, cath2);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Line l = (Line) obj;
        return this.first.x == l.first.x && this.first.y == l.first.y &&
                this.second.x == l.second.x && this.second.y == l.second.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public Line clone() {
        try {
            Line line = (Line) super.clone();
            line.first = line.first.clone();
            line.second = line.second.clone();
            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Линия от " + first + " до " + second + "";
    }
}
