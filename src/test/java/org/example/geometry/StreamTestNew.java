package org.example.geometry;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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

        PolyLine polyline = points.stream()
                .distinct()
                .sorted(Comparator.comparingInt(p -> p.x))
                .map(p -> new Point(p.x, Math.abs(p.y)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), PolyLine::new));

        System.out.println(polyline);
    }


    @Test
    void StreamContactsTest(){
        Map<String, Integer> contacts = readContactsFromFile("contacts.txt");

        Map<Integer, String> result = contacts.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .map(entry -> Map.entry(entry.getValue(), toTitleCase(entry.getKey())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,
                                Collectors.joining(", ", "[", "]"))));

        System.out.println(result);
    }

    private static Map<String, Integer> readContactsFromFile(String filename) {
        Map<String, Integer> contacts = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    Integer number = Integer.parseInt(parts[1].trim());
                    contacts.put(name, number);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private static String toTitleCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
