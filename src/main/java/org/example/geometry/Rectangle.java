package org.example.geometry;

public class Rectangle extends Figure implements Chainable {
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
    public PolyLine getLine() {
        PolyLine line = new ClosedPolyLine(
                getPoint(),
                new Point(getPoint().x + firstSide, getPoint().y),
                new Point(getPoint().x + firstSide, getPoint().y - secondSide),
                new Point(getPoint().x, getPoint().y - secondSide)
        );
        return line;
    }
    @Override
    public double area() {
        return firstSide * secondSide;
    }
}
