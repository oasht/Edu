package org.example.geometry;

import java.util.Objects;

public class Point implements Cloneable, Moveable{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y=y;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null)return false;
        if(getClass()!=obj.getClass()) return false;
        Point p=(Point)obj;
        return this.x == p.x && this.y == p.y;
    }

    public double distanceTo(Point other) {
        double cath1 = this.x - other.x;
        double cath2 = this.y - other.y;
        return (double) Math.hypot(cath1, cath2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public String toString() {
        return "Point at {" + x +";"+ y +
                "}";}

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
