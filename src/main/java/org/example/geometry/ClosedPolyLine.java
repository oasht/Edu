package org.example.geometry;

public class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(Point... points) {
        super(points);
    }

    @Override
    public double length() {
        return super.length() + Line.of(points.get(0),points.get(points.size()-1)).length();
    }
}
