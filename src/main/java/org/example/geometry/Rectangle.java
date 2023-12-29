package org.example.geometry;

public class Rectangle extends Figure {
    private Point leftupPoint;
    private int firstSide;
    private int secondSide;

    public Rectangle(Point leftupPoint, int firstSide, int secondSide) {
        super(leftupPoint);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }
    
    public boolean isSquare(){
        return firstSide == secondSide;
    }

    @Override
    public double area() {
        return firstSide * secondSide;
    }
}
