package org.example;

public class Square extends Figure{
    private Point leftupPoint;
    private int length;

    public Square(Point leftupPoint, int length) {
        super(leftupPoint);
        if(length<0)
          throw new IllegalArgumentException();
        this.length = length;
    }


    private int getLength(){return length;}

    public void setLength(int length) {
        if(length<0)
        throw new IllegalArgumentException();
        this.length = length;
    }


    public Square (int x, int y, int length)
    {
        this(new Point(x,y),length);
    }

    @Override
    public String toString() {
        return "Square starts at "+ leftupPoint +
                " and it's length=" + length;
    }

    @Override
    public double area() {
        return length*length;
    }
}
