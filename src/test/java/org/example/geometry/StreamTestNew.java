package org.example.geometry;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTestNew {
    @Test
    void StreamPointTest(){
        List<Point> points = List.of(
                new Point(3, 4),
                new Point(5, -3),
                new Point(3, 4),
                new Point(1, 2),
                new Point(-7, 8),
                new Point(5, 6)
        );

        List<Point> distinctPoints = points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(p -> p.x))
                .map(p -> new Point(p.x, Math.abs(p.y)))
                .toList();

        PolyLine polyline = new PolyLine();
        polyline.adding(distinctPoints);
        System.out.println(polyline);
    }


    @Test
    void StreamContactsTest(){
        Map<String, Integer> contacts = new HashMap<>();
        contacts.put("Вася", 5);
        contacts.put("Петя", 3);
        contacts.put("Аня", 5);
        contacts.put("Антон", null);

        Map<Integer, String> result = contacts.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .map(entry -> Map.entry(entry.getValue(), toTitleCase(entry.getKey())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,
                                Collectors.joining(", ", "[", "]"))));

        System.out.println(result);
    }

    private static String toTitleCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
