package org.example;

public class Rectangle extends Figure{
    private Point leftupPoint;
    private int first_side;
    private int second_side;

    public Rectangle(Point leftupPoint, int first_side, int second_side) {
        super(leftupPoint);
        this.first_side = first_side;
        this.second_side = second_side;
    }

    @Override
    public double area() {
        return first_side*second_side;
    }
}
