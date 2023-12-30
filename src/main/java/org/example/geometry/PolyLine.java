package org.example.geometry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public class PolyLine implements Measurable {
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
                sum += new Line(points.get(i - 1), points.get(i)).length();
            }
            return sum;
        }
        return sum;
    }

    public String toString() {
        return "Line" + points;
    }
}
