package org.example.geometry;//import example_1_1_1.Point;

import org.example.units.Fraction;

public class Line implements Measurable, Cloneable{
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

    public double length() {
        double cath1 = Math.abs(second.y - first.y);
        double cath2 = Math.abs(second.x - first.x);
        return (double)Math.hypot(cath1, cath2);
    }

    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null)return false;
        if(getClass()!=obj.getClass()) return false;
        Line l=(Line)obj;
        return this.first.x == l.first.x && this.first.y == l.first.y &&
                this.second.x == l.second.x && this.second.y == l.second.y;
    }

    @Override
    public Object clone(){
        try {
            return (Line) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        return "Линия от {"+first.x+";"+first.y+"} до {"+second.x+";"+second.y+"}";
    }
}
