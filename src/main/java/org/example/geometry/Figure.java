package org.example.geometry;

import lombok.Getter;

@Getter

public abstract class Figure {
    Point point;

    public Figure(Point point) {
        this.point = point;
    }


    public abstract double area();
}