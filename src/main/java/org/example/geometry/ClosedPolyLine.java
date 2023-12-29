package org.example.geometry;

public class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(Point... points) {
        super(points);
    }

    @Override
    public int length() {
        return super.length() + new Line(points.get(0),points.get(points.size()-1)).length();
    }
}
