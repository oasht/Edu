package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Figure {
 Point point;

    public Figure(Point point) {
        this.point = point;
    }

    public abstract double area();
}