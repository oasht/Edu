package org.example.geometry;

import lombok.ToString;

@ToString
public class Triangle extends Figure implements Chainable, Moveable{
    private Point two;
    private Point three;

    public Triangle(Point point, Point two, Point three) {
        super(point);
        this.two = two;
        this.three = three;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        getPoint().move(deltaX, deltaY);
        two.move(deltaX, deltaY);
        three.move(deltaX, deltaY);
    }
    @Override
    public double area() {
        return Math.abs((1.0 / 2) * (
                (two.y + point.y) * (point.x - two.x) +
                        (point.y + three.y) * (three.x - point.x) -
                        (two.y + three.y) * (three.x - two.x))
        );
    }
    @Override
    public PolyLine getLine() {
        return new ClosedPolyLine(
                getPoint(),
                two,
                three
        );
    }

    @Override
    public String toString() {
        return "Triangle starts with " + getPoint() + " with vertices " + two + ", " + three;
    }
}
