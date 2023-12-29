package org.example.geometry;

public class Circle extends Figure {
    int radius;

    public Circle(Point point, int radius) {
        super(point);
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }
}
