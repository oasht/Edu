package org.example.geometry;

import lombok.ToString;

@ToString
public class Triangle extends Figure {
    private Point two;
    private Point three;

    public Triangle(Point point, Point two, Point three) {
        super(point);
        this.two = two;
        this.three = three;
    }

    @Override
    public double area() {
        return Math.abs((1.0 / 2) * (
                (two.y + point.y) * (point.x - two.x) +
                        (point.y + three.y) * (three.x - point.x) -
                        (two.y + three.y) * (three.x - two.x))
        );
    }
}
