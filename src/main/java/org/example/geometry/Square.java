package org.example.geometry;

public class Square extends Figure implements Chainable,Moveable {
    private int length;

    public Square(Point leftupPoint, int length) {
        super(leftupPoint);
        if (length < 0)
            throw new IllegalArgumentException();
        this.length = length;
    }


    private int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 0) throw new IllegalArgumentException();
        this.length = length;
    }


    public Square(int x, int y, int length) {
        this(new Point(x, y), length);
    }

    @Override
    public String toString() {
        return "Square starts with " + getPoint() +
                " and it's length=" + length;
    }

    @Override
    public double area() {
        return length * length;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        getPoint().move(deltaX, deltaY);
    }

    @Override
    public PolyLine getLine() {
        return new ClosedPolyLine(
                getPoint(),
                new Point(getPoint().x + length, getPoint().y),
                new Point(getPoint().x + length, getPoint().y - length),
                new Point(getPoint().x, getPoint().y - length)
        );
    }
}
