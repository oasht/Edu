package org.example.geometry;

import java.util.Objects;

public class Point implements Cloneable{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y=y;
    }

    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null)return false;
        if(getClass()!=obj.getClass()) return false;
        Point p=(Point)obj;
        return this.x == p.x && this.y == p.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public String toString() {
        return "{" + x +";"+ y +
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
