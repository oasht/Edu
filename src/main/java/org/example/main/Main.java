package org.example.main;

import lombok.extern.log4j.Log4j2;
import org.example.cities.City;
import org.example.cities.SmartCity;
import org.example.entities.Cat;
import org.example.entities.Meowable;
import org.example.entities.birds.Bird;
import org.example.geometry.Chainable;
import org.example.geometry.Figure;
import org.example.geometry.Measurable;
import org.example.geometry.PolyLine;
import org.example.geometry.Point;

import java.util.Collection;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@Log4j2
public class Main {
    public static void main(String[] args) {

//        City city = new City("New York");
//        SmartCity city2 = new SmartCity("Boston");
//
//        city2.addRoad(city, 10);
//        System.out.println(city2+"\n"+city);

        // create_and_print_cities();

        meow(new Cat("a"), new Cat("b"));
    }


    public static void create_and_print_cities() {
        City a = new SmartCity("A");
        City d = new SmartCity("D");
        City b = new City("B");
        City c = new City("C");
        City e = new City("E");
        a.addRoad(b, 1);
        a.addRoad(c, 1);
        d.addRoad(b, 1);
        d.addRoad(e, 1);
        e.addRoad(c, 1);
        b.addRoad(c, 1);

        List<City> cities = List.of(a, b, c, d, e);
        for (City city : cities) {
            System.out.println(city);
        }

    }


    public static double sum(Number... numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static String sing(Bird... birds) {
        StringBuilder s = new StringBuilder();
        for (Bird b : birds) {
            s.append(b.sing());
            s.append("\n");
        }
        return s.toString().trim();
    }

    public static double totalArea(Figure... figures) {
        double sum = 0;
        for (Figure f : figures) {
            sum += f.area();
        }
        return sum;
    }

    public static void meow(Meowable... meowables) {
        for (Meowable m : meowables) {
            m.meow();
        }
    }

    public static double totalLength(Measurable... measurables) {
        double tot_length = 0;
        for (Measurable m : measurables) {
            tot_length += m.length();
        }
        return tot_length;
    }

    public static PolyLine unitedLine(Collection<Chainable> chainables) {

        PolyLine res = new PolyLine();
        for (Chainable ch : chainables) {
            for(Point point : ch.getLine().getPoints()){
                res.adding(point);
            }
        }
        return  res;
    }

}