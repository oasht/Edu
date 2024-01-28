package org.example.geometry;

import lombok.Getter;

import java.util.*;

@Getter
public class PolyLine implements Measurable, Moveable {
    List<Point> points;

    public PolyLine(Point... points) {
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public void adding(Point... points_new) {
        Collections.addAll(this.points, points_new);
    }

    public void adding(List<Point> points_new) {
        this.points.addAll(points_new);
    }

    public double length() {
        double sum = 0;
        if (points.size() > 1) {
            for (int i = 1; i < points.size(); i++) {
                sum += Line.of(points.get(i - 1), points.get(i)).length();
            }
            return sum;
        }
        return sum;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        for (Point point : points) {
            point.move(deltaX, deltaY);
        }
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PolyLine p = (PolyLine) obj;
        return Objects.equals(points, p.points);
    }
    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
    public String toString() {
        return "Line" + points;
    }
}
