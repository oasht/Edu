package org.example;//import example_1_1_1.Point;

public class Line {
  private Point first;
   private Point second;

    public Line(Point first, Point second) {
        this.first = first;
        this.second = second;
    }
    public Line(int x, int y, int z, int w )
    {
        this(new Point(x,y), new Point(z,w));

    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }

    public void setFirst(Point first) {
        this.first = new Point(first.x, first.y);
    }

    public void setSecond(Point second) {
        this.second = new Point(second.x, second.y);
    }

    public int length() {
        int cath1 = Math.abs(second.y - first.y);
        int cath2 = Math.abs(second.x - first.x);
        return (int)Math.hypot(cath1, cath2);
    }
    @Override
    public String toString() {
        return "Линия от {"+first.x+";"+first.y+"} до {"+second.x+";"+second.y+"}";
    }
}
