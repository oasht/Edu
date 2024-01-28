package org.example.geometry;//import example_1_1_1.Point;

import java.util.Objects;

public class Line<T extends Point> implements Measurable, Cloneable, Moveable {
    private T first;
    private T second;

    private Line(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <E extends Point> Line <E> of(E first, E second){
        return new Line<>(first, second);
    }


    public static  Line <Point> of(int x, int y, int x2, int y2) {
        return new Line<> (new Point(x, y), new Point(x2, y2));

    }

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


    @Override
    public void move(int deltaX, int deltaY) {
        first.move(deltaX, deltaY);
        second.move(deltaX, deltaY);
    }

    public double length() {
        return first.distanceTo(second);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line<T> line = (Line<T>) obj;

        if (!first.getClass().equals(line.first.getClass()) || !second.getClass().equals(line.second.getClass())) {
            throw new IllegalArgumentException("Несовместимые типы точек для сравнения линий.");
        }

        return Objects.equals(first, line.first) && Objects.equals(second, line.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public Line<T> clone() {
        try {
            Line<T> line = (Line<T>) super.clone();
            line.first = (T) line.first.clone();
            line.second = (T) line.second.clone();

            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Line with " + first + " to " + second + "";
    }
}
