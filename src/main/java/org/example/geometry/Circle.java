package org.example.geometry;

public class Circle extends Figure implements Moveable{
    int radius;

    public Circle(Point point, int radius) {
        super(point);
        this.radius = radius;
    }
    @Override
    public void move(int deltaX, int deltaY) {
        getPoint().move(deltaX, deltaY);
    }
    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle with " + getPoint() + " with radius " + radius;
    }
}
