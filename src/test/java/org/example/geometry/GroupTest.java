package org.example.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    public void testGroups() {

        Point point = new Point(0, 0);
        Line<Point> line = Line.of(0,0, 1, 1);
        Circle circle = new Circle(new Point(0,0), 2);
        Square square = new Square(new Point(0, 0), 4);
        Triangle triangle = new Triangle(new Point(1, 1), new Point(2, 3), new Point(3, 1));

        Group group1 = new Group("First group");
        group1.add(point);
        group1.add(line);
        group1.add(circle);

        Group group2 = new Group("Second group");
        group2.add(square);
        group2.add(triangle);

        System.out.println("Before:\n");
        printCoordinates(group1);
        printCoordinates(group2);

        group1.move(5, 5);
        group2.move(10, 10);

        System.out.println("\nAfter:\n");
        printCoordinates(group1);
        printCoordinates(group2);

    }

    private static void printCoordinates(Group group) {
        System.out.println(group.getName()+":");
        for (Moveable moveable : group.getMoveables()) {
            System.out.println(moveable);
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
}